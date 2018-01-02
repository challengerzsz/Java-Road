package data;

import java.util.HashSet;

public class Province implements java.io.Serializable {

    private String provinceName;
    private HashSet<City> city = new HashSet<>();

    /**
     * 构造器
     * @param provinceName
     */
    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public HashSet<City> getCity() {
        return city;
    }

    public void setCity(HashSet<City> city) {
        this.city = city;
    }


}
