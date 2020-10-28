# Design Patterns with Java #

## The builder pattern ##

This pattern is quite useful when:

+ Constructors currently in place have too many parameters
+ When all object properties are unknown at run-time (some properties may be mandatory; handle using exceptions or set defaults as required)
+ When building immutable objects (declare the Builder class within the class the Builder instantiates) like Java Strings

There are two Builder patterns provided, the second (defined as an inner class) is more commonly applied. The first demonstrates how Builder classes can
be defined as separate classes. It is quite uncommon to build abstract Builder classes since they pertain to specific classes and therefore concrete classes tend to be more useful.

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