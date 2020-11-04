package com.designPatterns.FactoryMethodPattern;

import com.designPatterns.FactoryMethodPattern.message.Message;

/**
 * This is our abstract "creator". 
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {

	public Message getMessage() {
		Message msg = createMessage();
		
		msg.addDefaultHeaders();
		msg.encrypt();
		
		return msg;
	}
	
	//Factory method (implemented by the concrete classes)
	//this method can also be defined to set defaults if desired
	protected abstract Message createMessage();
}
