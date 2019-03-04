package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@NoArgsConstructor
public class UserRepository {

    private EntityManager em;

    final private Map<String, User> userMap = new HashMap<>();

    public UserRepository(final EntityManager em){
        this.em = em;
        init();
    }

    private void init(){
        final User adminUser = new User();
        adminUser.setLogin("admin");
        adminUser.setPassword(DigestUtils.md5Hex("admin"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setRole(Role.ADMIN);
        userMap.put("admin", adminUser);
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
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        userMap.put(user.getId(), user);
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
        User user = new User();
        user.setId(userId);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        em.merge(user);
        return user;
    }

    public void removeUser(String userId){
        User user = new User();
        user.setId(userId);
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    public User getUserById(String userId){
        return em.find(User.class, userId);
    }

    public User getUserByLogin(String login){
        Query query = em.createQuery("select u from User u where u.login = :login")
                .setParameter("login", login);
        return (User)query.getSingleResult();
    }

    public boolean doesUserExist(final String userLogin, final String userPassword){
        for (final User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword)){
                return true;
            }
        }
        return false;
    }

    public String getUserId(final String userLogin, final String userPassword){
        for (final User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword) ){
                return user.getId();
            }
        }
        return null;
    }

    public void setUserList(Collection<User> userList){
        for (User user : userList){
            userMap.put(user.getId(), user);
        }
    }

    public Collection<User> getUserList(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
}
