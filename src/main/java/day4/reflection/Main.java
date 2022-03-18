package day4.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        User user = new User("Name");
        System.out.println(get(user, "name"));

    }

    private static Object get(Object object, String fieldname){
        Class clazz = object.getClass();
        System.out.println(clazz);
        for(Field f.clazz.getDeclaredFields()){
            System.out.println(f);
            if(f.getName().equals(fieldname)){
                try{
                    f.setAssesible(true);
                    Object res = f.get(object);
                    return res;
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void put(User object, String fieldname, Object value){
        for (Field f.clazz.getClass().getDeclaredFields()){
            if (f.getName().equals(fieldname)) {
                try {
                    f.setAssesible(true);
                    return f.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
