# Design Patterns with Java #

For future reference, all `main()` functions are defined in a `Client` class, where each design pattern can be executed. 

# Creational Design Patterns #

## The builder pattern ##

This pattern is quite useful when:

+ Constructors currently in place have too many parameters
+ When all object properties are unknown at run-time (some properties may be mandatory; handle using exceptions or set defaults as required)
+ When building immutable objects (declare the Builder class within the class the Builder instantiates) like Java Strings

There are two Builder patterns provided, the ![second](/src/com/designPatterns/BuilderPattern2) (defined as an inner class) is more commonly applied. The ![first](/src/com/designPatterns/BuilderPattern) demonstrates how Builder classes can be defined as separate classes. It is quite uncommon to build abstract Builder classes since they pertain to specific classes and therefore concrete classes tend to be more useful.

Calendar, StringBuilder and many other Buffer classes in Java are examples, arguably, of builder patterns.

The outer class defines its properties (with primitives or through composition) with public getters and private setters.
 The builder class is defined as an inner class. The properties in the builder class need not match the outer class
 properties but must be designed with the view to initialise the object at some point.* A series of public methods (which effectively
 resemble setters) can set the Builder class properties. A method Build() then builds and returns a new instance of the outer class and
 sets the outer class properties, via its setters, using the Builder class properties.*
 
The outer class then creates an instance of the builder class and can call its methods in a chain-like fashion.

Builder patterns can be compared to `Prototype` patterns (explored later). Prototype patterns essentially build objects by cloning 
other objects. 

+ Prototype patterns leads other classes to call a clone method and circumvent the constructor entirely. Builder patterns do not.
+ Prototype patterns tend to be more difficult to apply to legacy code (which may not support clone methods). Builder patterns are generally more legacy code friendly.

## The simple factory pattern ##

Not to be confused with `factory method` patterns, simple factory patterns encapsulate the instantiation of a class, usually via a static method, somewhere outside (though not a requirement) of the class of concern. Typically, the simple factory method is declared with an interface (or abstract class). The different static methods are defined by classes which implement the interface or abstract class.

Simple factory method patterns (some may not consider this as a pattern) are useful when more than one class could be instantiated based on the choice. One may need to instantiate a class based on option A and instantiate a different class under option B, and so on.

In the ![example abstract class](/src/com/designPatterns/SimpleFactoryPattern/Post.java), a static method createPost() in ![postFactory](/src/com/designPatterns/SimpleFactoryPattern/PostFactory.java) decides if a blogPost, a newsPost or a productPost is instantiated and returned.

The `java.text.NumberFormat` class uses a method `getInstance()` which performs the simple factory method pattern. There are plenty of other examples elsewhere.

A more specialised form of simple factory method, which uses subclassing, is the `factory method pattern` and is probably preferred if the decision making becomes more complex. While simple factory method patterns are aware of the classes it instantiates, factory method does not.

## The factory method pattern ##

As already mentioned, the factory method can be implemented without knowing about which classes will be instantiated. The decision about how to build objects is handled by subclasses.

Similar to the simple factory method, the factory abstract class or interface is implemented with concrete classes. Each concrete classes is then managed by its own creator class which returns the instance of the class (it can set properties). Finally, a central creator abstract class communicates with all creator classes to provide one general interface to a client. The central creator abstract class is overridden by the concrete classes that implement it.

The example provided shows how a text message object and JSON message object is created. Note that ![messageCreator](/src/com/designPatterns/FactoryMethodPattern/MessageCreator.java) has no knowledge of the objects it would return with getMessage() and createMessage(). Compare this to ![PostFactory](/src/com/designPatterns/SimpleFactoryPattern/PostFactory.java) where the types are known and listed. Also see how the simple choices from an if or switch block are not present. In this case, the choice of which object to build is determined elsewhere.

One example of a factory method pattern method is the `Iterator()` abstract method from `java.util.Collection`. This method returns an iterator over the elements contained in a given collection, the classes which implement the abstract Iterator class manage the specific object iterators. Static methods which return objects (and are therefore not abstract) do not require subclasses to define the specific object properties and are therefore not considered by some as factory methods.

Given the intertwined nature of the factory class and its creator classes, the factory method pattern is sometimes more challenging to implement. Older code bases which require a factory method pattern have to essentially be written from scratch. In many cases, one must subclass at least once just to get the design pattern to work. For each new object type needed, a new creator class must also be built.