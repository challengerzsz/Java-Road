package controller;

import data.City;
import data.Plane;
import data.Province;
import data.Train;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.HashSet;

public class ProvinceOp {
    public static HashSet<Province> totalProvince = new HashSet<>();

    public HashSet<Province> getTotalProvince() {
        return totalProvince;
    }

    public void setTotalProvince(HashSet<Province> totalProvince) {
        this.totalProvince = totalProvince;
    }

    /**
     * 添加省份信息
     * @param provinceName 省份名
     * @return 成功：true 失败：false
     */
    public static boolean addProvince(String provinceName) {
        for (Province tmp : totalProvince) {
            if (tmp.getProvinceName().equals(provinceName)) return false;
        }
        Province newProvince = new Province(provinceName);
        totalProvince.add(newProvince);
        return true;
    }

    /**
     * 添加城市信息
     * @param provinceName 省份名
     * @param cityName 城市名
     * @return 成功：true 失败：false
     */
    public static boolean addCity(String provinceName, String cityName) {
        Province targetProvince = null;
        for (Province tmp : totalProvince) {
            if (tmp.getProvinceName().equals(provinceName)) {
                targetProvince = tmp;
                break;
            }
        }
        for (City tmp : targetProvince.getCity()) {
            if (tmp.getCityName().equals(cityName)) return false;
        }
        City newCity = new City(cityName);
        targetProvince.getCity().add(newCity);
        return true;
    }

    /**
     * 删除省份信息
     * @param provinceName 省份名
     * @return 成功：true 失败：false
     */
    public static boolean deleteProvince(String provinceName) {
        Province targetProvince = null;
        for (Province tmp : totalProvince) {
            if (tmp.getProvinceName().equals(provinceName)) targetProvince = tmp;
        }
        return totalProvince.remove(targetProvince);
    }

    /**
     * 删除对应省份的城市信息
     * @param province 省份名
     * @param cityName 城市名
     * @return 成功：true 失败：false
     */
    public static boolean deleteCity(String province, String cityName) {
        Province targetProvince = null;
        City targetCity = null;
        for (Province provinceTmp : totalProvince) {
            if (provinceTmp.getProvinceName().equals(province)) {
                targetProvince = provinceTmp;
                for (City cityTmp : provinceTmp.getCity()) {
                    if (cityTmp.getCityName().equals(cityName)) targetCity = cityTmp;
                }
            }
        }
        return targetProvince.getCity().remove(targetCity);
    }

    /**
     * 根据省份名获取省份对象
     * @param provinceName 省份名
     * @return 成功：tmp 失败：null
     */
    public static Province getProvince(String provinceName) {
        for (Province tmp : totalProvince) {
            if (tmp.getProvinceName().equals(provinceName)) return tmp;
        }
        return null;
    }

    /**
     * 根据省份名和城市名获取城市对象
     * @param provinceName 省份名
     * @param cityName 城市名
     * @return 成功：cityTem 失败：null
     */
    public static City getCity(String provinceName, String cityName) {
        for (Province provinceTmp : totalProvince) {
            if (provinceTmp.getProvinceName().equals(provinceName)) {
                for (City cityTem :  provinceTmp.getCity()) {
                    if (cityTem.getCityName().equals(cityName)) return cityTem;
                }
            }
        }
        return null;
    }

    /**
     * 获取省份数组
     * @return
     */
    public static String[] getProvince() {
        String[] provinces = new String[totalProvince.size()];
        int i = 0;
        for (Province provinceTmp : totalProvince) {
            provinces[i] = String.valueOf(provinceTmp.getProvinceName());
            i++;
        }
        return provinces;
    }

    public static City[] getCities(String provinceName) {
        City[] cities = new City[getProvince(provinceName).getCity().size()];
        int i = 0;
        for (Province provinceTmp : totalProvince) {
            if (provinceTmp.getProvinceName().equals(provinceName)) {
                for (City cityTmp : provinceTmp.getCity()) {
                    cities[i] = cityTmp;
                    i++;
                }
            }
        }
        return cities;
    }
//    public static HashSet<City> getAllWayStation(String province, String cityName) {
//        City currentCity = ProvinceOp.getCity(province, cityName);
//        HashSet<City> allWayStation = new HashSet<>();
//        for (Train trainTmp : currentCity.getTrainList()) {
//            for (City cityTmp : trainTmp.getWayStation()) {
//                allWayStation.add(cityTmp);
//            }
//        }
//
//        for (Plane planeTmp : currentCity.getPlaneList()) {
//            for (City cityTmp : planeTmp.getWayStation()) {
//                allWayStation.add(cityTmp);
//            }
//        }
//    }
//    /**
//     * 更新对应城市交通工具列集合
//     * @param provinceName 省份名
//     * @param cityName 城市名
//     */
//    public static void refreshCityVehicleList(String provinceName, String cityName) {
//        City targetCity = ProvinceOp.getCity(provinceName, cityName);
//        targetCity.setPlaneList();
//        targetCity.setTrainList();
//    }


}
