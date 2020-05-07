package com.sdsc.basic.annotation;

import java.lang.reflect.Field;

public class AnnotationTest {
    public static void main(String[] args) {
        UserBean userBean = new UserBean();
        userBean.setAge(12);
        userBean.setId(111);
        userBean.setUserName("jzx");

        query(userBean);
    }

    private static String query(Object f) {
        Class<?> cl = f.getClass();
        boolean exists = cl.isAnnotationPresent(Table.class);
        if (!exists) {
            return "";
        }

        Table t = cl.getAnnotation(Table.class);

        String tableName = t.value();
        System.out.println("表名称" + tableName);
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            boolean flag = field.isAnnotationPresent(Column.class);
            if (!flag)
                continue;
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            String fieldName = field.getName();

            System.out.println(columnName + "\t" + fieldName);
        }
        return "";
    }
}
