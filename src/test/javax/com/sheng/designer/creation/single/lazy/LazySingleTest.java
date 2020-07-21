package javax.com.sheng.designer.creation.single.lazy;


public class LazySingleTest {

	public static void main(String[] args) {
		unsafety();
	}

	// 顺序创建
	public static void safety() {
		LazySingle instance = LazySingle.getInstance();

		LazySingle instance1 = LazySingle.getInstance();

		System.out.println(instance == instance1);
	}

	// 开启多个线程执行代码
	public static void unsafety() {

		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				LazySingle instance = LazySingle.getInstance();
				System.out.println(Thread.currentThread().getName() + ":" + instance);
			}).start();
		}

	}
}
