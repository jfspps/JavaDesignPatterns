# Creational Design Patterns #

## The prototype pattern ##

This pattern is of use when the object instantiated is complex and costly to build, or, when the majority of an instance initial properties are the same. Instead of building new objects each time, one uses an existing object as a prototype, hence the name. This is achieved by making copies of an existing object, using the method `clone()`.

The `clone()` method is declared in an interface (or abstract class) and then implemented with concrete classes. The client class then calls `clone()`.

The interface is an in-build interface known as `Cloneable` and each class which implements `Cloneable` overrides `clone()` and defines the exception `CloneNotSupportedException` to enable subclasses to decide if cloning is supported or not. This unfortunately complicates the coding of subclasses to a degree.

Cloning involves `shallow copying` or `deep copying`. The former relates to creating copies where only properties are copied across. The latter method not only copies properties but also build copies of other objects (as implemented via composition) which are required to instantiate the cloned object. Java defaults to shallow copying behaviour and so the programmer would need to implement deep copying if required.

The properties or state of a given object can be stored in a `registry` class for all other classes and objects to refer to when handling original and cloned objects. After all, clones are by nature very similar so getting a handle on a particular clone must be accessible.

Real-world examples of Prototype patterns are limited. `Object.clone()` is available thought the class Object itself does not implement `Cloneable` and instead implements its own cloning.

## Comparison to Singleton design patterns ##

Thinking about it, prototype and singleton are quite opposing outcomes. Singleton classes return only one object at run-time whereas Prototype classes can return multiple copies or clones. Prototype objects can have the same properties and partly adopt characteristics of a Singleton object.