package org.kurganov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.kurganov.entity.Student;

import java.util.List;

public class StudentDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public StudentDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    private static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        return new Configuration().configure().buildSessionFactory();
    }

    public void persist(Student student) {
        getCurrentSession().save(student);
    }

    public void update(Student student) {
        getCurrentSession().update(student);
    }

    public Student findById(Long id) {
        Student student = getCurrentSession().get(Student.class, id);
        return student;
    }

    public void delete(Student student) {
        currentSession.delete(student);
    }

    public List<Student> findAll() {
        List<Student> students = getCurrentSession().createQuery("from Student", Student.class).list();
        return students;
    }

    public void deleteAll() {
        List<Student> students = findAll();
        for (Student o: students) {
            delete(o);
        }
    }

}
