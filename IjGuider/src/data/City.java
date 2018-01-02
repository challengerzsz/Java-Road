package data;

import java.util.ArrayList;
import java.util.List;

public class City implements java.io.Serializable {
    private String cityName;
    private List<Train> trainList = new ArrayList<>();
    private List<Plane> planeList = new ArrayList<>();

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

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

}
