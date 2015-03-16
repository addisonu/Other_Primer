//ASSIGNMENT : Project 7
//DATE : 02/26/15
//FILE : NumberGuesser.java
//DESC : class that allows user to play classic number guessing game in which the user picks a number, and your program tries to guess the number

public class NumberGuesser{

// MEMBER FUNCTIONS //
    public NumberGuesser(int lowerBound, int upperBound)
    {
        init_high = high = upperBound;
        init_low = low = lowerBound;
    }

    public void higher()
    {
        low = midpoint(low, high) + 1;
    }

    public void lower()
    {
        high = midpoint(low, high) - 1;
    }

    public int getCurrentGuess()
    {
        return midpoint(low, high);
    }

    public void reset()
    {
        high = init_high;
        low = init_low;
    }

    public int midpoint(int lowerBound, int upperBound)
    {
        return (high + low)/2;
    }
// DATA MEMBERS //
    private int high;
    private int init_high;
    private int low;
    private int init_low;
}
