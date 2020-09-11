package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserInterface {

    public void add(User user);//保存

    public void delete(Long id);//删除

    public void update(Long id,User user);//修改

    public List<User> findAll();//查询

    public User findOne(Long id);//根据id查询

    public User findByUserName(String username);//条件查询

    public List<User> findByIdIn(List ids);

    public User findByName(String name);//自定义条件查询
}
