package com.didula.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "module", schema = "lab_5_db")
public class ModuleEntity {
  private Integer id;
  private String moduleName;
  private Timestamp deadlineDatetime;
  private Byte completed;
  private Byte overdue;
  private CourseInfoEntity courseInfoByCourseInfoId;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "module_name")
  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  @Basic
  @Column(name = "deadline_datetime")
  public Timestamp getDeadlineDatetime() {
    return new Timestamp(deadlineDatetime.getTime());
  }

  public void setDeadlineDatetime(Timestamp deadlineDatetime) {
    this.deadlineDatetime = new Timestamp(deadlineDatetime.getTime());
  }

  @Basic
  @Column(name = "completed")
  public Byte getCompleted() {
    return completed;
  }

  public void setCompleted(Byte completed) {
    this.completed = completed;
  }

  @Basic
  @Column(name = "overdue")
  public Byte getOverdue() {
    return overdue;
  }

  public void setOverdue(Byte overdue) {
    this.overdue = overdue;
  }

  public ModuleEntity() {
  }

  public ModuleEntity(Integer id, String moduleName, Timestamp deadlineDatetime, Byte completed,
                      Byte overdue, CourseInfoEntity courseInfoByCourseInfoId) {
    this.id = id;
    this.moduleName = moduleName;
    this.deadlineDatetime = new Timestamp(deadlineDatetime.getTime());
    this.completed = completed;
    this.overdue = overdue;
    this.courseInfoByCourseInfoId = courseInfoByCourseInfoId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ModuleEntity that = (ModuleEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) {
      return false;
    }
    if (deadlineDatetime != null ? !deadlineDatetime.equals(that.deadlineDatetime) :
            that.deadlineDatetime != null) {
      return false;
    }
    if (completed != null ? !completed.equals(that.completed) : that.completed != null) {
      return false;
    }
    if (overdue != null ? !overdue.equals(that.overdue) : that.overdue != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
    result = 31 * result + (deadlineDatetime != null ? deadlineDatetime.hashCode() : 0);
    result = 31 * result + (completed != null ? completed.hashCode() : 0);
    result = 31 * result + (overdue != null ? overdue.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "course_info_id", referencedColumnName = "id", nullable = false)
  public CourseInfoEntity getCourseInfoByCourseInfoId() {
    return courseInfoByCourseInfoId;
  }

  public void setCourseInfoByCourseInfoId(CourseInfoEntity courseInfoByCourseInfoId) {
    this.courseInfoByCourseInfoId = courseInfoByCourseInfoId;
  }

  @Override
  public String toString() {
    return  String.format("%3s   %50s   %20s   %10s   %10s   %3s", id, moduleName, deadlineDatetime,
            completed, overdue, courseInfoByCourseInfoId.getId());
  }

}
