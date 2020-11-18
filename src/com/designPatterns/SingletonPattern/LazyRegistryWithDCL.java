package com.designPatterns.SingletonPattern;

/**
 * This class demonstrates singleton pattern using Double Checked Locking or "classic" singleton.
 * This is also a lazy initializing singleton.
 * Although this implementation solves the multi-threading issue with lazy initialization using volatile
 * and double check locking, the volatile keyword is guaranteed to work only after JVMs starting with
 * version 1.5 and later.
 */
public class LazyRegistryWithDCL {

    private LazyRegistryWithDCL() {
    	
    }

    // volatile ensures that threads which attempt to access INSTANCE do so through the main() stack only (thereby getting the most up to date object)
    private static volatile LazyRegistryWithDCL INSTANCE;
    
    public static LazyRegistryWithDCL getInstance() {
    	if(INSTANCE == null) {
    		// ensures that no two threads, running at the same time, build separate instances of LazyRegistryWithDCL
    		synchronized (LazyRegistryWithDCL.class) {
    			// this is the double checking in DCL; one thread will receive the lock and execute this block
				// all other threads will wait until the lock is released (when the block is processed)
				// with the second, identical check, the other threads could still build more instances
				if(INSTANCE == null) {
					INSTANCE = new LazyRegistryWithDCL();				
				}
			}
    	}
    	return INSTANCE;
    }
}
