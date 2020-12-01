package com.didula.dao.implementation;

import com.didula.dao.GeneralDAO;
import com.didula.manager.SessionManager;
import com.didula.model.ModuleEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ModuleDAOimpl implements GeneralDAO<ModuleEntity, Integer> {

  public List<ModuleEntity> findAll() throws SQLException {
    List<ModuleEntity> modules;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      modules = session.createQuery("from ModuleEntity ").getResultList();
      session.getTransaction().commit();
    }

    return modules;
  }

  public ModuleEntity findById(Integer id) throws SQLException {
    ModuleEntity module = null;

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      module = session.get(ModuleEntity.class, id);
      session.getTransaction().commit();
    }

    return module;
  }

  public void create(ModuleEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
  }

  public void update(ModuleEntity entity) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
    }
  }

  public void delete(Integer id) throws SQLException {
    try(Session session = SessionManager.getSession()) {
      session.beginTransaction();
      ModuleEntity module = session.get(ModuleEntity.class, id);
      if (module != null) {
        session.delete(module);
      }
      session.getTransaction().commit();
    }
  }
}
