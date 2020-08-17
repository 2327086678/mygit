package com.aaa.entity;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;

public class Teacher1 {
    @Id
    @Column
    @KeySql(sql = "select nvl(max(tid),0) + 1 from teacher1",order = ORDER.BEFORE)
    private Integer tid;
    @Column
    private String tname;
    @Column
    private Integer state;
    @Column
    private Integer position;

    public Teacher1() {
    }

    public Teacher1(Integer tid, String tname, Integer state, Integer position) {
        this.tid = tid;
        this.tname = tname;
        this.state = state;
        this.position = position;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", state=" + state +
                ", position=" + position +
                '}';
    }
}
