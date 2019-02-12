package ru.atkachev.tm.util;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Session;

public class ValidateSession {

    public static void validate(Session session){
        if (session == null) throw new RuntimeException();
        if (session.getId() == null) throw new RuntimeException();
        if (session.getUserId() == null) throw new RuntimeException();
        if (session.getTimeStamp() == 0) throw new RuntimeException();
        if (!session.getSign().equals(
            ValidateSession.sign(
                session.getId(),
                session.getUserId(),
                session.getTimeStamp()
            )
        )) throw new RuntimeException();
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
