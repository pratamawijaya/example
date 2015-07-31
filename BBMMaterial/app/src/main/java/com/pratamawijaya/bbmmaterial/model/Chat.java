package com.pratamawijaya.bbmmaterial.model;

/**
 * Created by pratama on 6/27/15.
 */
public class Chat {
    private String userName;
    private String messageStatus;
    private String messageTime;
    private String userPicture;
    private String userMessage;

    public Chat() {
    }

    public Chat(String userName, String messageStatus, String messageTime, String userPicture, String userMessage) {
        this.userName = userName;
        this.messageStatus = messageStatus;
        this.messageTime = messageTime;
        this.userPicture = userPicture;
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }
}
