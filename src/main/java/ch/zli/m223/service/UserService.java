package ch.zli.m223.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Person;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager entityManager;
    
    @Transactional
    public Person createUser(Person person) {
        return entityManager.merge(person);
        
    }
  

    public Optional<Person> findByMail(String email){
        return entityManager
        .createQuery("SELECT p FROM Person p WHERE p.email = :email", Person.class).setParameter("email", email)
        .getResultStream()
        .findFirst();
    }

   
}
    

