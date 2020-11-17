package com.designPatterns.AbstractFactoryPattern;

import com.designPatterns.AbstractFactoryPattern.Instance.Capacity;
import com.designPatterns.AbstractFactoryPattern.aws.AwsResourceFactory;
import com.designPatterns.AbstractFactoryPattern.gcp.GoogleResourceFactory;

public class Client {

	private ResourceFactory factory;

	// note that the abstract factory is used; the specific factory is injected
	public Client(ResourceFactory factory) {
		this.factory = factory;
	}

	// with the factory (the set), the user can build its units (instance and storage)
	// simulates the building of a server, with storage capabilities
	public Instance createServer(Instance.Capacity cap, int storageMib) {
		Instance instance = factory.createInstance(cap);
		Storage storage = factory.createStorage(storageMib);

		// simulates the coupling of instance and storage
		instance.attachStorage(storage);
		return instance;
	}
	
    public static void main(String[] args) {
    	Client aws = new Client(new AwsResourceFactory());
    	Instance i1 = aws.createServer(Capacity.micro, 20480);
    	i1.start();
    	i1.stop();
    	
    	System.out.println("***************************************");
    	Client gcp = new Client(new GoogleResourceFactory());
    	i1 = gcp.createServer(Capacity.micro, 20480);
    	i1.start();
    	i1.stop();
    }
}
