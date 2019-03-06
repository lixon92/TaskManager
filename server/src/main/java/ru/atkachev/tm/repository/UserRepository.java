package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
//import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@NoArgsConstructor
public class UserRepository {

    private EntityManager em;

    public UserRepository(final EntityManager em){
        this.em = em;
    }

    public void begin(){
        em.getTransaction().begin();
    }

    public void commit(){
        em.getTransaction().commit();
    }

    public void close(){
        em.close();
    }

    public User createUser(
            final String login,
            final String firstName,
            final String lastName,
            final String password
    ){
        final User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        em.persist(user);
        return user;
    }

    public User updateUser(
            final String userId,
            final String login,
            final String password,
            final String firstName,
            final String lastName,
            final Role role
    ){
        final User user = new User();
        user.setId(userId);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        em.merge(user);
        return user;
    }

    public void removeUser(final String userId){
        final User user = new User();
        user.setId(userId);
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    public User getUserById(final String userId){
        return em.find(User.class, userId);
    }

    public User getUserByLogin(final String login){
        final Query query = em.createQuery("select u from User u where u.login = :login")
                .setParameter("login", login);
        return (User)query.getSingleResult();
    }

    public void setUserList(final Collection<User> userList){
        em.merge(userList);
    }

    public Collection<User> getUserList(){
        final TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
}
