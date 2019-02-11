package ru.atkachev.tm.entity;

import ru.atkachev.tm.util.ValidateSession;

import java.util.UUID;

public class Session {

    private String id;
    private String userId;
    private long timeStamp;
    private String sign;

    public Session(String userId){
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
        this.sign = ValidateSession.sign(id, userId, timeStamp);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getSign() {
        return sign;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
}
