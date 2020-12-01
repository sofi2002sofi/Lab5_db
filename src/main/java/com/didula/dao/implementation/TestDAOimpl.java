package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.TestEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class TestDAOimpl  implements GeneralDAO<TestEntity, Integer> {

  public List<TestEntity> findAll() throws SQLException {
    List<TestEntity> tests;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      tests = session.createQuery("from TestEntity ").getResultList();
      session.getTransaction().commit();
    }

    return tests;
  }

  public TestEntity findById(Integer id) throws SQLException {
    TestEntity test = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      test = session.get(TestEntity.class, id);
      session.getTransaction().commit();
    }

    return test;
  }

  public void create(TestEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(TestEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      TestEntity test = session.get(TestEntity.class, id);
      if (test != null) {
        session.delete(test);
      }
      session.getTransaction().commit();
    }
  }
}

