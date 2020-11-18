package com.designPatterns.SingletonPattern;
/**
 * This class uses eager initialization of singleton instance.
 */
public class EagerRegistry {
	
	private EagerRegistry() {
		
	}

	private static final EagerRegistry INSTANCE = new EagerRegistry();


	// this is the only way to access an object of EagerRegistry. Since there is on static property, there will be only one instance
	public static EagerRegistry getInstance() {
		return INSTANCE;
	}
}