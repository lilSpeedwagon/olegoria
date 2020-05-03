package notification_provider;

import java.util.List;

import notification.INotification;

public interface INotificationProvider {
    void Store(List<INotification> notifications);
    List<INotification> Load();
}
