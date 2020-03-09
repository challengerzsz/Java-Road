package base.obj.future;

import java.util.concurrent.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-08 12:44
 */

class TestTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}

public class TestFutureModel {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Main");
        Future<Integer> result = executorService.submit(new TestTask());
        Thread.yield();
        System.out.println(result.get());
        executorService.shutdown();
        System.out.println("End");
    }
}
