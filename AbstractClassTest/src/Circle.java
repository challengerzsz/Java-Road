/*继承一个抽象类的子类，如果完成了父类的所有抽象方法，那么该类可以被定义为一个普通类*/
public class Circle extends Shape {
    private double radius;

    public Circle(String color , double radius) {
        super(color);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //重写Shape类的计算周长的抽象方法

    @Override
    public double calPerimeter() {
        return 2 * radius * Math.PI;
    }
    //重写Shape类的返回形状的抽象方法

    @Override
    public String getType() {
        return getColor() + "圆形";
    }
    public static void main(String[] args) {
        Shape s1 = new Triangle("黑色", 3 , 4 , 5);
        Shape s2 = new Circle("黄色", 3);
        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        System.out.println(s2.getType());
        System.out.println(s2.calPerimeter());
    }
}

