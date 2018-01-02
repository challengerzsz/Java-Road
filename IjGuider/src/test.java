import controller.ProvinceOp;
import controller.VehicleOp;
import data.City;
import util.DateUtil;
import util.FileUtil;
import java.text.ParseException;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        ProvinceOp.addProvince("陕西");
        ProvinceOp.addCity("陕西", "宝鸡");
        ProvinceOp.addCity("陕西", "西安");

        City baoji = ProvinceOp.getCity("陕西","宝鸡");
        City xian = ProvinceOp.getCity("陕西", "西安");
        Date xianTime = DateUtil.parseString("2018-1-3 13:00:00");
        Double[] xianPay = {50.5};
        Date[] wayStationTime = {xianTime};
        City[] wayStation = {xian};

        VehicleOp.addTrain("D8088", baoji, DateUtil.parseString("2018-1-3 12:00:00"),
                wayStation, wayStationTime, xianPay);

        FileUtil.saveProvinceData();
        FileUtil.saveTrainData();

        FileUtil.readTrainData();
        FileUtil.readProvinceData();

        System.out.println(wayStation[0].getCityName());
        System.out.println(VehicleOp.getTrain("D8088").getWayStation().containsKey(xian));
        System.out.println("列车信息");
        System.out.println("始发站" +
                VehicleOp.getTrain("D8088").getDepartureCity().getCityName());
        System.out.println("始发时间" +
                DateUtil.parseDate(VehicleOp.getTrain("D8088").getDepartureTime()));
        System.out.println("途径站点:" +
                VehicleOp.getTrain("D8088").getWayStation().keySet());
        System.out.println("途径站点对应时间:" +
                DateUtil.parseDate(VehicleOp.getTrain("D8088").getWayStationTime().get(xian)));
        System.out.println("途径站对应价格:" +
                VehicleOp.getTrain("D8088").getWayStationPay().get(xian));
        System.out.println("终点站" +
                VehicleOp.getTrain("D8088").getFinalStation().getCityName());
        System.out.println("终点站时间" +
                DateUtil.parseDate(VehicleOp.getTrain("D8088").getFinalArrivalTime()));
        //时间问题和找途径站的价格和时间的get对象
    }
}
