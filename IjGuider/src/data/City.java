package data;

import java.util.ArrayList;
import java.util.Date;
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

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Train> getTrainNumber() {
        return trainNumber;
    }

    /**
     *
     * @param trainNumber 从text获取到的列车号
     * @param departureTime 从text获取到的始发时间
     * @param wayCity 从text获取的途经城市数组
     * @param wayStationTime 从text获取的途经城市到达的时间数组
     * @param pay 途经城市的价格
     * @return
     */
    public boolean addTrain(String trainNumber, Date departureTime, City[] wayCity,
                            Date[] wayStationTime, Integer[] pay) {
        for (Train tmp : this.trainNumber) {
            if (tmp.getTrainNumber().equals(trainNumber)) return false;
        }
        Train newTrain = new Train(trainNumber, this, departureTime);
        for (int i = 0; i < wayCity.length; i++) {
            newTrain.addTrainInformation(i, wayCity[i], wayStationTime[i], pay[i]);
        }
        this.trainNumber.add(newTrain);
        return true;
    }

    /**
     *
     * @param planeNumber 从text获取到的航班号
     * @param departureTime 从text获取到的始发时间
     * @param wayCity 从text获取的途经城市数组
     * @param wayStationTime 从text获取的途经城市到达的事件数组
     * @param pay 途经城市的价格
     * @return
     */
    public boolean addPlane(String planeNumber, Date departureTime, City[] wayCity,
                            Date[] wayStationTime, Integer[] pay) {
        for (Plane tmp : this.planeNumber) {
            if (tmp.getDepartureTime().equals(planeNumber)) return false;
        }
        Plane newPlane = new Plane(planeNumber, this, departureTime);
        for (int i = 0; i < wayCity.length; i++) {
            newPlane.addPlaneInformation(i, wayCity[i], wayStationTime[i], pay[i]);
        }
        this.planeNumber.add(newPlane);
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

    @Override
    public int hashCode() {
        return Integer.parseInt(cityName);
    }

//    public static void main(String[] args) {
//    }
}
