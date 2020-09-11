package com.offcn.repository;

import com.offcn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    //根据方法名拼接条件
    public User findByNameIs(String name);

    public List<User> findByIdIn(List ids);

    //自定义查询
    @Query("select u from User u where u.name=:name")
    public User findByName(String name);
}
