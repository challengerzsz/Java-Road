package controller;

import data.City;
import data.Plane;
import data.Train;
import util.DateUtil;
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
        departureCity.getTrainList().add(newTrain);
        //除终点站之外途径站都add这个对象
        for (int i = 0; i < wayStation.length - 1; i++) {
            wayStation[i].getTrainList().add(newTrain);
        }
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
        Plane newPlane = new Plane(planeNumber, departureCity, departureTime, wayStation, wayStationTime, pay);
        planeList.add(newPlane);
        departureCity.getPlaneList().add(newPlane);
        //除终点站之外途径站都add这个对象
        for (int i = 0; i < wayStation.length - 1; i++) {
            wayStation[i].getPlaneList().add(newPlane);
        }
        return true;
    }

    /**
     * 根据列车号删除列车
     * @param trainNumber 列车号
     * @return 成功：true 失败：false
     */
    public static boolean deleteTrain(String trainNumber) {
        Train targetTrain = null;
        boolean result;
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


    /**
     * 根据始发省市和终到省市查询两者之间是否有关系
     * @param startProvince 始发省
     * @param startCity 始发市
     * @param endProvince 终到省
     * @param endCity 终到市
     * @return 有关系：true 无关系：false
     */
    public static boolean isConnection(String startProvince, String startCity, String endProvince, String endCity) {
        City departureCity = ProvinceOp.getCity(startProvince, startCity);
        City arrivalCity = ProvinceOp.getCity(endProvince, endCity);

        for (Train trainTmp : departureCity.getTrainList()) {
            for (City cityTmp : trainTmp.getWayStation()) {
                if (cityTmp.equals(arrivalCity)) return true;
            }
        }
        return false;
    }

    /**
     * 获取列车时刻表 admin
     * @param trainNumber 列车号
     */
    public static void getTrainInformation(String trainNumber) {
        Train targetTrain = VehicleOp.getTrain(trainNumber);
        System.out.println("======================================================");
        System.out.println("             列车查询        ");
        System.out.println("列车号:" + targetTrain.getTrainNumber());
        System.out.println("起始站:" + targetTrain.getDepartureCity().getCityName());
        System.out.println("始发时间:" + DateUtil.parseDate(targetTrain.getDepartureTime()));
        System.out.println("途径站点信息:");
        for (City tmp : targetTrain.getWayStation()) {
            System.out.println(targetTrain.getWayStation().indexOf(tmp) + 1 + "." + "   " + tmp.getCityName() + "   " + DateUtil.parseDate(targetTrain.getWayStationTime().get(tmp))
                    + "   " + targetTrain.getWayStationPay().get(tmp));
        }
        System.out.println("终到站信息:" + targetTrain.getFinalStation().getCityName() + "   "
                + DateUtil.parseDate(targetTrain.getFinalArrivalTime()));
    }

    /**
     * 获取航班时刻表 admin
     * @param planeNumber 航班号
     */
    public static void getPlaneInformation(String planeNumber) {
        Plane targetPlane = VehicleOp.getPlane(planeNumber);
        System.out.println("======================================================");
        System.out.println("             航班查询        ");
        System.out.println("航班号:" + targetPlane.getPlaneNumber());
        System.out.println("始发地:" + targetPlane.getDepartureCity().getCityName());
        System.out.println("始发时间:" + DateUtil.parseDate(targetPlane.getDepartureTime()));
        System.out.println("途径站点信息:");
        for (City tmp : targetPlane.getWayStation()) {
            System.out.println(targetPlane.getWayStation().indexOf(tmp) + "." + "   " + tmp.getCityName() + "   "
                    + DateUtil.parseDate(targetPlane.getWayStationTime().get(tmp))
                    + "   " + targetPlane.getWayStationPay().get(tmp));
        }
        System.out.println("终到站信息:" + targetPlane.getFinalStation().getCityName() + "   "
                + DateUtil.parseDate(targetPlane.getFinalArrivalTime()));
    }

    /**
     * 根据Way查询way的起始站的列车信息
     * @param city way的起始站
     */
    public static void getTrainInformationForWay(City city) {
        City cityTmp = null;
        System.out.println("======================================================");
        System.out.println("             列车查询        ");
        for (Train train : city.getTrainList()) {
            System.out.println("当前站:" + city.getCityName());
            System.out.println("列车号:" + train.getTrainNumber());
            System.out.println("起始站:" + train.getDepartureCity().getCityName() + "   终点站:" +
                    train.getFinalStation().getCityName() +
                    "   始发时间:" + DateUtil.parseDate(train.getDepartureTime()));
            System.out.println("开车时间:" + DateUtil.parseDate(train.getDepartureTime()));
            for (int i = 0; i < train.getWayStation().size(); i++) {
                if (train.getWayStation().get(i).getCityName().equals(city.getCityName())) {
                    for (int o = i + 1; o < train.getWayStation().size(); o++) {
                        cityTmp = train.getWayStation().get(o);
                        System.out.println(o - i + "." + "   " + train.getWayStation().get(o).getCityName() + "   " +
                                DateUtil.parseDate(train.getWayStationTime().get(cityTmp))
                                + "   " + train.getWayStationPay().get(cityTmp));
                    }
                } else {
                    for (Train train1 : city.getTrainList()) {
                        getTrainInformation(train1.getTrainNumber());
                    }

                }
            }
        }

    }

    /**
     * 根据Way查询way的起始站的航班信息
     * @param city way的起始城市
     */
    public static void getPlaneInformationForWay(City city) {
        City cityTmp = null;
        System.out.println("======================================================");
        System.out.println("             航班查询        ");
        for (Plane plane : city.getPlaneList()) {
            System.out.println("当前站:" + city.getCityName());
            System.out.println("航班号:" + plane.getPlaneNumber());
            System.out.println("起始站:" + plane.getDepartureCity().getCityName() + "   终点站:" +
                    plane.getFinalStation().getCityName() +
                    "   始发时间:" + DateUtil.parseDate(plane.getDepartureTime()));
            System.out.println("起飞时间:" + DateUtil.parseDate(plane.getWayStationTime().get(city)));
            System.out.println("途径站点信息:");
            for (int i = 0; i < plane.getWayStation().size(); i++) {
                if (plane.getWayStation().get(i).getCityName().equals(city.getCityName())) {
                    for (int o = i + 1; o < plane.getWayStation().size(); o++) {
                        cityTmp = plane.getWayStation().get(o);
                        System.out.println(o - i + "." + "   " + plane.getWayStation().get(o).getCityName() + "   " +
                                DateUtil.parseDate(plane.getWayStationTime().get(cityTmp))
                                + "   " + plane.getWayStationPay().get(cityTmp));
                    }
                }
            }
        }
    }


}
