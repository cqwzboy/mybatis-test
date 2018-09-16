package com.code.fuqinqin.mapper;

import com.code.fuqinqin.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    void save(Person person);

    Person getById(@Param("id") Long id);

    List<Person> findAll();
}
