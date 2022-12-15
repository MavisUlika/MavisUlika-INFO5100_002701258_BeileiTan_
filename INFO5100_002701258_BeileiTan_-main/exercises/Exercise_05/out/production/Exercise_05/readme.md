## Class Exercise 05
### Demonstrate the use for at least three design pattern implementation in Java



### Please run the `Main.java` to see the final outputs of three design patterns.

There is a variety of choices for design patterns in java. The 3 design patterns selected for this exercise are:
* Builder pattern:

    This pattern uses simple objects to build a complex object, hence, it normally applied if an object contains a lot of attributes.  

    **Real-life example:** The stores sell two kinds of pizzas and sauces: beef and lamb pizza packed by wrapper, BBQ sauce and Mustered sauce packed in a pocket.
* Flyweight Pattern:
    
    This pattern defines a structure for sharing objects to increase efficiency and consistency. It reuses already existing similar kind objects by storing them (HashMap) and creates new object when no matching object is found 

  **Real-life example:** When author writes a lot of books in different languages, one book is written in English and one in Germany and so on. In such case English book was already created once, hence no need to create new such object, since same object may be reused.

* MVC pattern:

  This pattern is used to separate application's concerns: **_Model_**, **_View_**, **_Controller_** are created separately.

  **Real-life example:** When acclerating(controller), the engine(model) will respond by making car move faster, and the speedometer (view) will adapt to these changes and display the driver the current speed.


