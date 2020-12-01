package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.AnswerEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class AnswerDAOimpl implements GeneralDAO<AnswerEntity, Integer> {

  public List<AnswerEntity> findAll() throws SQLException {
    List<AnswerEntity> answers;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      answers = session.createQuery("from AnswerEntity ").getResultList();
      session.getTransaction().commit();
    }

    return answers;
  }

  public AnswerEntity findById(Integer id) throws SQLException {
    AnswerEntity answer = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      answer = session.get(AnswerEntity.class, id);
      session.getTransaction().commit();
    }

    return answer;
  }

  public void create(AnswerEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(AnswerEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      AnswerEntity answer = session.get(AnswerEntity.class, id);
      if (answer != null) {
        session.delete(answer);
      }
      session.getTransaction().commit();
    }
  }
}
