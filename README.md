# Design Patterns with Java #

SOLID design principles:

+ __Single responsibility__ means that the class or method is responsible for one aspect only. Any changes to external objects may change a class (through composition) which adheres to the single responsibility principle but only one change is possible.
+ __Open-closed__: Open means that classes are open for inheritance, with overridable methods. Closed means the existing base classes should not be modified. Quite often such classes are composed of abstract methods which cannot be changed in the class but are defined in child classes.
+ The __Liskov__ explains that the behaviour of an object is defined by either its parent class or the parent class above. The Liskov principle is violated when a child class modifies the behaviour or contract of the base class it overrides.
+ __Interfaces__ should never force the user to implement methods which it never needs. Interfaces should be divided into smaller, more cohesive interfaces, overall segregating the unrelated methods.
+ __Dependency Inversion__: methods should not have to create objects, instead, new objects should be created externally and passed to them. Instead of `method(){... new Object …}` use `method(Object object){…}`. The responsibility of injecting dependencies (that is, data required for functionality) is inverted, and given to other objects and methods.

For future reference, all `main()` functions are defined in a `Client` class, where each design pattern can be executed. 

# Creational Design Patterns #

+ ![The Builder Pattern](/docs/BuilderPattern.md)
+ ![The Simple Factory Pattern](/docs/SimpleFactoryPattern.md)
+ ![The Factory Method Pattern](/docs/FactoryMethodPattern.md)
+ ![The Prototype Pattern](/docs/PrototypePattern.md)