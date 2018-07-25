import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zeng
 * @Date: 2018/7/26 1:00
 */
public class Genericity<T> {

    private T message;

    public void setClassType(T message) {
        this.message = message;
    }

    public Class getClassType() {
        return this.message.getClass();
    }

    public static void print(List<?> list) {
        System.out.println(list.get(0).toString());
    }

    public static void main(String[] args) {

//        List<String> strList = new ArrayList<>();
//        strList.add("test1");
//
//        List<Integer> intList = new ArrayList<>();
//        intList.add(1);

//        print(strList);
//        print(intList);

        Genericity genericity = new Genericity();
        genericity.setClassType(1);

        System.out.println(genericity.getClassType().getName());


        AA father = new AA("AA");
        BB son1 = new BB("BB");
        CC grandSon = new CC("CC");
        DD son2 = new DD("DD");
        EE other = new EE("EE");

        List<AA> testAAList = new ArrayList<>();
        testAAList.add(father);
        print(testAAList);

        List<BB> testBBList = new ArrayList<>();
        testBBList.add(son1);
        print(testBBList);

        List<CC> testCCList = new ArrayList<>();
        testCCList.add(grandSon);
        print(testCCList);

        List<DD> testDDTest = new ArrayList<>();
        testDDTest.add(son2);
        print(testDDTest);

//        List<EE> testEEList = new ArrayList<>();
//        testEEList.add(other);
//        print(other);
    }
}

class AA {

    private String aa;

    public AA() {
    }

    public AA(String aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return this.aa;
    }
}

class BB extends AA {

    private String bb;

    public BB() {
    }

    public BB(String bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return this.bb;
    }
}

class CC extends BB {

    private String cc;

    public CC(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return this.cc;
    }

}


class DD extends AA {

    private String dd;

    public DD(String dd) {
        this.dd = dd;
    }

    @Override
    public String toString() {
        return this.dd;
    }
}

class EE {

    private String ee;

    public EE(String ee) {
        this.ee = ee;
    }

    @Override
    public String toString() {
        return this.ee;
    }
}