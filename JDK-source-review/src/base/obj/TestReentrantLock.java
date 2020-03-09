package base.obj;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-08 21:46
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        // 默认创建的RLock是非公平锁
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        reentrantLock.lock();

        reentrantLock.unlock();
    }
}
