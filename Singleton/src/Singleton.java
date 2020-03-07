/**
 * @author : zengshuaizhi
 * @date : 2019-09-17 17:08
 */
public class Singleton {

    public static volatile Singleton singleton;

    static class Instance {
        public static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return Instance.singleton;
    }

    public static Singleton getInstance(Object o) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
