package data;

import java.util.ArrayList;
import java.util.List;

public class City implements java.io.Serializable {
    private String cityName;
    private List<Train> trainNumber = new ArrayList<>();
    private List<Plane> planeNumber = new ArrayList<>();

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    /**
     *增加列车、飞机
     * @return 成功：true 失败false
     */
    public boolean addTrain() {
        return true;
    }
    public boolean addPlane() {
//        Plane plane = new Plane("宝鸡", this, "2018-01-01 13:00:00");
        return true;
    }

    /**
     * 删除列车、飞机
     * @return 成功：true 失败false
     */
    public boolean deletePlane() {
        return true;
    }
    public boolean deleteTrain() {
        return true;
    }

    /**
     * 展示城市的交通信息
     * @return 列车信息或航班信息
     */
    public String listOfTrain() {
        return null;
    }
    public String listOfPlane() {
        return null;
    }

}
