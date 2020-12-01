package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.CourseEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CourseDAOimpl  implements GeneralDAO<CourseEntity, Integer> {

  public List<CourseEntity> findAll() throws SQLException {
    List<CourseEntity> courses;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      courses = session.createQuery("from CourseEntity ").getResultList();
      session.getTransaction().commit();
    }

    return courses;
  }

  public CourseEntity findById(Integer id) throws SQLException {
    CourseEntity course = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      course = session.get(CourseEntity.class, id);
      session.getTransaction().commit();
    }

    return course;
  }

  public void create(CourseEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(CourseEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      CourseEntity course = session.get(CourseEntity.class, id);
      if (course != null) {
        session.delete(course);
      }
      session.getTransaction().commit();
    }
  }
}

