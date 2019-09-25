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
public class TestCloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        AClone aClone = new AClone(1, "zsz", new UserInfo(0, "西安市"));
        AClone bClone = (AClone) aClone.clone();

        System.out.println(aClone.hashCode() == bClone.hashCode());
        System.out.println(aClone);
        System.out.println(bClone);
        System.out.println(aClone.getUsername() == bClone.getUsername());
        System.out.println(aClone.getUserInfo() == bClone.getUserInfo());
        System.out.println(aClone.getUserInfo());
        System.out.println(bClone.getUserInfo());

        System.out.println("=================================================================");

        // deep clone
        AClone cClone = new AClone(1, "zsz", new UserInfo(0, "西安市"));
        AClone dClone = (AClone) aClone.clone();
        System.out.println(cClone == dClone);
        System.out.println(cClone);
        System.out.println(dClone);
        System.out.println(cClone.getUsername().equals(dClone.getUsername()));
        System.out.println(cClone.getUserInfo() == dClone.getUserInfo());
    }
}
