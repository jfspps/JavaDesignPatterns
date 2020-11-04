# Design Patterns with Java #

For future reference, all `main()` functions are defined in a `Client` class, where each design pattern can be executed. 

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

## Simple factory pattern ##

Not to be confused with `factory method` patterns, simple factory patterns encapsulate the instantiation of a class, usually via a static method, somewhere outside (though not a requirement) of the class of concern. Typically, the simple factory method is declared with an interface (or abstract class). The different static methods are defined by classes which implement the interface or abstract class.

Simple factory method patterns (some may not consider this as a pattern) are useful when more than one class could be instantiated based on the choice. One may need to instantiate a class based on option A and instantiate a different class under option B, and so on.

In the ![example abstract class](/src/com/designPatterns/SimpleFactoryPattern/Post.java), a static method createPost() in ![postFactory](/src/com/designPatterns/SimpleFactoryPattern/PostFactory.java) decides if a blogPost, a newsPost or a productPost is instantiated and returned.

The `java.text.NumberFormat` class uses a method `getInstance()` which performs the simple factory method pattern. There are plenty of other examples elsewhere.

A more specialised form of simple factory method, which uses subclassing, is the `factory method pattern` and is probably preferred if the decision making becomes more complex. While simple factory method patterns are aware of the classes it instantiates, factory method does not.