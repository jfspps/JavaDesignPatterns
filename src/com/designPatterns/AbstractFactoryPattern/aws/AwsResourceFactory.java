package com.designPatterns.AbstractFactoryPattern.aws;

import com.designPatterns.AbstractFactoryPattern.Instance;
import com.designPatterns.AbstractFactoryPattern.Instance.Capacity;
import com.designPatterns.AbstractFactoryPattern.ResourceFactory;
import com.designPatterns.AbstractFactoryPattern.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}


}
