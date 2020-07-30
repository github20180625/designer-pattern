package javax.com.sheng.designer.creation.factory;

/**
 * 柜子工厂类
 *		该类为柜子简单工厂创建类
 *
 * @author sjt
 */
public class BoxFactory {

	private BoxFactory() {}

	public static BoxFactory getInstance() {
		return new BoxFactory();
	}



}
