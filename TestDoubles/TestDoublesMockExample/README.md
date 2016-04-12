# TestDoublesMockExample 
This project is an example of writing some simple tests using Mock objects. The example was used on a Software Testing Technology that I have taught at the Software College at the [Northeastern University](http://www.neu.edu.cn/) in Shenyang, China. 

## Introduction 
In the course, we talk about Test Doubles, which includes Mock Objects. This code is an example of using a Mocking framework called Mockito to provide a Mock Object for the Logger in this code. 

The example code has a DataProcessor class that has a method to perform a simple calculation. In that method, the DataProcessor also sends messages to a Logger. The Logger is an interface. The class ConsoleLogger implements the Logger interface. This code includes test for the functionality of the DataProcessor and ConsoleLogger. It also includes test using Mockito to check the interaction between the DataProcessor and the Logger. 

## Required Libraries 
This project has dependencies on the following libraries: 

1. Mockito - one of several Java frameworks for using mock objects. Looking at possible frameworks, this has a good interface for doing different types of checks. Other frameworks are available. For information see [mockito.org](http://mockito.org/).  The version included with this project was built using ./gradlew build after cloning the project from github. Mockito is avilable under the [MIT license](http://mit-license.org/). 

2. Byte Buddy - this is used by Mockito and it is used to create Java classes at runtime. For further information, see [bytebuddy.net](http://bytebuddy.net/). The version included with this project was downloaded from the link on the Byte Buddy website. Byte Buddy is available under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).

3. Objenesis - this is used by Mockito/ByteBuddy as part of the process to instantiate Java classes at runtime. For further information, see [objenesis.org](http://objenesis.org/). The version included with this project was downloaded from the objenesis website. Objenesis is available under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).




 

