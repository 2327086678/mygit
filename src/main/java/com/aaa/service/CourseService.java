package com.aaa.service;

import com.aaa.dao.CourseDao;
import com.aaa.dao.Teacher1Dao;
import com.aaa.entity.Course;
import com.aaa.entity.Teacher1;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {
    @Resource
    CourseDao courseDao;
    public List<Course> selectCourse(){
        return courseDao.selectAll();
    }
    public List<Course> queryCourse(){
        return courseDao.selectAll();
    }
    public int addCourse(Course course){
        return courseDao.insert(course);
    }
    public int delCourse(Course course){
        System.out.println(course);
        int i = courseDao.deleteByPrimaryKey(course.getCid());
        return i;
    }
    public int upCourse(Course course){
        int i = courseDao.updateByPrimaryKey(course);
        return i;
    }
}
