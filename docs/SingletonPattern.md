# Creational Design Patterns #

## The singleton pattern ##

The singleton pattern is used to guarantee the construction of only instance of a class. This pattern, to some, is considered an 'anti-pattern'.**

The class of a singleton pattern typically uses a non-global constructor (beyond said class) and does not permit inheritance. The singleton object can be accessed by a public method (i.e. `getInstance()`) which returns the object. The getInstance() method need not be static but should always be parameterless. Since the getInstance() method is public, it means that the singleton is globally accessible.

There are two types of singleton initialisation:

- _Eager_ singleton, an object which is built as soon as the class is loaded (generally the simplest approach)
- _Lazy_ singleton, an object which is built on a needs basis

Two methods of implementing singleton patterns are offered: [with concurrency](/src/com/designPatterns/SingletonPattern/LazyRegistryWithDCL.java) (threads) and [without threads](/src/com/designPatterns/SingletonPattern/LazyRegistryIODH.java) (pre-Java 1.5). In the latter case (sometimes preferable), the class which leads LazyRegistryIODH would have to handle synchronisation concerns itself.

Note that in both implementations, the inner class is private which ensures that the instance cannot be built elsewhere.

Another Java 1.5+ implementation of a singleton with enumerations is provided in [RegistryEnum](/src/com/designPatterns/SingletonPattern/RegistryEnum.java). There is some debate to the application of enums since they are by nature immutable when the singleton itself may be mutable.

A good example of a singleton in the standard library is the `Runtime` class (in java.lang).

Singleton instances are difficult to mock and unit test. The objects, like all static objects, are unique to a class loader, though they can be constructed from different classes on the same JVM. Hence, some argue that singletons are not unique. 

**Singletons are global objects and if they represent mutable entities or can change readily then this becomes more difficult to manage when classes which depend on the singleton need a specifically configured singleton. Having global variables (not global constants) is generally bad practice since it may lead to unaccounted results or behaviour.