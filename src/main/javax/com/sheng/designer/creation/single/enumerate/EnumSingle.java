package javax.com.sheng.designer.creation.single.enumerate;

/**
 * 使用枚举实现单例
 */
public enum EnumSingle {

	INSTANCE("张三", 15);

	private String name;

	private Integer age;

	EnumSingle(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

}
