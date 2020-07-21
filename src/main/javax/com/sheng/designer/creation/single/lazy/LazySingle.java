package javax.com.sheng.designer.creation.single.lazy;

/**
 * 懒汉模式
 * 		1. 构造器私有化,防止外部创建
 * 		2. 属性私有化
 * 		3. 提供外部创建对象的入口
 */
public class LazySingle {

	private static LazySingle instance = null;

	private LazySingle() {
	}

	public static LazySingle getInstance() {
		if (instance == null) {
			instance = new LazySingle();
		}
		return instance;
	}

}
