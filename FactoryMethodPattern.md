# Creational Design Patterns #

## The factory method pattern ##

As already mentioned, the factory method can be implemented without knowing about which classes will be instantiated. The decision about how to build objects is handled by subclasses.

Similar to the simple factory method, the factory abstract class or interface is implemented with concrete classes. Each concrete classes is then managed by its own creator class which returns the instance of the class (it can set properties). Finally, a central creator abstract class communicates with all creator classes to provide one general interface to a client. The central creator abstract class is overridden by the concrete classes that implement it.

The example provided shows how a text message object and JSON message object is created. Note that ![messageCreator](https://github.com/jfspps/JavaDesignPatterns/tree/main/src/com/designPatterns/FactoryMethodPattern/MessageCreator.java) has no knowledge of the objects it would return with getMessage() and createMessage(). Compare this to ![PostFactory](https://github.com/jfspps/JavaDesignPatterns/tree/main/src/com/designPatterns/SimpleFactoryPattern/PostFactory.java) where the types are known and listed. Also see how the simple choices from an if or switch block are not present. In this case, the choice of which object to build is determined elsewhere.

One example of a factory method pattern method is the `Iterator()` abstract method from `java.util.Collection`. This method returns an iterator over the elements contained in a given collection, the classes which implement the abstract Iterator class manage the specific object iterators. Static methods which return objects (and are therefore not abstract) do not require subclasses to define the specific object properties and are therefore not considered by some as factory methods.

Given the intertwined nature of the factory class and its creator classes, the factory method pattern is sometimes more challenging to implement. Older code bases which require a factory method pattern have to essentially be written from scratch. In many cases, one must subclass at least once just to get the design pattern to work. For each new object type needed, a new creator class must also be built.

Normally, one would build one instance of the concrete factory (a singleton) to build different groups, as is observed in other contexts of manufacture.