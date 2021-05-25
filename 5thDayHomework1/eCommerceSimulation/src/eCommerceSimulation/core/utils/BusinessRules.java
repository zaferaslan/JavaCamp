package eCommerceSimulation.core.utils;

public class BusinessRules {
	public static boolean run(boolean... logisc) {
		for(boolean b:logisc) {
			if(!b) return false;
		}
		return true;
	}

}
