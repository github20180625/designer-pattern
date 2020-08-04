package javax.com.sheng.designer.creation.single.inner;

/**
 * 内部类创建单例
 *
 */
public class InnerClassSingle {

//	private int x = 0;

	private InnerClassSingle() {}

	static {
		System.out.println("加载外部类");
	}

	private static class InnerClass {

		static InnerClassSingle instance = new InnerClassSingle();

//		int x = 1;

//		void methodInFirstLevel(int x) {
//			System.out.println("x = " + x);
//			System.out.println("this.x = " + this.x);
//			System.out.println("InnerClassSingle.this.x = " + InnerClassSingle.this.x);
//		}

//		InnerClass() {
//			System.out.println(this);
//			System.out.println("加载InnerClass");
//		}
	}

	public static InnerClassSingle getInstance() {
		return InnerClassSingle.InnerClass.instance;
	}

	public static void main(String[] args) {
//		InnerClassSingle single = InnerClassSingle.getInstance();
//		System.out.println(Thread.currentThread().getName() + "::" + single);

		InnerClassSingle single1 = InnerClassSingle.getInstance();
		System.out.println(Thread.currentThread().getName() + "::" + single1);

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName() + "::" + InnerClassSingle.getInstance()));
			t.start();
		}

		InnerClassSingle single2 = InnerClassSingle.getInstance();
		System.out.println(Thread.currentThread().getName() + "::" + single2);
	}
}
