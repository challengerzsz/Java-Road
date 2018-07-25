import controller.AccountOp;
import controller.ProvinceOp;
import controller.VehicleOp;
import controller.WayOp;
import data.Account;
import data.City;
import data.Way;
import util.DateUtil;
import util.FileUtil;
import view.AdminControl;
import view.Login;
import view.Query;
import view.Register;

import java.text.ParseException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
//        初始化省市
        ProvinceOp.addProvince("陕西");
        ProvinceOp.addCity("陕西", "宝鸡");
        ProvinceOp.addCity("陕西", "西安");
        ProvinceOp.addCity("陕西", "咸阳");

        //获取对应的城市对象
        City baoji = ProvinceOp.getCity("陕西","宝鸡");
        City xian = ProvinceOp.getCity("陕西", "西安");
        City xianyang = ProvinceOp.getCity("陕西", "咸阳");
//        City
        //添加途径站信息
        Date departureTime = DateUtil.parseString("2018-1-3 12:00:00");
        Date xianyangTime = DateUtil.parseString("2018-1-3 12:30:00");
        Date xianTime = DateUtil.parseString("2018-1-3 13:00:00");

        //初始化列车参数信息
        Double[] xianPay = {25.0, 50.5};
        Date[] wayStationTime = {xianyangTime, xianTime};
        City[] wayStation = {xianyang, xian};

        VehicleOp.addTrain("D8088", baoji, departureTime,
                wayStation, wayStationTime, xianPay);
//
        FileUtil.saveProvinceData();
        FileUtil.saveTrainData();

        VehicleOp.getTrainInformation("D8088");
        VehicleOp.getTrainInformationForWay(baoji);

//        System.out.println(
//                ProvinceOp.getCity("陕西", "宝鸡").getTrainList().get(0).getTrainNumber());
//        System.out.println(ProvinceOp.getCity("陕西", "宝鸡").getTrainList().size());
//        System.out.println(ProvinceOp.getCity("陕西", "咸阳").getTrainList().size());
//        System.out.println(ProvinceOp.getCity("陕西", "西安").getTrainList().size());
//        WayOp.getTotalWaySet().clear();
//        for (Way wayTmp : WayOp.getTotalWaySet()) {
//            System.out.println("test");
//            System.out.println(wayTmp.getDepartureCity().getCityName() + wayTmp.getArrivalCity().getCityName());
//            System.out.println(wayTmp.getContainsTrainList().size());
//        }
//        WayOp.getTotalWay();
//        WayOp.queryInformation(baoji, xian);
//        for (Way wayTmp : WayOp.getTotalWaySet()) {
//            System.out.println(wayTmp.getDepartureCity().getCityName() + wayTmp.getArrivalCity().getCityName());
//            System.out.println(wayTmp.getContainsTrainList().size());
//        }
//        System.out.println(WayOp.getTotalWaySet());
//        System.out.println(baoji.getTrainList().get(0).getWayStation());
//        System.out.println(ProvinceOp.totalProvince.size());

//        GraphOp.initGraph();
//        for (City cityTmp : GraphOp.totalGraph.keySet()) {
//            System.out.println(cityTmp.getCityName());
//        }
//        for (Way wayTmp : WayOp.getWaysForQueryCity(xian)) {
//            System.out.println("1");
//            System.out.println(wayTmp.getDepartureCity().getCityName() + wayTmp.getArrivalCity().getCityName());
//        }
//
        AccountOp.addAdmin("admin", "admin", "admin");
//        FileUtil.saveAccountData();
//        System.out.println(AccountOp.addUser("zsz", "123456", "123456"));
        Login.Login();
//        Register.Register();
//        FileUtil.readAccountData();
//        System.out.println(AccountOp.mAccountArrayList.size());

//        AdminControl.showAdminControlList();
//        Query.showQueryInfo();
//        System.out.println(ProvinceOp.totalProvince.size());
    }
}
