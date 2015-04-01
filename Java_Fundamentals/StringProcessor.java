//ASSIGNMENT : Project 11
//DATE : 03/26/15
//FILE : StringProcessor.java
//DESC : Class that performs various analyses on the text of a input string

import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.*;

public class StringProcessor{
    public static void main(String args[]){

// Get string from user
        char choice = 'n';

// Complete following string processing until quit
        do{
            System.out.print("Enter a line of text : ");
            Scanner input = new Scanner(System.in);
            StringProcessor str_proc = new StringProcessor(input.nextLine());

            System.out.println("words : " + str_proc.wordCount());
            System.out.println("uppercase : " + str_proc.uppercaseCount());
            System.out.println("digits : " + str_proc.digitCount());
            System.out.println("digit words : " + str_proc.digitWordCount());
            System.out.println("line with whitespace removed : " + str_proc.getNoSpaceString());
            System.out.println("line with vowels replaced : " + str_proc.getNoVowelString());
            System.out.println("line with digit words replaced : " + str_proc.getNoDigitWordString());
            System.out.print("Do you want to enter another line? (y/n) : ");
            choice = input.next().charAt(0);
        }while(choice == 'y');
    }

// DATA MEMBERS //
    private String str;

// MEMBER FUNCTIONS //
    public StringProcessor() { }

    public StringProcessor(String s)
    {
        str = s;
    }

    public void setString(String s)
    {
        str = s;
    }

    public String getString()
    {
        return str;
    }

// Return the number of words
    public int wordCount()
    {
        StringTokenizer str_tok = new StringTokenizer(str);
        return str_tok.countTokens();
    }

// Return the number of uppercase letters
    public int uppercaseCount()
    {
        int cnt = 0;
        for(int i = 0; i < str.length();++i){
            if(Character.isUpperCase(str.charAt(i)))
                ++cnt;
        }
        return cnt;
    }

// Return the number of digit characters (‘0’, ‘1’, ‘2’, ..., ‘9’)
    public int digitCount()
    {
        int cnt = 0;
        for(int i = 0; i < str.length(); ++i){
            if(Character.isDigit(str.charAt(i)))
                ++cnt;
        }
        return cnt;
    }

// Return the number of words that are English words representing the ten digits (“zero”, “one”, “two”, ..., “nine”)
    public int digitWordCount()
    {
// Array to hold words to compare to each token
        String dig_arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int cnt = 0;
        StringTokenizer str_tok = new StringTokenizer(str);
        String token;

// Perform case insensitive comparison of each token in string, incrementing cnt if true
        while(str_tok.hasMoreTokens()){
            token = str_tok.nextToken();
            for(int i = 0; i < dig_arr.length; ++i){
                if(token.equalsIgnoreCase(dig_arr[i])){
                    ++cnt;
                    break;
                }
            }
        }
        return cnt;
    }

// Return string with all spaces removed
    public String getNoSpaceString()
    {
        StringTokenizer str_tok = new StringTokenizer(str);
        String no_spaces = new String();
        while(str_tok.hasMoreTokens()){
            no_spaces += str_tok.nextToken();
        }
        return no_spaces;
    }

// Return string with all vowels replaced by the dash character ‘-’
    public String getNoVowelString()
    {
        String tmp_str = str;
        char vowel_arr[] = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};

// Loop vowel_arr.length times replacing all occurrences of vowel_arr[i] with '-'
        for(int i = 0; i < vowel_arr.length; ++i){
            tmp_str = tmp_str.replace(vowel_arr[i], '-');
        }
        return tmp_str;
    }

// Return string with all english words for digits replaced by digit characters
    public String getNoDigitWordString()
    {
// Array of elements to search for in str
        String digit_arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        StringTokenizer str_tok = new StringTokenizer(str);
        String tmp_str = new String(), token = new String();

        while(str_tok.hasMoreTokens()){
            token = str_tok.nextToken();
            for(int i = 0; i < digit_arr.length; ++i){

// If digit_arr[i] is found, add i to string, else add token
                if(token.equalsIgnoreCase(digit_arr[i])){
                    tmp_str += String.valueOf(i);
                    if(str_tok.hasMoreTokens())
                        tmp_str += " ";
                    break; // No need to continue search
                }
                else if(i == digit_arr.length - 1){
                    tmp_str += token;
                    if(str_tok.hasMoreTokens())
                        tmp_str += " ";
                }
            }
        }
        return tmp_str;
    }
}
