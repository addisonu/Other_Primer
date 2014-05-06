#!/usr/bin/perl
# ora_icecream.cgi: program to answer and generate ice cream

use CGI qw(:standard);

print header, start_html("Ice Cream Stand"), h1("Ice Cream Stand");

if (param()) { # the form has already been filled out
    my $who = param("name");
    my $flavor = param("flavor");
    my $scoops = param("scoops");
    my $taxrate = 1.0743;
    my $cost = sprintf("%.2f", $taxrate * (1.00 + $scoops * 0.25));
    print p("Ok, $who, have $scoops scoops of $flavor for \$$cost.");
} else { # first time through, so present clean form
    print hr(); # draw a horizontal rule before the form
    print start_form();
    #print a textfile inside a paragraph tag
    print p("What's your name? ", textfield("name"));
    #print a popup menu with 3 options inside a paragraph tag
    print p("What flavor: ", popup_menu("flavor", 
                                           ['mint','cherry','mocha']));
    #another popup menu with 3 options inside a paragraph tag
    print p("How many scoops? ", popup_menu("scoops", [ 1..3 ]));
    #the submit and reset buttons
    print p(submit("order"), reset("clear"));
    print end_form(), hr();
}
print end_html;
