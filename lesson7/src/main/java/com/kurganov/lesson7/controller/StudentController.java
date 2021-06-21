/*
1. Создать сущность Student с полями id, name, age.
2. Сконфигурировать Spring JPA контекст.
3. Создать репозиторий для вставки, удаления, изменения и просмотра студентов.
4. Создать контроллер с методами, которые вызывают методы репозитория.
5. Создать JSP-страницу, на которой в таблице отобразить список студентов с кнопками для добавления, обновления и удаления записей.
6. Привязать к каждой кнопке действие, которое будет передаваться на контроллер.
 */

package com.kurganov.lesson7.controller;

import com.kurganov.lesson7.entity.Student;
import com.kurganov.lesson7.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentServiceImpl studentService;

    @Autowired
    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("userList", studentService.findAll());
        model.addAttribute("newStudent", new Student());
        return "students";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newStudent(@Valid @ModelAttribute("newStudent") Student student, Model model) {
        studentService.save(student);
        return "redirect:/students";
    }


    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("editStudent", student);
        return "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEdit(@Valid @ModelAttribute("editStudent") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        studentService.delete(studentService.findById(id));
        return "redirect:/students";
    }

}
