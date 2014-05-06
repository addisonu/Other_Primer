#!/usr/bin/perl 
#
# File Name: tripper.pl
#
# Program Description: calculates mileage per gallon from user input of miles driven and gas used
 
 sub mileage($$) { 
     (my ($mymiles), my ($mygas)) = @_; 
         my $mympg = $mymiles / $mygas; 
             } 

            my $miles = 0; 
            my $gas = 0; 
            my $mpg = 0; 
   
            print "Number of miles driven: "; 
            chomp($miles = <STDIN> ); 
            print "Amount of gas used: "; 
            chomp($gas = <STDIN> ); 
            
            $mpg = mileage($miles, $gas); 
            printf "Your mileage (mpg) is %.2fnn", $mpg;
	    print "\n";
            sub total { 
                  my $sum;       
                  foreach (@_) {
 	                 $sum += $_; 
                               } 
                         $sum; 
                      }
