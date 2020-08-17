package com.aaa.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Customer implements UserDetails {

    private Integer cid;
    private String cname;
    private String pwd;
    private Integer sex;
    private Integer isexpired;// 是否过期
    private Integer islocked;// 是否上锁
    private Integer isCreExpired;// 认证是否过期
    private Integer isenable;// 是否禁用

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(Integer isexpired) {
        this.isexpired = isexpired;
    }

    public Integer getIslocked() {
        return islocked;
    }

    public void setIslocked(Integer islocked) {
        this.islocked = islocked;
    }

    public Integer getIsCreExpired() {
        return isCreExpired;
    }

    public void setIsCreExpired(Integer isCreExpired) {
        this.isCreExpired = isCreExpired;
    }

    public Integer getIsenable() {
        return isenable;
    }

    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 设置密码
     * @return
     */
    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.cname;
    }

    /**
     * 账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.isexpired==1;
    }

    /**
     * 账户是否被锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.islocked == 1;
    }

    /**
     * 凭证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCreExpired == 1;
    }

    /**
     * 是否可用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return this.isenable == 1;
    }
}
