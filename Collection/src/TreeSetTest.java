import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();

        //向nums集合中添加4个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(4);
        nums.add(-3);
        nums.add(-1);
        nums.add(-9);

        //输出元素，将得到已经排序好的集合
        System.out.println(nums);

        //输出集合中的第一个元素
        System.out.println(nums.first());

        //输出集合中最后一个元素
        System.out.println(nums.last());

        //返回小于4的子集，不包括4
        System.out.println(nums.headSet(4));//输出[-9, -3, -1, 2]

        //返回大于5的子集，子集中包括5
        System.out.println(nums.tailSet(5));//输出[5]

        //返回大于等于-3、小于4的子集
        System.out.println(nums.subSet(-3,4));//输出[-3, -1, 2]
    }
}
