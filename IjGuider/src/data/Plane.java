package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Plane implements java.io.Serializable {
    private String planeNumber;
    private City departureCity;
    private Date departureTime;
    private City finalStation;
    private Date finalArrivalTime;
    private ArrayList<City> wayStation = new ArrayList<>();
    private Map<City,Date> wayStationTime = new HashMap<>();
    private Map<City,Double> wayStationPay = new HashMap<>();

    /**
     * 列车构造器
     * @param planeNumber 列车号
     * @param departureCity 始发站
     * @param departureTime 始发时间
     * @param wayStation 途经站数组
     * @param wayStationTime 途径站到站时间数组
     * @param pay 到途径站花费数组
     */
    public Plane(String planeNumber, City departureCity, Date departureTime, City[] wayStation,
                 Date[] wayStationTime, Double[] pay) {
        this.planeNumber = planeNumber;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.finalStation = wayStation[wayStation.length - 1];
        this.finalArrivalTime = wayStationTime[wayStationTime.length - 1];

        for (int i = 0; i < wayStation.length; i++) {
            this.wayStation.add(wayStation[i]);
            this.wayStationTime.put(wayStation[i], wayStationTime[i]);
            this.wayStationPay.put(wayStation[i], pay[i]);
        }

    }

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

    public ArrayList<City> getWayStation() {
        return wayStation;
    }

    public void setWayStation(ArrayList<City> wayStation) {
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
