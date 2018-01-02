package util;

import controller.AccountOp;
import controller.ProvinceOp;
import controller.VehicleOp;
import data.Account;
import data.Plane;
import data.Province;
import data.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FileUtil {
    public static final String ProvinceFileName = "Province.txt";
    public static final String PlaneFileName = "Plane.txt";
    public static final String TrainFileName = "Train.txt";
    public static final String AccountFileName = "Account.txt";

    /**
     * 读写省份城市文件
     * @return
     */
    public static boolean saveProvinceData() {
        return saveFile(ProvinceOp.totalProvince, ProvinceFileName);
    }
    public static void readProvinceData() {
        ProvinceOp.totalProvince = (HashSet<Province>) readFromFile(ProvinceFileName);
    }

    /**
     * 读写航班信息文件
     * @return
     */
    public static boolean savePlaneData() {
        return saveFile(VehicleOp.planeList, PlaneFileName);
    }
    public static void readPlaneData() {
        VehicleOp.planeList = (ArrayList<Plane>) readFromFile(PlaneFileName);
    }

    /**
     * 读写列车信息文件
     * @return
     */
    public static boolean saveTrainData() {
        return saveFile(VehicleOp.trainList, TrainFileName);
    }
    public static void readTrainData() {
        VehicleOp.trainList = (ArrayList<Train>) readFromFile(TrainFileName);
    }

    /**
     * 读写账户信息文件
     * @return
     */
    public static boolean saveAccountData() {
        return saveFile(AccountOp.mAccountArrayList, AccountFileName);
    }
    public static void readAccountData() {
        AccountOp.mAccountArrayList = (ArrayList<Account>) readFromFile(AccountFileName);
    }

    /**
     * 储存文件
     * @param obj 需要存储的对象
     * @param path 文件路径
     * @return 成功：true 失败：false
     */
    public static boolean saveFile(Object obj, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path)
        )) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 读取文件
     * @param path 文件路径
     * @return 读取到的对象object
     */
    public static Object readFromFile(String path) {
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path)
        )) {
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }
}
