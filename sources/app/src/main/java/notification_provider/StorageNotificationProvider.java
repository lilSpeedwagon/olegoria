package notification_provider;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import notification.INotification;

public class StorageNotificationProvider implements INotificationProvider {
    private static Logger logger = Logger.getLogger(StorageNotificationProvider.class.getName());

    public StorageNotificationProvider()   {
        logger.log(Level.INFO, "Storage provider init.");
    }

    @Override
    public void Store(List<INotification> notifications) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<INotification> Load() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
