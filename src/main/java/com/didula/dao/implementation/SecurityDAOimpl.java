package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.SecurityEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class SecurityDAOimpl implements GeneralDAO<SecurityEntity, Integer> {

  public List<SecurityEntity> findAll() throws SQLException {
    List<SecurityEntity> securities;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      securities = session.createQuery("from SecurityEntity ").getResultList();
      session.getTransaction().commit();
    }

    return securities;
  }

  public SecurityEntity findById(Integer id) throws SQLException {
    SecurityEntity security = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      security = session.get(SecurityEntity.class, id);
      session.getTransaction().commit();
    }

    return security;
  }

  public void create(SecurityEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(SecurityEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      SecurityEntity security = session.get(SecurityEntity.class, id);
      if (security != null) {
        session.delete(security);
      }
      session.getTransaction().commit();
    }
  }
}
