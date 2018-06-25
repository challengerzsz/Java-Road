public class TestLock {

    public synchronized void doSomething() {
        System.out.println("something sleepy!");
        try {
            Thread.sleep(1000);
            System.out.println("woke up!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println("test");
    }

    private static class TestChild extends TestLock {
        public void doSomething() {
            super.doSomething();
        }

        public synchronized void doSomethingElse() {
            System.out.println("something else");
        }

        @Override
        public void test() {
            super.test();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final TestChild t = new TestChild();

        new Thread(() -> {
            t.doSomething();

        }).start();
//        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100);
        t.test();
//        System.out.println(Thread.currentThread().getName());
        t.doSomethingElse();
    }

}