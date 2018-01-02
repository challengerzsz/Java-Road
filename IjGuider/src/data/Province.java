package data;

import java.util.HashSet;

public class Province implements java.io.Serializable {
    private String provinceName;
    private HashSet<City> city = new HashSet<>();//线程不安全，不允许包含重复对象

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 构造器
     * @param provinceName
     */
    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 增加城市信息
     * @return 成功：true 失败false
     */
    public boolean addCity(String cityName) {
        for (City tmp : city) {
            if (tmp.getCityName().equals(cityName)) return false;
        }
        City newCity = new City(cityName);
        addList(newCity);
        return true;
    }

    /**
     * 将新建城市添加至HushSet中并且保证无重复
     * @param newCity
     * @return 成功：true 失败false
     */
    public boolean addList(City newCity) {
        for (City tmp : city) {
            if (tmp.hashCode() == Integer.parseInt(newCity.getCityName())) {
                return false;
            }
        }
        city.add(newCity);
        return true;
    }
    /**
     * 获取城市信息
     * @return 城市信息
     */
    public String getCityName() {
        return null;
    }

//    public static void main(String[] args) {
//        HashSet hashSet = new HashSet();
//        Integer integer = new Integer(6);
//        hashSet.add(integer);
//        hashSet.add(integer);
//        System.out.println(hashSet);
//    }

}
