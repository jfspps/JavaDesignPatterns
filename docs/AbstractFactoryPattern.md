# Creational Design Patterns #

## The abstract factory pattern ##

Abstract factory patterns can be applied when two or more objects, which will work closely, are built as groups or sets, which eventually solve problems. This is one of the more complex patterns to implement.

The client is separated from the objects' classes and the sets' classes. A game is presented to demonstrate the application of abstract factory patterns. Take Sid Meier's Civilization series. At a given era, land-based units and naval units can be 'built'. Each unit type is viewed as an object and the set is the group of units from the same era. The sets from the Medieval era are different to that from the Industrial era but nonetheless, the relationship between units (objects) of the same era are remain the same.

The abstract patterns decides which objects and sets to build based on given criteria, in the above case, which era the player is in.

Structurally, the naval units and land-based units would be handled by an abstract class, with the specific units (riflemen, archers, horsemen, galleys, fish boats etc.) defined by concrete classes following from the abstract classes. 

Each set (or era in this case) has its own factory class (e.g. `MedievalUnitFactory` or `IndustrialUnitFactory`) which can build each unit type (land or naval), and follows an abstract set class which calls methods such as `createLandUnit()` and `createNavalUnit()` etc. Notice how the abstract factory class or interface has no knowledge of the concrete factory classes. Ultimately, the client decides which era (factory) should be applied.

The pattern is referred to as an Abstract Factory Method because it borrows the same principles as the Factory method. 

The code example of abstract factory method is based on the creation of cloud services, with Amazon AWS EC2 (or Google Compute) and Amazon AWS S3 (or Google Cloud) as instances and data storage containers. Other sets of objects which work closely can also be candidates for the abstract factory method.

A reasonably good example of the abstract factory pattern in use is the DocumentBuilderFactory class from `javax.xml.parsers`.

Both the factory pattern and abstract factory method have no knowledge about which class is instantiated at runtime. Both hide the concrete objects built by the client at runtime. The abstract factory method also hides the factories (that is, the classes which build groups of objects). From the title, the factories are abstract entities too. The abstract factory method brings together different objects which combined serve a purpose, whereas the factory pattern focuses on delivering one type of object (and classes which extend the object).

Adding a new object (a new Civilization unit to the era) will require changes to the factory (the era generator). Without it, the factory may never build an instance or conduct other methods (coupling of instance to storage for cloud services, for example) with or on the new object.

Generally, most developers start using factory patterns first on single objects or products before extending the idea to other objects and thereby bring in the implementation of an abstract factory pattern.