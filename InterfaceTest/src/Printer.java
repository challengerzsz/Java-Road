import lee.Output;

//让Printer类实现Output和Product接口
public class Printer implements Output,Product {

    private String[] printData = new String[MAX_CACHE_LINE];
    //用以纪录当前需要打印的作业数
    private int dataNum = 0;
    @Override
    public int getProduceTime() {
        return 45;
    }

    @Override
    public void out() {
        //只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("打印机打印：" + printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数减一
            //System.arraycopy();方法用于将第一个数组的起始位置拷贝到第二个数组的起始位置，最后一个参数是需要操作的长度
            System.arraycopy(printData , 1 , printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE) {
            System.out.println("输出队列已满，添加失败");
        }
        else {
            //把打印的数据添加到队列里，已保存的数据数量加1
            printData[dataNum++] = msg;
        }
    }
    public static void main(String[] args) {
        //创建一个Printer对象，当成Output使用
        Output o = new Printer();
        o.getData("作业1");
        o.getData("作业2");
        o.out();
        o.getData("作业3");
        o.getData("作业4");
        o.out();
        //调用Output接口中默认的方法
        o.print("参数1" , "参数2" , "参数3");
        o.test();
        //创建一个Printer对象，当成Priduct使用
        Product p = new Printer();
        System.out.println(p.getProduceTime());
        //所有的接口类型的引用变量都可以直接赋值给Object类型的变量
        Object obj = p;
    }
}
