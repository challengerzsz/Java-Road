package data;

import java.util.ArrayList;
import java.util.List;

public class Province implements java.io.Serializable {
    private String provinceName;
    private List<City> cityName = new ArrayList<>();

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
    public boolean addCity() {
        return true;
    }

    /**
     * 获取城市信息
     * @return 城市信息
     */
    public String getCityName() {
        return null;
    }


}
