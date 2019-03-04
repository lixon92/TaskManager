package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.atkachev.tm.util.ValidateSession;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SESSION_TBL")
public class Session {

    @Id
    private String id = UUID.randomUUID().toString();

    @OneToOne
    private User user;
    private String userId;
    private long timeStamp;
    private String sign;

    public Session(final String userId){
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
        this.sign = ValidateSession.sign(id, userId, timeStamp);
    }

    public Session(final User user){
        this.user = user;
        this.id = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
        this.sign = ValidateSession.sign(id, user.getId(), timeStamp);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", userId='" + userId + '\'' +
                ", timeStamp=" + timeStamp +
                ", sign='" + sign + '\'' +
                '}';
    }
}
