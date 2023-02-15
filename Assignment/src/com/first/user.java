package com.first;

public class user {

    private int userId;
    private String nameOfUser;

    public int getUserId() {
        return userId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", nameOfUser='" + nameOfUser + '\'' +
                '}';
    }
}
