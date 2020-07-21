package javax.com.sheng.designer.creation.single.doublecheck;

public class DoubleCheckSingle1Test {

	public static void main(String[] args) {
		unsafety();
	}

	public static void safety() {
		DoubleCheckSingle1 instance = DoubleCheckSingle1.getInstance();

		DoubleCheckSingle1 instance1 = DoubleCheckSingle1.getInstance();

		System.out.println(instance == instance1);
	}

	public static void unsafety() {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				DoubleCheckSingle1 instance = DoubleCheckSingle1.getInstance();
				System.out.println(Thread.currentThread().getName() + ":" + instance);
			}).start();
		}
	}

}
