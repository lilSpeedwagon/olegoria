package com.olegoria.notificationservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import notification.INotification;
import notification.ITrigger;
import notification_provider.INotificationProvider;
import notification_provider.StorageNotificationProvider;

public class NotificationService extends Service {
    private static Logger logger = Logger.getLogger(NotificationService.class.getName());
    private INotificationProvider notificationProvider;
    private Map<NotificatorType, INotificator> notificators;

    @Override
    public void onCreate()
    {
        logger.log(Level.INFO, "Init notification service.");
        notificationProvider = new StorageNotificationProvider();
        notificators.put(NotificatorType.TopScreenNotificator, new TopScreenNotificator());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logger.log(Level.INFO, "Starting notification service.");

        boolean isRestarted = (flags & START_FLAG_RETRY) == 0;

        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        logger.log(Level.INFO, "Stopping notification service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void checkNotificationTriggers()    {
        List<INotification> notificationList = notificationProvider.Load();

        for (INotification n : notificationList) {
            try {
                List<ITrigger> triggers = n.getTriggers();

                for (ITrigger t : triggers) {
                    if (t.isReady())    {
                        logger.log(Level.INFO, "Trigger " + t.toString() + " is ready.");
                        notify(n);
                    }
                }
            }
            catch (NotificationException e)    {
                logger.log(Level.SEVERE, "Cannot handle notification " + n.toString() +
                        ". Error: " + e.getMessage());
            }

        }
    }

    private void notify(INotification notification) throws NotificationException {
        for(NotificatorType type : notification.getNotificatorTypes()) {
            INotificator notificator = notificators.get(type);

            if (notificator == null) {
                throw new NotificationException("Notificator of type " + type.toString() + " not found.");
            }

            notificator.notify(notification);
        }
    }


}
