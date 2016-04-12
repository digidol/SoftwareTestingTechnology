# Test Doubles 
In the module, we looked at the idea of Test Doubles, introduced by Meszaros in the [xUnit Patterns book](http://xunitpatterns.com). A Test Double is something that we use to replace a [Depended on Component (DOC)](http://xunitpatterns.com/DOC.html) during testing. The Test Double is used to make it easier or quicker to run the tests. In the book, Meszaros discusses four types of Test Double. 

* Dummy Objects
* Test Stubs 
* Mock Objects 
* Fake Objects

The code in the folders contain examples of the first three types.

A [Fake Object](http://xunitpatterns.com/Fake%20Object.html) can be something like an in-memory database that is used to replace access to a full, server-based, database that would really be used in production. The in-memory database makes it quicker and easier to run the tests. 