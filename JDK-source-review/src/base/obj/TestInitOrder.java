package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 19:16
 */

class TestOrderFather {
    static {
        System.out.println("Father static block");
    }

    {
        System.out.println("Father normal block");
    }

    public TestOrderFather() {
        System.out.println("father construct");
    }
}

public class TestInitOrder extends TestOrderFather {

    private int i = 0;

    static {
        System.out.println("son static block");
    }

    {
        this.i++;
        System.out.println("son normal block");
    }

    public TestInitOrder() {
        System.out.println("son construct");
    }

    public static void main(String[] args) {
        TestInitOrder testInitOrder = new TestInitOrder();
        System.out.println(testInitOrder.i);
    }
}
