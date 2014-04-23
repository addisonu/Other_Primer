<html>
<head><title>Generate Email</title></head>

<body>
<?php

$lines = file("cis.txt");

foreach($lines as $line)
{
print "<p>$line\n</p>";
ereg("([A-Z]{1}[[:alpha:]]+)[,]{1}[ ]{1}([A-Z]{1}[[:alpha:]]+)[ ]{1}[A-Z]{1}", $line, $name);
print "<p>$name[0]\n</p>";
print "<p>$name[1]\n</p>";
print "<p>$name[2]\n</p>";
$email = strtolower(substr($name[2], 0, 1).substr($name[1], 0, 6)."@ccsf.edu");
print "<p>email =  $email\n</p>";

}
?>
</body>
</html>
