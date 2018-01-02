package data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Train implements java.io.Serializable {
    private String trainNumber;
    private City departureCity;
    private Date departureTime;
    private City finalStation;
    private Date finalArrivalTime;
    private Map<City,Integer> wayStation = new HashMap<>();
    private Map<City,Date> wayStationTime = new HashMap<>();
    private Map<City,Double> wayStationPay = new HashMap<>();

    /**
     * 列车构造器
     * @param trainNumber 列车号
     * @param departureCity 始发站
     * @param departureTime 始发时间
     * @param wayStation 途经站数组
     * @param wayStationTime 途径站到站时间数组
     * @param pay 到途径站花费数组
     */
    public Train(String trainNumber, City departureCity, Date departureTime, City[] wayStation,
                 Date[] wayStationTime, Double[] pay) {
            this.trainNumber = trainNumber;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.finalStation = wayStation[wayStation.length - 1];
        this.finalArrivalTime = wayStationTime[wayStationTime.length - 1];

        for (int i = 0; i < wayStation.length; i++) {
            this.wayStation.put(wayStation[i], i);
            this.wayStationTime.put(wayStation[i], wayStationTime[i]);
            this.wayStationPay.put(wayStation[i], pay[i]);
        }

    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
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

    public City getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(City finalStation) {
        this.finalStation = finalStation;
    }

    public Date getFinalArrivalTime() {
        return finalArrivalTime;
    }

    public void setFinalArrivalTime(Date finalArrivalTime) {
        this.finalArrivalTime = finalArrivalTime;
    }

    public Map<City, Integer> getWayStation() {
        return wayStation;
    }

    public void setWayStation(Map<City, Integer> wayStation) {
        this.wayStation = wayStation;
    }

    public Map<City, Date> getWayStationTime() {
        return wayStationTime;
    }

    public void setWayStationTime(Map<City, Date> wayStationTime) {
        this.wayStationTime = wayStationTime;
    }

    public Map<City, Double> getWayStationPay() {
        return wayStationPay;
    }

    public void setWayStationPay(Map<City, Double> wayStationPay) {
        this.wayStationPay = wayStationPay;
    }

}
