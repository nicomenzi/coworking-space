package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.BuchungGeraet;
import ch.zli.m223.model.BuchungRaum;

@ApplicationScoped
public class BuchungService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public BuchungRaum createBuchungRaum(BuchungRaum buchungRaum) {
        entityManager.persist(buchungRaum);
        return buchungRaum;
    }

    @Transactional
    public void deleteBuchungRaum(Long id) {
        var entity = entityManager.find(BuchungRaum.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public BuchungGeraet createBuchungGeraet(BuchungGeraet buchungGeraet) {
        return entityManager.merge(buchungGeraet);
    }

    @Transactional
    public void deleteBuchungGeraet(Long id) {
        var entity = entityManager.find(BuchungGeraet.class, id);
        entityManager.remove(entity);
    }

    public List<BuchungRaum> getBuchungRaum() {
        var query = entityManager.createQuery("FROM BuchungRaum", BuchungRaum.class);
        return query.getResultList();
    }

    public List<BuchungGeraet> getBuchungGeraet() {
        var query = entityManager.createQuery("FROM BuchungGeraet", BuchungGeraet.class);
        return query.getResultList();
    }

    public BuchungRaum updateBuchungRaum(BuchungRaum buchungRaum) {
        return entityManager.merge(buchungRaum);
    }




     
    
}
