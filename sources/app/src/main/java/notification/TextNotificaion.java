package notification;

import com.olegoria.notificationservice.NotificationData;
import com.olegoria.notificationservice.NotificatorType;

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
        return null;
    }

    @Override
    public NotificationData getData() {
        return new NotificationData(mTitle, mText);
    }
}
