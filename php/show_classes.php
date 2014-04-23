<html>
<head><title>Class Info</title></head>
<body>

<?php

$lines = file("cis.txt");
$header = preg_split("/\s+/", $lines[0]);

print "<p><table border = 1 width = \"100%\"><tr></p>";
for($n = 1; $n < count($header); $n++)
{
if($n == count($header) - 1)
{
print "<p><td><b>EMAIL</b></td></p>";
}
else
{
print "<p><td><b>$header[$n]</b></td></p>";
}
}
print "<p></tr></p>";
foreach ($lines as $line)
{
$name = '';

if($line != $lines[0])
{
print "<p><tr></p>\n";
$elements = preg_split("/\s+/", $line);
for($m = 0; $m < count($elements); $m++)
{
if($m < 10)
{
print "<p><td>$elements[$m]</td></p>\n";
}
else
{
$name = $name.' '.$elements[$m];

if($m == (count($elements) - 1) && (count($elements) == 12))
{
print "<p><td>$elements[10]</td></p>";
print "<p><td>N/A</td></p>";
}
elseif($m == (count($elements) - 1) && (count($elements) > 12))
{
ereg("([A-Z]{1}[[:alpha:]]+)[,]{1}[ ]{1}([A-Z]{1}[[:alpha:]]+)[ ]{0,1}[A-Z]{0,1}", $line, $ename);
#print "<p>$name[0]\n</p>";
#print "<p>$name[1]\n</p>";
#print "<p>$name[2]\n</p>";
$email = strtolower(substr($ename[2], 0, 1).substr($ename[1], 0, 6)."@ccsf.edu");
#print "<p>email =  $email\n</p>";
print "<p><td>$name</td></p>";
print "<p><td><a href = mailto:$email>$email</a></td>\n";
}
}
}
print "<p></tr></p>\n";
}
}
print "<p></table></p>\n";
?>
</body>

</html>
