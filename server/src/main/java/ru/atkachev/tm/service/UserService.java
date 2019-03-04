package ru.atkachev.tm.service;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.UserRepository;
import javax.persistence.EntityManager;

public class UserService {

    private IServiceLocator serviceLocator;
    public UserService(final IServiceLocator serviceLocator){
        this.serviceLocator = serviceLocator;
    }

    private EntityManager createEntityManager(){
        return serviceLocator.getEntityManagerFactory().createEntityManager();
    }

    public UserRepository getRepository(){
        return new UserRepository(createEntityManager());
    }

    public User createUser(
            final String login,
            final String firstName,
            final String lastName,
            final String password
    ) {
        if(login == null || login.isEmpty()) return null;
        if(firstName == null || firstName.isEmpty()) return null;
        if(lastName== null || lastName.isEmpty()) return null;
        if(password == null || password.isEmpty()) return null;
        UserRepository repository = getRepository();
        repository.begin();
        User user = repository.createUser(login, firstName, lastName, password);
        repository.commit();
        repository.close();
        return user;
    }

    public User updateUser(
            final String userId,
            final String login,
            final String password,
            final String firstName,
            final String lastName,
            final Role role){
        UserRepository repository = getRepository();
        repository.begin();
        User user = repository.updateUser(userId, login, password, firstName, lastName, role);
        repository.commit();
        repository.close();
        return user;
    }

    public void removeUser(String userId){
//        if (userId == null)
        UserRepository repository = getRepository();
        repository.begin();
        repository.removeUser(userId);
        repository.commit();
        repository.close();
    }

    public User getUserById(String userId){
        if(userId == null || userId.isEmpty()) return null;
        UserRepository repository = getRepository();
        return repository.getUserById(userId);
    }

    public User getUserByLogin(String login){
        if(login == null || login.isEmpty()) return null;
        UserRepository repository = getRepository();
        return repository.getUserByLogin(login);
    }

    public boolean doesUserExist(final String login, final String password) {
        if(login == null || login.isEmpty()) return false;
        if(password == null || password.isEmpty()) return false;
        UserRepository repository = getRepository();
        final User user = repository.getUserByLogin(login);
        if(user == null) return false;
        return true;
    }

}
