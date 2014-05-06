#!/usr/bin/perl -p0777 
# File Name: html_strip.pl
# Program Description: This program removes the markup language from a file
 
%entity = 
(
lt     => '<',     #a less-than
gt     => '>',     #a greater-than
amp    => '&',     #an ampersand
quot   => '"',     #a (vertical) double-quote
nbsp   => chr 160, #no-break space
iexcl  => chr 161, #inverted exclamation  mark
cent   => chr 162, #cent sign
pound  => chr 163, #pound sterling
curren => chr 164, #general currency sign
'#65'  => 'A'      #ASCII 65 becomes capital 'A'
);

s/<!--(.*)-->/<!--\U\1-->/gs; 
s/^(:?<\w+>\s+)|(:?<[^-]*?>)//gs;
s/&(\#?.*?);/$entity{$1}/gs;
 
