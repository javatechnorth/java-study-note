package com.javannorth.unittest.dto;

//import javax.persistence.*;
import java.util.Objects;

//@Entity
//@Table(name = "USER")
public class User {

    private String userName;

    private String id;

    private String nickName;

    public User() {
    }

    public User(String userName, String userID, String nickName) {
        this.userName = userName;
        this.id = userID;
        this.nickName = nickName;
    }

//    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
//    @EmbeddedId
//    @Column(name = "USER_ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//    @Column(name = "NICK_NAME")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(id, user.id) && Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, id, nickName);
    }
}
