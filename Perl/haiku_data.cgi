# File Name: haiku_data.cgi
# Program Description: appends user input to a file
		
$size_of_form_information = $ENV{'CONTENT_LENGTH'};
read (STDIN, $value, $size_of_form_information);

$value =~ tr/+/ /;
$value =~ s/%([a-fA-F0-9][a-fA-F0-9])/pack("C", hex($1))/eg;
$value =~ s/~!/ ~!/g;

$_ = $value;
/l1=(.*?)&/;
$l1 = $1;
/l2=(.*?)&/;
$l2 = $1;
/l3=(.*?)$/;
$l3 = $1;

print "Content-type: text/html\n\n";
print $form_data;

if($l1 ne "" && $l2 ne "" && $l3 ne "")
{
print "<pre>\n";

open(DATASTORE, ">>formdata.dat") || die "Couldn't open DATASTORE: $!\n";
        print DATASTORE "$l1:$l2:$l3\n";
close(DATASTORE);
        print "<br><br><font size = '5'><strong>Thank you for using the haiku data form. The lines you entered into the form are:<br><br>Line 1: $l1<br>Line 2: $l2<br>Line 3: $l3</font>";

print "<pre>\n";
}
else
{

print "<p><font size = '5'><b><i>Error:</i></b><br><br>No field can be blank, click <a href=http://hills.ccsf.edu/~uaddison/haiku_data.html>here</a> to try again</font></p>";
}
