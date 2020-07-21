package javax.com.sheng.designer.creation.single.hunger;

/**
 * 饿汉式
 * 		1. 成员属性维护一个单例对象
 * 		2. 私有化构造器
 * 		3. 不能延迟加载
 */
public class HungerSingle {

	private static final HungerSingle instance = new HungerSingle();

	private HungerSingle() {
	}

	public static HungerSingle getInstance() {
		return instance;
	}


}
