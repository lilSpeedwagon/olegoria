package notification;

import com.olegoria.notificationservice.NotificationData;
import com.olegoria.notificationservice.NotificatorType;

import java.util.List;

public interface INotification {
    List<ITrigger> getTriggers();
    List<NotificatorType> getNotificatorTypes();
    NotificationData getData();
}
