package javax.com.sheng.designer.creation.single.doublecheck;

public class DoubleCheckSingleTest {
	public static void main(String[] args) {
		unsafety();
	}

	public static void safety() {
		DoubleCheckSingle instance = DoubleCheckSingle.getInstance();

		DoubleCheckSingle instance1 = DoubleCheckSingle.getInstance1();

		System.out.println(instance == instance1);
	}

	public static void unsafety() {
		for (int i = 0; i < 100; i++) {
			new Thread(DoubleCheckSingle::getInstance).start();
		}
	}

}
