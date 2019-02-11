package ru.atkachev.tm.util;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Session;

public class ValidateSession {

    public static boolean validate(Session session){
        if (session.getId() == null){
            return false;
        }
        if (session.getUserId() == null){
            return false;
        }
        if (session.getTimeStamp() != 0) {
            return false;
        }
        return session.getSign().equals(sign(session.getId(), session.getUserId(), session.getTimeStamp()));
    }

    public static String sign(String sessionId, String userId, long timeStamp){
        String sign = "Session{" +
                "id='" + sessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
        String salt = "asdf";
        int count = 23454;
        for (int i = 0; i < count; i++){
            sign = DigestUtils.md5Hex(salt + sign + salt);
        }
        return sign;
    }
}
