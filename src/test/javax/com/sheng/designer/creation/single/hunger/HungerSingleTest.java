package javax.com.sheng.designer.creation.single.hunger;

public class HungerSingleTest {

	public static void main(String[] args) {
		HungerSingle instance = HungerSingle.getInstance();

		HungerSingle instance1 = HungerSingle.getInstance();

		System.out.println(instance == instance1);
	}

}
