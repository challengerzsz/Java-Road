import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-09 14:24
 */
public class ConditionTest {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition product = reentrantLock.newCondition();
    private Condition consume = reentrantLock.newCondition();

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }

    public void setReentrantLock(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public Condition getProduct() {
        return product;
    }

    public void setProduct(Condition product) {
        this.product = product;
    }

    public Condition getConsume() {
        return consume;
    }

    public void setConsume(Condition consume) {
        this.consume = consume;
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        conditionTest.reentrantLock.lock();
        conditionTest.reentrantLock.tryLock();
        Resource resource = new Resource(conditionTest.product, conditionTest.consume, conditionTest.reentrantLock);
        ConditionProducer producter1 = new ConditionProducer(resource);
        ConditionProducer producter2 = new ConditionProducer(resource);
        ConditionProducer producter3 = new ConditionProducer(resource);

        ConditionConsumer consumer1 = new ConditionConsumer(resource);
        ConditionConsumer consumer2 = new ConditionConsumer(resource);
        ConditionConsumer consumer3 = new ConditionConsumer(resource);

        producter1.start();
        producter2.start();
        producter3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}

class Resource {
    private int count = 0;
    private static final int MAX = 10;
    private ReentrantLock reentrantLock;
    private Condition product;
    private Condition consume;


    public Resource(Condition product, Condition consume, ReentrantLock reentrantLock) {
        this.product = product;
        this.consume = consume;
        this.reentrantLock = reentrantLock;
    }

    public void product() throws InterruptedException {
        reentrantLock.lock();
        try {
            if (count == MAX) {
                product.await();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产者 生产 + 1");
            consume.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        reentrantLock.lock();
        try {

            if (count == 0) {
                consume.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "消费者 消费 - 1");
            product.signal();

        } finally {
            reentrantLock.unlock();
        }
    }


}

class ConditionProducer extends Thread {

    private Resource resource;

    public ConditionProducer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                resource.product();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ConditionConsumer extends Thread {

    private Resource resource;

    public ConditionConsumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                resource.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}