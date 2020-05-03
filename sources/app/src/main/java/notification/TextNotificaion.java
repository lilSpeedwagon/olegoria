package notification;

import notification_service.NotificationData;
import notification_service.NotificatorType;

import java.util.List;

public class TextNotificaion implements INotification {

    private List<NotificatorType> mNotificatorTypes;
    private List<ITrigger> mTriggers;
    private String mTitle;
    private String mText;

    @Override
    public List<ITrigger> getTriggers() {
        return null;
    }

    @Override
    public List<NotificatorType> getNotificatorTypes() {
        return mNotificatorTypes;
    }

    @Override
    public NotificationData getData() {
        return new NotificationData(mTitle, mText);
    }
}
