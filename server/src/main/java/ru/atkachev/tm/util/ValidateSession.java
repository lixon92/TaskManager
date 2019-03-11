package ru.atkachev.tm.util;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Session;

public class ValidateSession {

    public static void validate(final Session session){
        if (session == null) throw new RuntimeException();
        if (session.getId() == null) throw new RuntimeException();
        if (session.getUser().getId() == null) throw new RuntimeException();
        if (session.getTimeStamp() == 0) throw new RuntimeException();
        if (!session.getSign().equals(
            ValidateSession.sign(
                session.getId(),
                session.getUser().getId(),
                session.getTimeStamp()
            )
        )) throw new RuntimeException();
    }

    public static String sign(final String sessionId, final String userId, final long timeStamp){
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
