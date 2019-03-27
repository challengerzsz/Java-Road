/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-27 19:22
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello human");
    }

    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello Woman");
    }

    public static void main(String[] args) {
        Human human = new Man();
        Human human1 = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(human);
        staticDispatch.sayHello(human1);
    }
}
