package com.pratamawijaya.examplerealmio;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by pratama on 12/8/14.
 */
public class User extends RealmObject {
    private String name;
    private int age;
    @Ignore
    private int sessionID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
}
