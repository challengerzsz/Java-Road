package data;

import java.util.HashSet;

public class Total {
    public static HashSet<Province> totalProvince = new HashSet<>();

    public static boolean addProvince(String province) {
        for (Province tmp : totalProvince) {
            if (tmp.getCityName().equals(province)) return false;
        }
        Province newProvince = new Province(province);
        totalProvince.add(newProvince);
        return true;
    }


}
