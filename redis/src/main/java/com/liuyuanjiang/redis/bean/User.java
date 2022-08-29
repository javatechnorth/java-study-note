package com.liuyuanjiang.redis.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3456232569272497427L;

    private int id;

    private String name;

    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
