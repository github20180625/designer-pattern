package javax.com.sheng.designer.creation.single.inner;

/**
 * 内部类创建单例
 *
 */
public class InnerClassSingle {

	private InnerClassSingle() {}

	private static class InnerClass {
		static InnerClassSingle instance = new InnerClassSingle();
	}

	public static InnerClassSingle getInstance() {
		return InnerClass.instance;
	}
}
