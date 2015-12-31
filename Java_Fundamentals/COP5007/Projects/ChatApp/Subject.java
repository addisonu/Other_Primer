/**
A class that acts as a broadcaster for all objects of a type added to a Subject object
@version 1.0
Project *: 6

FILE NAME: Subject.java
DATE: 12/03/15
*/

import java.util.ArrayList;
import java.util.List;

public class Subject {

// INSTANCE VARIABLES //

    /**
    Container for all objects to broadcast to
    */
    private List<Observer> observers = new ArrayList<Observer>();

    /**
    State of an object
    */
    private String state;

// METHODS //

    /**
    Returns the instance variable state
    */
    public String getState() {
        return state;
    }

    /**
    Calls function to send notifications
    */
    public void setState(){
        notifyAllObservers();
    }

    /**
    Adds an object to be broadcasted to
    @param observer the object to receive notifications
    */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
    Notifies all tracked objects of a change in state
    */
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
