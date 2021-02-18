# Creational Design Patterns #

## The simple factory pattern ##

Not to be confused with `factory method` patterns, simple factory patterns encapsulate the instantiation of a class, usually via a static method, somewhere outside (though not a requirement) of the class of concern. Typically, the simple factory method is declared with an interface (or abstract class). The different static methods are defined by classes which implement the interface or abstract class.

Simple factory method patterns (some may not consider this as a pattern) are useful when more than one class could be instantiated based on the choice. One may need to instantiate a class based on option A and instantiate a different class under option B, and so on.

In the ![example abstract class](https://github.com/jfspps/JavaDesignPatterns/tree/main/src/com/designPatterns/SimpleFactoryPattern/Post.java), a static method createPost() in ![postFactory](https://github.com/jfspps/JavaDesignPatterns/tree/main/src/com/designPatterns/SimpleFactoryPattern/PostFactory.java) decides if a blogPost, a newsPost or a productPost is instantiated and returned.

The `java.text.NumberFormat` class uses a method `getInstance()` which performs the simple factory method pattern. There are plenty of other examples elsewhere.

A more specialised form of simple factory method, which uses subclassing, is the `factory method pattern` and is probably preferred if the decision making becomes more complex. While simple factory method patterns are aware of the classes it instantiates, factory method does not.