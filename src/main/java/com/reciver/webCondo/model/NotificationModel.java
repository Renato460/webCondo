package com.reciver.webCondo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String api_version;
    private String notification_token;

    public NotificationModel(String api_version, String notification_token) {
        this.api_version = api_version;
        this.notification_token = notification_token;
    }

    public NotificationModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getNotification_token() {
        return notification_token;
    }

    public void setNotification_token(String notification_token) {
        this.notification_token = notification_token;
    }
}
