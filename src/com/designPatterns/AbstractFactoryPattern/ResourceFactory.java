package com.designPatterns.AbstractFactoryPattern;

// Abstract factory with methods defined for each object type.
// (both AWS and Google implement ResourceFactory)
public interface ResourceFactory {

	Instance createInstance(Instance.Capacity capacity);
	
	Storage createStorage(int capMib);
}
