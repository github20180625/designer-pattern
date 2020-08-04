package javax.com.sheng.designer.creation.single.inner;

public class InnerClassSingleTest {

	public static void main(String[] args) {
		run(() -> System.out.println(InnerClassSingle.getInstance()));
	}

	public static void run(Runnable runnable) {
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
	}

}
