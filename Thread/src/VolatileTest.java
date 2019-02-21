public class VolatileTest {

    private volatile long value = 0;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void set1() {
        value = -1;
    }

    public void set0() {
        value = 0;
    }

    public void check() {
        System.out.println(value);

        if (0 != value && -1 != value) {
            System.err.println("Error " + value);
        }
    }

    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    volatileTest.set1();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    volatileTest.set0();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    volatileTest.check();
                }
            }
        }.start();
    }
}
