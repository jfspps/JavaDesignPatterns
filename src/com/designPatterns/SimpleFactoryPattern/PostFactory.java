package com.designPatterns.SimpleFactoryPattern;

/**
 * This class acts as a simple factory for creation of 
 * different posts on web site.
 *
 */
public class PostFactory {

	//note that other Builder patterns may be implemented here if required
	//also note that PasoFactory is aware of which types to return; compare this to FactoryMethodPattern
	public static Post createPost(String type) {
		switch(type) {
		case "blog":
				return new BlogPost();
		case "news":
				return new NewsPost();
		case "product":
				return new ProductPost();
		default:
				throw new IllegalArgumentException("Post type is unknown");
		}
	}
	
}
