package com.code.fuqinqin.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Person {

    private Long id;
    private String userName;
    private Integer age;
    private Date birthday;
    private String address;

    public Person(){}

    public Person(String userName, int age, Date birthday){
        this.userName = userName;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthday));
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
