package com.code.fuqinqin;

import com.code.fuqinqin.entity.Clazz;
import com.code.fuqinqin.entity.Person;
import com.code.fuqinqin.entity.Student;
import com.code.fuqinqin.mapper.PersonMapper;
import com.code.fuqinqin.mapper.clazz.ClazzMapper;
import com.code.fuqinqin.mapper.clazz.StudentMapper;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author fuqinqin
 *
 */
public class App {

    private static SqlSession session;
    private static PersonMapper personMapper;
    private static StudentMapper studentMapper;
    private static ClazzMapper clazzMapper;

    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
        personMapper = session.getMapper(PersonMapper.class);
        studentMapper = session.getMapper(StudentMapper.class);
        clazzMapper = session.getMapper(ClazzMapper.class);
    }

    public static void main( String[] args ) throws IOException {
        // 新增
//        save();

        // 根据ID查询
//        Person person = getById(2L);
//        System.out.println(person);

        // 查询所有列表
        /*List<Person> list = findAll();
        for (Person person : list) {
            System.out.println(person);
        }*/

        /*Map<Long, Person> map = findMap();
        for (Long aLong : map.keySet()) {
            System.out.println(aLong + " ==> " + map.get(aLong));
        }*/

        // ResultHandler测试
        /*DefaultResultHandler handler = findResultHandler();
        List<Object> resultList = handler.getResultList();
        for (Object object : resultList) {
            System.out.println(object);
        }*/

        // 通过mapper访问数据库
        /*List<Person> allByMapper = findAllByMapper();
        for (Person person : allByMapper) {
            System.out.println(person);
        }*/

        // 查询所有学生信息
        /*List<Student> allStudent = findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }*/

        // 查询所有班级信息
        List<Clazz> clazzes = findAllClazz();
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }

        session.commit();
        session.close();
    }

    // 保存
    public static void save(){
        Person person = new Person("wangwu", 26, new Date());
        session.insert("com.code.fuqinqin.mapper.PersonMapper.save", person);
        System.out.println("id = "+person.getId());
        System.out.println("持久化成功");
    }

    // 根据id查询
    public static Person getById(Long id){
        Person person = session.selectOne("com.code.fuqinqin.mapper.PersonMapper.getById", id);
        return person;
    }

    // 查询所有
    public static List<Person> findAll(){
        return session.selectList("com.code.fuqinqin.mapper.PersonMapper.findAll", null, new RowBounds(0, 2));
    }

    // 查询key value形式的结果
    public static Map<Long, Person> findMap(){
        return session.selectMap("com.code.fuqinqin.mapper.PersonMapper.findAll", null, "id", new RowBounds(0,2));
    }

    // ResultHandler测试
    public static DefaultResultHandler findResultHandler(){
        DefaultResultHandler handler = new DefaultResultHandler();
        session.select("com.code.fuqinqin.mapper.PersonMapper.findAll", handler);
        return handler;
    }

    // 通过mapper访问数据库
    public static List<Person> findAllByMapper(){
        return personMapper.findAll();
    }

    // 查询所有学生信息
    public static List<Student> findAllStudent(){
        return studentMapper.findAll();
    }

    // 查询所有班机信息
    public static List<Clazz> findAllClazz(){
        return clazzMapper.findAll();
    }
}
