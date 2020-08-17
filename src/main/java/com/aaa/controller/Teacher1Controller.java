package com.aaa.controller;

import com.aaa.dao.Teacher1Dao;
import com.aaa.entity.Course;
import com.aaa.entity.Teacher1;
import com.aaa.service.Teacher1Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
public class Teacher1Controller {
    @Resource
    Teacher1Service teacher1Service;
    @Resource
    Teacher1Dao teacher1Dao;
    @RequestMapping("Quencher1s")
    public String Quencher1s(Model model){
        List<Teacher1> teacher1s = teacher1Service.queryStu();
        model.addAttribute("teacher1s",teacher1s);
        return "teacher1s";
    }
    @RequestMapping("queryStu")
    @ResponseBody
    public List<Teacher1> queryStu(){
        return teacher1Service.queryStu();
    }
    @RequestMapping("queryByid")
    @ResponseBody
    public Teacher1 queryByid(@RequestBody Teacher1 teacher1){
        return teacher1Dao.selectByPrimaryKey(teacher1.getTid());
    }
    @RequestMapping("addStu")
    @ResponseBody
    public int addStu(@RequestBody Teacher1 teacher1){
        System.out.println(1);
        int i = teacher1Service.addStu(teacher1);
        return i;
    }
    @RequestMapping("delStu")
    @ResponseBody
    public int delStu(@RequestBody Teacher1 teacher1){
        int i = teacher1Service.delStu(teacher1);
        return i;
    }
    @RequestMapping("upStu")
    @ResponseBody
    public int upStu(@RequestBody Teacher1 teacher1){
        int i = teacher1Service.upStu(teacher1);
        return i;
    }

}
