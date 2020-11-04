package com.designPatterns.SimpleFactoryPattern;

public class Client {

	public static void main(String[] args) {

		//createPost() is the static method which returns the appropriate object
		Post post = PostFactory.createPost("news");
		System.out.println(post);

	}

}
