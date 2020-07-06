package com.boss.learning.controller;

import com.boss.learning.bean.Student;
import com.boss.learning.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControler {
    @Autowired
    StudentMapper mapper;

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable("id") Integer id){
        return mapper.selectByPrimaryKey(id);
    }
}
