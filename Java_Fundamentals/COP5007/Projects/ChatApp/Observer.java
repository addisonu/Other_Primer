/**
A class that provides the interface for objects to receive broadcasts
@version 1.0
Project *: 6

FILE NAME: Observer.java
DATE: 12/03/15
*/

public abstract class Observer{

// INSTANCE VARIABLES //

    /**
    Object to attach trackable objects to
    */
    protected Subject subject;

// METHODS //

    /**
    Executes code for all tracked objects upon a change to subject
    */
    public abstract void update();
}
