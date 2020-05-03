package notification;

import notification_service.NotificationData;
import notification_service.NotificatorType;

import java.util.List;

public interface INotification {
    List<ITrigger> getTriggers();
    List<NotificatorType> getNotificatorTypes();
    NotificationData getData();
}
