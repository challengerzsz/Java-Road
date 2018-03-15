import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    public void sayHello(String name) {
        System.err.println("hello " + name);
    }

    public ReflectServiceImpl getInstence() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}

class ReflectServiceImpl2 {
    private String name;
    public void sayHello() {
        System.out.println("hello " + name);
    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("ReflectServiceImpl2").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            method.invoke(target, "zsz");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public static void main(String[] args) {
        ReflectServiceImpl2 reflectServiceImpl2 = new ReflectServiceImpl2();
        reflectServiceImpl2.reflectMethod();
    }
}
