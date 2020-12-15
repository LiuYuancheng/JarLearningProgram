# 24Hours Project.

##### Introduction

This project is used test all the Java program in the Java self learning book < Sams Teach Your self Java in 24 hours>.

#### Program Setup

###### Development Environment : Windows + VSCode

###### Additional Lib/Software Need : JDK

###### Program Files List :

| Program File      | Execution Env | Description                                                  |
| :---------------- | ------------- | ------------------------------------------------------------ |
| 24hours.java      | Win/Linux     | The main program to implement and test all the functions.    |
| RootApplet.hpp    | Win/Linux     | The program to test the Java Applet. Even Applet is not support by most of the current browser. |
| UIframe.java      | Win/Linux     | The User interface for Image player, danger alert box, compress gas sign, Pie chart display and Animation bounce display window. |
| LottoServer.java  | Win/Linux     | XML-RPC server program.                                      |
| LottoClient.java  | Win/Linux     | XML-RPC client program.                                      |
| FindPrimes.java   | Win/Linux     | Program used to find a prime in a range.                     |
| c24lockPnl.java   | Win/Linux     | Clock panel use to display the time.                         |
| LottoCounter.java | Win/Linux     | XML-RPC lotto message sending program.                       |

------

#### Program Usage

###### Compile the code by cmd under Windows: 

```
javac 24hours.java
or
javac -cp ".;ws-commons-util-1.0.2.jar;xmlrpc-client-3.1.3.jar;xmlrpc-common-3.1.3.jar;xmlrpc-helma-1.0.jar;xmlrpc-server-3.1.3.jar;xom-1.3.3.jar;commons-logging-1.1.jar" LottoClient.java

```

###### Execute the program: 

```
java B24hours
or 
java -cp ".;ws-commons-util-1.0.2.jar;xerces-2.9.0.jar;xmlrpc-client-3.1.3.jar;xmlrpc-common-3.1.3.jar;xmlrpc-helma-1.0.jar;xmlrpc-server-3.1.3.jar;xom-1.3.3.jar;commons-logging-1.1.jar" LottoClient 725 10 8 1 0
```

Enter the selection: 

| Input number | Test case detail              |
| ------------ | ----------------------------- |
| 00           | Stop and terminate program.   |
| 01           | Show title messages.          |
| 02           |                               |
| 03           |                               |
| 04           |                               |
| 05           | Parameters and functions.     |
| 06           | String and characters.        |
| 07           | Program control flow.         |
| 08           | Looping.                      |
| 09           | Array and list.               |
| 10           | Object oriented programming.  |
| 11           | Description object.           |
| 12           | Vector test.                  |
| 13           | Application GUI.              |
| 14           | Application layout.           |
| 15           | UI user input listener.       |
| 16           | Create complex UI             |
| 17           |                               |
| 18           | Exception handling.           |
| 19           | Multi-Threading program.      |
| 20           | File IO.                      |
| 21           | XML file IO                   |
| 22           | Use different font and color. |
| 23           | Use Graphic.                  |
| 24           | Create animation.             |

Section 25: 

Setup JDK

```
CLASSPATH = C:\Program Files\Java\jdk-15.0.1
```



------



> Last edit by LiuYuancheng(liu_yuan_cheng@hotmail.com) at 28/10/2020