package com.code.fuqinqin.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Clazz {
    private Long id;
    private String code;
    private List<Student> students;
}
