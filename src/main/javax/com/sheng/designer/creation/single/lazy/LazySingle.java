package javax.com.sheng.designer.creation.single.lazy;

/**
 * 懒汉模式
 * 		1. 构造器私有化,防止外部创建
 * 		2. 属性私有化
 * 		3. 提供外部创建对象的入口
 * 	缺点:
 * 		多线程情况下会造成多对象的创建
 */
public class LazySingle {

	private static LazySingle instance = null;

	private LazySingle() {
	}

	/**
	 * 获取示例方法
	 * 		栈中执行
	 * 			getstatic // 从类中获取静态字段
	 * 			ifnonnull // 如果不等于null则跳转
	 * 			new // 在java堆上创建为LazySingle对象分配内存,并将地址值压入栈顶 <此时instance = null>
	 * 			dup // 复制栈顶值,并将其压入栈顶,此时操作数栈上有连续相同的两个对象地址 <此时instance = null>
	 * 			invokespecial // 调用实例初始化方法, 这个方法是实例方法,所以需要从操作数栈顶弹出一个实例对象 <此时instance = null>
	 * 			putstatic // 设置类中静态字段的值 <此时instance中具体地址值>
	 * 			getstatic // 从类中获取静态字段
	 * 			areturn // 返回引用类型的实例
	 * @return 实例
	 */
	public static LazySingle getInstance() {
		// getstatic 从类中获取静态字段
		// ifnonnull 如果不等于null则跳转
		if (instance == null) {
			/**
			 * 懒汉式单例模式存在的问题: 非原原子性
			 * instance = new LazySingle(); 在内存中有一下几个步骤,单步骤是原子性的
			 *
			 * new 在java堆上创建为LazySingle对象分配内存,并将地址值压入栈顶 <此时instance = null>
			 * dup 复制栈顶值,并将其压入栈顶,此时操作数栈上有连续相同的两个对象地址 <此时instance = null>
			 * invokespecial 调用实例初始化方法, 这个方法是实例方法,所以需要从操作数栈顶弹出一个实例对象 <此时instance = null>
			 * putstatic 设置类中静态字段的值 <此时instance中具体地址值>
			 */
			instance = new LazySingle();
		}
		// areturn 返回引用类型的实例
		return instance;
	}

	/**
	 * 方法加锁
	 *
	 * @return 实例
	 */
	public static synchronized LazySingle getInstance1() {

		if (instance == null) {
			instance = new LazySingle();
		}
		return instance;
	}

	/**
	 * 局部加锁
	 *
	 * @return 实例
	 */
	public static LazySingle getInstance2() {

		synchronized (LazySingle.class) {
			if (instance == null) {
				instance = new LazySingle();
			}
		}

		return instance;
	}

}
