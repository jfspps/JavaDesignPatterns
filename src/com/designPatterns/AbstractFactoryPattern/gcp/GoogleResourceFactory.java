package com.designPatterns.AbstractFactoryPattern.gcp;

import com.designPatterns.AbstractFactoryPattern.Instance;
import com.designPatterns.AbstractFactoryPattern.Instance.Capacity;
import com.designPatterns.AbstractFactoryPattern.ResourceFactory;
import com.designPatterns.AbstractFactoryPattern.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
