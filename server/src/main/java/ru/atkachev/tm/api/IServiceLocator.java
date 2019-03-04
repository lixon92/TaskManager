package ru.atkachev.tm.api;

import javax.persistence.EntityManagerFactory;

public interface IServiceLocator {

    EntityManagerFactory getEntityManagerFactory();

}
