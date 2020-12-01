package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.GenderEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class GenderDAOimpl implements GeneralDAO<GenderEntity, Integer> {

  public List<GenderEntity> findAll() throws SQLException {
    List<GenderEntity> genders;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      genders = session.createQuery("from GenderEntity ").getResultList();
      session.getTransaction().commit();
    }

    return genders;
  }

  public GenderEntity findById(Integer id) throws SQLException {
    GenderEntity gender = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      gender = session.get(GenderEntity.class, id);
      session.getTransaction().commit();
    }

    return gender;
  }

  public void create(GenderEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(GenderEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      GenderEntity gender = session.get(GenderEntity.class, id);
      if (gender != null) {
        session.delete(gender);
      }
      session.getTransaction().commit();
    }
  }
}
