package com.code.fuqinqin.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Student {
    private Long id;
    private Clazz clazz;
    private String name;
    private Integer age;
    private Date birthday;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", clazz=").append(clazz);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthday));
        sb.append('}');
        return sb.toString();
    }
}
