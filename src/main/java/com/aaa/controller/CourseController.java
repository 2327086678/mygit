package com.aaa.controller;

import com.aaa.dao.CourseDao;
import com.aaa.entity.Course;
import com.aaa.entity.Teacher1;
import com.aaa.service.CourseService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
public class CourseController {
    @Resource
    CourseService courseService;
    @Resource
    CourseDao courseDao;

    @RequestMapping("selectCourse")
    @ResponseBody
    public  List<Course> selectCourse(){
        List<Course> courses = courseService.selectCourse();
        System.out.println(courses);
        return courses;
    }
    @RequestMapping("queryBidCourse")
    @ResponseBody
    public Course queryByidCourse(@RequestBody Course course){
        return courseDao.selectByPrimaryKey(course.getCid());
    }
    @RequestMapping("addCourse")
    @ResponseBody
    public int addStu(@RequestBody Course course){
        System.out.println(1);
        int i = courseService.addCourse(course);
        return i;
    }
    @RequestMapping("delCourse")
    @ResponseBody
    public int delStu(@RequestBody Course course){
        int i = courseService.delCourse(course);
        return i;
    }
    @RequestMapping("upCourse")
    @ResponseBody
    public int upStu(@RequestBody Course course){
        int i = courseService.delCourse(course);
        return i;
    }
}
