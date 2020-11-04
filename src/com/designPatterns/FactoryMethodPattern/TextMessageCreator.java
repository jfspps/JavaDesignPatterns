package com.designPatterns.FactoryMethodPattern;

import com.designPatterns.FactoryMethodPattern.message.Message;
import com.designPatterns.FactoryMethodPattern.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}



}
