package data;

import util.DateUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Train implements java.io.Serializable {
    private String trainNumber;
    private City departureCity;
    private Date departureTime;
    private Map<City,Integer> wayStation = new HashMap<>();
    private Map<City,Date> wayStationTime = new HashMap<>();
    private Map<City,Integer> wayStationPay = new HashMap<>();

    public String getTrainNumber() {
        return trainNumber;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Map<City, Integer> getWayStation() {
        return wayStation;
    }

    public Map<City, Date> getWayStationTime() {
        return wayStationTime;
    }

    public Map<City, Integer> getWayStationPay() {
        return wayStationPay;
    }

    /**
     * 初始化一趟列车
     * @param trainNumber 列车号
     * @param departureCity 始发城市
     * @param departureTime 从始发城市出发时间
     */
    public Train(String trainNumber, City departureCity, Date departureTime) {
        this.trainNumber = trainNumber;
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
    public boolean addTrainInformation(Integer sort, City wayStation, Date wayStationTime, Integer pay) {
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
        if (this.wayStation.get(departureCity) == null || this.wayStation.get(arrivalCity) == null) {
            return null;
        }
        String cityTimeConsuming = null;
        cityTimeConsuming = DateUtil.timeConsuming(
                this.wayStationTime.get(departureCity), this.wayStationTime.get(arrivalCity));
        return cityTimeConsuming;
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
    public static void main(String[] args) {
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(Integer.parseInt("6"));
//        arrayList.add(new Integer(6));
//        System.out.println();
//        Map map = new HashMap();
//        System.out.println(map.get("7"));
    }
}
