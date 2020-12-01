package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.CourseInfoEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CourseInfoDAOimpl implements GeneralDAO<CourseInfoEntity, Integer> {

  public List<CourseInfoEntity> findAll() throws SQLException {
    List<CourseInfoEntity> coursesInfo;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      coursesInfo = session.createQuery("from CourseInfoEntity ").getResultList();
      session.getTransaction().commit();
    }

    return coursesInfo;
  }

  public CourseInfoEntity findById(Integer id) throws SQLException {
    CourseInfoEntity courseInfo = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      courseInfo = session.get(CourseInfoEntity.class, id);
      session.getTransaction().commit();
    }

    return courseInfo;
  }

  public void create(CourseInfoEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(CourseInfoEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      CourseInfoEntity courseInfo = session.get(CourseInfoEntity.class, id);
      if (courseInfo != null) {
        session.delete(courseInfo);
      }
      session.getTransaction().commit();
    }
  }
}
