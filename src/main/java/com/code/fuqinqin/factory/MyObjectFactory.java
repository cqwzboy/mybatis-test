package com.code.fuqinqin.factory;

import lombok.Data;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 自定义对象工厂方法
 * */
@Data
public class MyObjectFactory extends DefaultObjectFactory {

    private String address;

    @Override
    public <T> T create(Class<T> type) {
        try {
            if(type.getSimpleName().equals("Person")){
                T t = type.newInstance();
                Method method = type.getDeclaredMethod("setAddress", new Class[]{String.class});
                method.invoke(t, getAddress());
                return t;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return super.create(type);
    }

    @Override
    public void setProperties(Properties properties) {
        setAddress((String) properties.get("address"));
    }
}
