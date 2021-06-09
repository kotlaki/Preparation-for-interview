package org.kurganov;

import org.kurganov.dao.StudentDao;
import org.kurganov.entity.Student;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        StudentDao studentDao = new StudentDao();

        // Поиск по Ид
//        studentDao.openCurrentSession();
//        System.out.println(studentDao.findById(183403L));
//        studentDao.closeCurrentSession();

        // Добавление в БД
        studentDao.openCurrentSession();
        studentDao.persist(new Student(null, "Test", 3));
        studentDao.closeCurrentSession();

        // выводим все записи
//        studentDao.openCurrentSession();
//        System.out.println(studentDao.findAll());
//        studentDao.closeCurrentSession();

        // добавляем 1000 позиций в БД
//        studentDao.openCurrentSession();
//        for (int i = 0; i <= 1000; i++) {
//            studentDao.persist(new Student(null, String.valueOf(i), 2));
//            System.out.println(i);
//        }
//        studentDao.closeCurrentSession();

        // удаляем позицию
//        studentDao.openCurrentSessionWithTransaction();
//        Student student = studentDao.findById(183408L);
//        studentDao.delete(student);
//        studentDao.closeCurrentSessionWithTransaction();

        // удаляем все
//        studentDao.openCurrentSessionWithTransaction();
//        studentDao.deleteAll();
//        studentDao.closeCurrentSessionWithTransaction();
    }

}
