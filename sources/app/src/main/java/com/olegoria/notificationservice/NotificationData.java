package com.olegoria.notificationservice;

public class NotificationData {
    private String mTitle;
    private String mContent;

    public NotificationData()
    {
        mTitle = "";
        mContent = "";
    }

    public NotificationData(String title, String content)
    {
        mTitle = title;
        mContent = content;
    }

    public String getTitle()   {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }
}
