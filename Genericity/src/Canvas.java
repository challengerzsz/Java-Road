import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract void draw(Canvas c);
}

class Circle extends Shape {
    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "画一个圆");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw(Canvas c) {
        System.out.println("把一个矩形画在画布" + c + "上");
    }
}
public class Canvas {
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s: shapes) {
            s.draw(this);
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas c = new Canvas();
        //当drawAll的参数为(List<Shape> shapes)时
        //不能把List<Circle>当成List<Shape>使用，下面代码会引起编译错误
        //c.drawAll(circleList);
        //修改drawAll的参数为List<?> shapes后原语句正确
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        circleList.add(c1);
        circleList.add(c2);
        c.drawAll(circleList);
    }
}
