import lee.Output;

class Computer {
    private Output out;
    public Computer (Output out) {
        this.out = out;
    }
    //定义一个模拟获取字符串输入的方法
    public void keyIn (String msg) {
        out.getData(msg);
    }
    //定义一个模拟打印的方法
    public void print () {
        out.out();
    }
}


public class OutputFactory {
    public Output getOutput () {
        //由于Printer类实现了Output接口的抽象方法所以可以返回为Output的一个实现类的对象
        return new Printer();
        //return new BetterPrinter();
    }
    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("作业1");
        c.keyIn("作业2");
        c.print();
    }
}

/*如果需要对Computer类组合的输出设备进行改动
* 只需要使用新的输出设备类实现Output接口的抽象方法
* 然后修改OutputFactory类的getOutput方法返回的对象即可*/

//下面是对Printer进行修改的BetterPrinter
class BetterPrinter implements Output {
    private String[] printData = new String[MAX_CACHE_LINE];
    //用以记录当前需要打印的作业数
    private int dataNum = 0;

    @Override
    public void out() {
        //只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("打印机打印：" + printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数减一
            //System.arraycopy();方法用于将第一个数组的起始位置拷贝到第二个数组的起始位置，最后一个参数是需要操作的长度
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE * 2) {
            System.out.println("输出队列已满，添加失败");
        } else {
            //把打印的数据添加到队列里，已保存的数据数量加1
            printData[dataNum++] = msg;
        }
    }
}
