package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.MessageEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class MessageDAOimpl implements GeneralDAO<MessageEntity, Integer> {

  public List<MessageEntity> findAll() throws SQLException {
    List<MessageEntity> messages;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      messages = session.createQuery("from MessageEntity ").getResultList();
      session.getTransaction().commit();
    }

    return messages;
  }

  public MessageEntity findById(Integer id) throws SQLException {
    MessageEntity message = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      message = session.get(MessageEntity.class, id);
      session.getTransaction().commit();
    }

    return message;
  }

  public void create(MessageEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(MessageEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      MessageEntity message = session.get(MessageEntity.class, id);
      if (message != null) {
        session.delete(message);
      }
      session.getTransaction().commit();
    }
  }
}
