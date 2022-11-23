package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.BuchungGeraet;
import ch.zli.m223.model.BuchungRaum;
import ch.zli.m223.model.Person;

@ApplicationScoped
public class AdminService {
    
    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Person> getPersonen() {
        var query = entityManager.createQuery("FROM Person", Person.class);
        return query.getResultList();
    }

    @Transactional
    public Person createPerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Transactional
    public void deletePerson(Long id) {
        var entity = entityManager.find(Person.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Person updatePerson( Person person) {
        return entityManager.merge(person);
    }

    @Transactional
    public void deleteBuchungGeraet(BuchungGeraet buchungGeraet) {
        entityManager.remove(buchungGeraet);
    }
    @Transactional
    public void deleteBuchungRaum(Long id) {
        var entity = entityManager.find(BuchungRaum.class, id);
        entityManager.remove(entity);
    }
    @Transactional
    public void deleteBuchungGeraet(Long id) {
        var entity = entityManager.find(BuchungGeraet.class, id);
        entityManager.remove(entity);
    }
    @Transactional
    public BuchungGeraet updateBuchungGeraet(BuchungGeraet buchungGeraet) {
        return entityManager.merge(buchungGeraet);
    }
    @Transactional
    public BuchungRaum updateBuchungRaum(BuchungRaum buchungRaum) {
        return entityManager.merge(buchungRaum);
    }

    



}
