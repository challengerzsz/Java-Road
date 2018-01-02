package controller;

import data.City;
import data.Plane;
import data.Train;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleOp {
    public static List<Train> trainList = new ArrayList<>();
    public static List<Plane> planeList = new ArrayList<>();

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }

    public void setPlaneList(List<Plane> planeList) {
        this.planeList = planeList;
    }

    /**
     * 添加新列车
     * @param trainNumber 列车号
     * @param departureCity 始发站
     * @param departureTime 始发时间
     * @param wayStation 途经站数组
     * @param wayStationTime 途径站到站时间
     * @param pay 途径站到站花费
     * @return
     */
    public static boolean addTrain(String trainNumber, City departureCity, Date departureTime, City[] wayStation,
                           Date[] wayStationTime, Double[] pay) {
        for (Train tmp : trainList) {
            if (tmp.getTrainNumber().equals(trainNumber)) return false;
        }
        Train newTrain = new Train(trainNumber, departureCity, departureTime, wayStation, wayStationTime, pay);
        trainList.add(newTrain);
        return true;
    }

    /**
     * 添加新航班
     * @param planeNumber 航班号
     * @param departureCity 始发站
     * @param departureTime 始发时间
     * @param wayStation 途经站数组
     * @param wayStationTime 途径站到站时间
     * @param pay 途径站到站花费
     * @return
     */
    public static boolean addPlane(String planeNumber, City departureCity, Date departureTime, City[] wayStation,
                                   Date[] wayStationTime, Double[] pay) {
        for (Train tmp : trainList) {
            if (tmp.getTrainNumber().equals(planeNumber)) return false;
        }
        Train newTrain = new Train(planeNumber, departureCity, departureTime, wayStation, wayStationTime, pay);
        trainList.add(newTrain);
        return true;
    }

    /**
     * 根据列车号删除列车
     * @param trainNumber 列车号
     * @return 成功：true 失败：false
     */
    public static boolean deleteTrain(String trainNumber) {
        Train targetTrain = null;
        for (Train tmp : trainList) {
            if (tmp.getTrainNumber().equals(trainNumber)) targetTrain = tmp;
        }
        return trainList.remove(targetTrain);
    }

    /**
     * 根据列车号删除航班
     * @param planeNumber 航班号
     * @return 成功：true 失败：false
     */
    public static boolean deletePlane(String planeNumber) {
        Plane targetPlane = null;
        for (Plane tmp : planeList) {
            if (tmp.getPlaneNumber().equals(planeNumber)) targetPlane = tmp;
        }
        return planeList.remove(targetPlane);
    }

    /**
     * 根据列车名返回列车对象
     * @param trainNumber 列车号
     * @return 成功：tmp 失败：false
     */
    public static Train getTrain(String trainNumber) {
        for (Train tmp : trainList) {
            if (tmp.getTrainNumber().equals(trainNumber)) return tmp;
        }
        return null;
    }

    /**
     * 根据航班号返回航班对象
     * @param planeNumber 航班号
     * @return 成功：tmp 失败：null
     */
    public static Plane getPlane(String planeNumber) {
        for (Plane tmp : planeList) {
            if (tmp.getPlaneNumber().equals(planeNumber)) return tmp;
        }
        return null;
    }
}
