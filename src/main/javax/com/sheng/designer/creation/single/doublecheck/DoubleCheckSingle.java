package javax.com.sheng.designer.creation.single.doublecheck;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双重检查
 * 		在多线程中懒加载模式更安全一点, 但是仍然存在线程安全问题
 */
public class DoubleCheckSingle {

	private static DoubleCheckSingle instance;

	private static Lock lock = new ReentrantLock();

	private DoubleCheckSingle() {}

	public static DoubleCheckSingle getInstance() {
		int i = 0;
		if (instance == null) {
			synchronized (DoubleCheckSingle.class) {
				if (instance == null) {
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						System.out.println(e);
//					}
					System.out.println(i);
					instance = new DoubleCheckSingle();
				}
			}
		}
		return instance;
	}

	// 使用Lock锁
	public static DoubleCheckSingle getInstance1() {
		if (instance == null) {
			try {
				lock.lock();
				if (instance == null) {
					instance = new DoubleCheckSingle();
				}
			} finally {
				lock.unlock();
			}
		}
		return instance;
	}

}
