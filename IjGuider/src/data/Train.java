package data;

import java.util.HashMap;
import java.util.Map;

public class Train implements java.io.Serializable {
    private String planeNumber;
    private City departureCity;
    private String departureTime;
    private String timeConsuming;
    private Map<City,String> wayStationTime = new HashMap<>();
    private Map<City,Integer> wayStationPay = new HashMap<>();


    /**
     *
     * @param planeNumber 航班号
     * @param departureCity 始发城市
     * @param departureTime 从始发城市出发时间
     */
    public Train(String planeNumber, City departureCity, String departureTime, Integer pay) {
        this.planeNumber = planeNumber;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        wayStationTime.put(departureCity, departureTime);
        wayStationPay.put(departureCity, pay);
    }

    /**
     *获取两站之间耗费的时间
     * @return 耗费时间
     */
    private String getTimeConsuming() {
        return null;
    }

    /**
     * 增加列车信息
     * @return 成功：true 失败false
     */
    private boolean addTrain() {
        return true;
    }

    /**
     * 修改列车信息
     * @return
     */
    private boolean modifyTrain() {
        return true;
    }

    /**
     * 删除终点站或途经站的信息、和花费信息
     * @param wayStation
     * @return 成功：true 失败false
     */
    private boolean deleteWayStation(String wayStation) {
        return true;
    }
    private boolean deleteWayStationPay(String wayStation) {
        return true;
    }

    /**
     * UI展示
     * @return 更新后的信息
     */
    private String showTrainInfo() {
        return null;
    }
}
