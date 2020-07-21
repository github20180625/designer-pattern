package javax.com.sheng.designer.creation.single.doublecheck;

public class DoubleCheckSingle1 {

	private static volatile DoubleCheckSingle1 instance;

	private DoubleCheckSingle1() {}

	public static DoubleCheckSingle1 getInstance() {
		if (instance == null) {
			synchronized(DoubleCheckSingle1.class) {
				if (instance == null) {
					instance = new DoubleCheckSingle1();
				}
			}
		}
		return instance;
	}

}
