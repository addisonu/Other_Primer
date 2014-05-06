#!/usr/bin/perl

# Modification Date: 09/17/13

# File Name: haiku.cgi

# Program Description: Displays a haiku via a browser

print "Content-type: text/html\n\n";

$date =  `date`;
$text_block = <<DOC;
<blockquote>

Today's date is $date<br> 
My name is <br><br>

From: The Perl Poetry Contest, Haiku Winner<br>
by Clinton Pierce<br><br>

<pre>

        1, 2 or more('to'),

        tie \$it, \$up and bind \$it, \$up;

        sub for ({ each %2; do {} };)
</pre>
</blockquote>
DOC

print $text_block;
