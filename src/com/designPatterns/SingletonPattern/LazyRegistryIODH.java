package com.designPatterns.SingletonPattern;

/**
 * IODH - initialization-on-demand holder
 * Singleton pattern using lazy initialization holder idiom. This ensures that, we have a lazy initialization
 * without worrying about synchronization (see LazyRegistryWithDCL which is concerned with multiple threads). This would
 * apply to legacy versions of Java (pre 1.5) which do not implement concurrency utilities.
 *
 * The class or method which loads LazyRegistryIODH would have to handle synchronisation issues.
 */
public class LazyRegistryIODH {

	private LazyRegistryIODH() {
		System.out.println("In LazyRegistryIODH singleton");
	}

	// LazyRegistryIODH class does not initialise a property as its object (cf. to eager singleton) and is instead
	// held by an inner class
	private static class RegistryHolder {
		static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
	}

	// this would be the first time the LazyRegistryIODH is revealed
	public static LazyRegistryIODH getInstance() {
		return RegistryHolder.INSTANCE;
	}
}
