package fr.enterprise.spring_dao;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ItemDao {

  @PersistenceContext
  private EntityManager entityManager;

  Item getById(Long id) {
    return entityManager.find(Item.class, id);
  }

  void save(Item item) {
    entityManager.persist(item);
  }

  void delete(Long id) {
    Item item = getById(id);
    entityManager.remove(item);
  }
  
}
