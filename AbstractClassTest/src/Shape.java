import sun.security.provider.SHA;

public abstract class Shape {
    {
        System.out.println("执行Shape的初始化块");
    }
    private String color;
    //定义一个计算周长的抽象方法
    public abstract double calPerimeter();
    //定义一个返回形状的抽象方法
    public abstract String getType();
    //定义Shape的构造器，但是由于Shape被abstract修饰，所以为一个抽象类无法创造该类对象
    //该构造器不能被Shape类调用，但是可以被继承该类的子类调用
    public Shape() {}
    public Shape(String color) {
        System.out.println("执行Shape类的构造方法");
        this.color = color;
    }

    //color的getter和setter方法

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

