package data;

import util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Plane implements java.io.Serializable {
    private String planeNumber;
    private City departureCity;
    private Date departureTime;
    private Map<City,Integer> wayStation = new HashMap<>();
    private Map<City,Date> wayStationTime = new HashMap<>();
    private Map<City,Integer> wayStationPay = new HashMap<>();

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     *
     * @param planeNumber 航班号
     * @param departureCity 始发城市
     * @param departureTime 从始发城市出发时间
     */
    public Plane(String planeNumber, City departureCity, Date departureTime) {
        this.planeNumber = planeNumber;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        wayStationTime.put(departureCity, departureTime);
    }

    /**
     * 存储途经站信息
     * @param sort 途经城市顺序
     * @param wayStation 途经城市
     * @param wayStationTime 到达途经城市的时间
     * @param pay 费用
     * @return
     */
    public boolean addPlaneInformation(Integer sort, City wayStation, Date wayStationTime, Integer pay) {
        this.wayStation.put(wayStation, sort);
        this.wayStationTime.put(wayStation, wayStationTime);
        this.wayStationPay.put(wayStation, pay);
        return true;
    }

    /**
     *获取两站之间耗费的时间
     * @return 耗费时间
     */
    private String getTimeConsuming(City departureCity, City arrivalCity) {
        if (this.wayStation.get(departureCity) == null && this.wayStation.get(arrivalCity) == null)
            return null;
        String cityTimeConsuming = null;
        cityTimeConsuming = DateUtil.timeConsuming(
                this.wayStationTime.get(departureCity), this.wayStationTime.get(arrivalCity));
        return cityTimeConsuming;
    }

    /**
     * 修改航班信息
     * @return
     */
    private boolean modifyPlane() {
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
    private String showPlaneInfo() {
        return null;
    }
}
