<html>
<head><title>Multiplication Table</title></head>

<body>

<?php

$N = $_GET['N'];

if($N >= 1 && $N <=10 && ctype_digit($N))
{
print "<strong><font size = \"5\">$N x $N Multiplication Table</font></strong><br><br>";
print '<table border = "3">';
print "<th width = \"50\"> </th>";
for($head = 1; $head <= $N; $head++)
{
printf("<th> <font size = \"4\">%d</font> </th>", $head);
}
for($row = 1; $row <= $N; $row++)
{
print "<tr>\n";
printf("<th><b> <font size = \"4\">%d</font> </b></th>",  $row);
for($column = 1; $column <= $N; $column++)
{
printf("<td width = \"100\"> $row * $column = <font color = \"red\">%d</font> </td>", ($row)*($column));
print "\n";
}}
}
else
{
print "<p><font size = \"5\"><i>Error: You must enter an integer from 1 to 10.</i></p>";
}
print '</table>';
?>
</body>

</html>
