package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.UserEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserDAOimpl implements GeneralDAO<UserEntity, Integer> {

  public List<UserEntity> findAll() throws SQLException {
    List<UserEntity> users;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      users = session.createQuery("from UserEntity ").getResultList();
      session.getTransaction().commit();
    }

    return users;
  }

  public UserEntity findById(Integer id) throws SQLException {
    UserEntity user = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      user = session.get(UserEntity.class, id);
      session.getTransaction().commit();
    }

    return user;
  }

  public void create(UserEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(UserEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      UserEntity user = session.get(UserEntity.class, id);
      if (user != null) {
        session.delete(user);
      }
      session.getTransaction().commit();
    }
  }
}
