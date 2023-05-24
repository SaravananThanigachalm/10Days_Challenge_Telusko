import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class A{
    static{
        System.out.println("Inside the Static");
    }
    public A() {
        System.out.println("Inside Constructor");
    }
    {
        System.out.println("Inside the Instance");
    }
    public static void show(){
        System.out.println("Inside the Static Show method");
    }
}

class Apple{
    private void repair(){
        System.out.println("Repairing");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
//        A obj = new A();
//        Class.forName("A");
//        Class c = Class.forName("Product");
//
//        System.out.println(c.getConstructors().length);
//
//        Constructor cons[] = c.getConstructors();
//
//        for (Constructor con:cons) {
//            System.out.println(con);
//        }
//        System.out.println("================================================");
//        Field fields[] = c.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//        System.out.println("================================================");
//        Method methods[] = c.getMethods();
//        for (Method method: methods){
//            System.out.println(method);
//        }

        Class c = Class.forName("Apple");
        Apple apple = (Apple) c.newInstance();

        Method m = c.getDeclaredMethod("repair", null);
        m.setAccessible(true);
        m.invoke(apple);

    }
}