package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 23:11
 */
class AClone implements Cloneable {
    private int id;
    private String username;
    private UserInfo userInfo;

    public AClone(int id, String username, UserInfo userInfo) {
        this.id = id;
        this.username = username;
        this.userInfo = userInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    // deep clone
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Object o = super.clone();
//        AClone a = (AClone) o;
//        a.userInfo = (UserInfo) this.getUserInfo().clone();
//        return o;
//    }
}

class UserInfo implements Cloneable {
    private int sex;
    private String address;

    public UserInfo(int sex, String address) {
        this.sex = sex;
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Test1 implements Cloneable {
    private Test2 test2;

    public Test2 getTest2() {
        return test2;
    }

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test1 newObj = (Test1) super.clone();
        newObj.test2 = (Test2) newObj.test2.clone();
        return newObj;
    }
}

class Test2 implements Cloneable {
    private Test1 test1;

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test2 newObj = (Test2) super.clone();
        newObj.test1 = (Test1) newObj.test1.clone();
        return newObj;
    }
}
public class TestCloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
//        AClone aClone = new AClone(1, "zsz", new UserInfo(0, "西安市"));
//        AClone bClone = (AClone) aClone.clone();
//
//        System.out.println(aClone.hashCode() == bClone.hashCode());
//        System.out.println(aClone);
//        System.out.println(bClone);
//        System.out.println(aClone.getUsername() == bClone.getUsername());
//        System.out.println(aClone.getUserInfo() == bClone.getUserInfo());
//        System.out.println(aClone.getUserInfo());
//        System.out.println(bClone.getUserInfo());
//
//        System.out.println("=================================================================");
//
//        // deep clone
//        AClone cClone = new AClone(1, "zsz", new UserInfo(0, "西安市"));
//        AClone dClone = (AClone) aClone.clone();
//        System.out.println(cClone == dClone);
//        System.out.println(cClone);
//        System.out.println(dClone);
//        System.out.println(cClone.getUsername().equals(dClone.getUsername()));
//        System.out.println(cClone.getUserInfo() == dClone.getUserInfo());

        Test1 test1 = new Test1();
        Test2 test2 = new Test2();

        test1.setTest2(test2);
        test2.setTest1(test1);

        Test1 newObj = (Test1) test1.clone();
        Test2 new2Obj = (Test2) test2.clone();

        System.out.println(test1 + " " + test2);
        System.out.println(test1.getTest2() + " " + test2.getTest1());
        System.out.println(newObj + " " + new2Obj);
        System.out.println(newObj.getTest2() + " " + new2Obj.getTest1());
    }
}
