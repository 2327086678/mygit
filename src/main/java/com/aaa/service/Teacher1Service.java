package com.aaa.service;
import com.aaa.dao.Teacher1Dao;
import com.aaa.entity.Teacher1;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class Teacher1Service{
    @Resource
    Teacher1Dao teacher1Dao;
    public List<Teacher1> queryStu(){
        return teacher1Dao.selectAll();
    }

    public int addStu(Teacher1 teacher1){
        int insert = teacher1Dao.insert(teacher1);
        return insert;
    }
    public int delStu(Teacher1 teacher1){
        System.out.println(teacher1);
        int i = teacher1Dao.deleteByPrimaryKey(teacher1.getTid());
        return i;
    }
    public int upStu(Teacher1 teacher1){
        int i = teacher1Dao.updateByPrimaryKey(teacher1);
        return i;
    }
}
