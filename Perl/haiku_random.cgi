#!/usr/bin/perl
#File Name: haiku_random.cgi
#Program Description: Produces haiku made of randomly selected sentences 

print "Content-type: text/html\n\n";

$p0 = "the rain falls tonight";
$p1 = "fog robes seldom worn"; 
$p2 = "swirling leaves blood orange";
$p3 = "New York fashion shocking sight";
$p4 = "wait year long anticipate";
$p5 = "lightning flashing blazes sky";
$p6 = "shadow dark light waltz";
$p7 = "whispers of wind and tree";
$p8 = "luna brazen then shy";

@poetry0 = ($p0,$p1,$p2);
@poetry1 = ($p3,$p4,$p5);
@poetry2 = ($p6,$p7,$p8);

$line0 = $poetry0[rand @poetry0];
$line1 = $poetry1[rand @poetry1];
$line2 = $poetry2[rand @poetry2];

print "<pre>\n";
print "$line0\n$line1\n$line2\n";
print "</pre>\n";
