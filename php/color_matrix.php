<html>
<head><title>Color Matrix</title></html>

<body>
<?php

if((isset($_GET['back_color'])) && (isset($_GET['text_color'])))
{
$background = $_GET['back_color'];
$text = $_GET['text_color'];
$i = 0;

foreach($background as $col)
{
switch($col)
{
case "#000000":
  $back_lab[] = 'Black';
  break;
case "#FFFFFF":
  $back_lab[] = 'White';
  break;
case "#585858":
  $back_lab[] = 'Charcoal';
  break;
case "#58FAD0":
  $back_lab[] = 'Sea Foam';
  break;
case "#DF01D7":
  $back_lab[] = 'Fuchsia';
  break;
}
}
foreach($text as $col)
{
switch($col)
{
case "#F2F5A9":
  $text_lab[] = 'Lemon Custard';
  break;
case "#8A0808":
  $text_lab[] = 'Ox Blood';
  break;
case "#9F81F7":
  $text_lab[] = 'Lilac';
  break;
case "#0101DF":
  $text_lab[] = 'Cobalt';
  break;
case "#3A2F0B":
  $text_lab[] = 'Chocolate';
  break;
}
}
print '<b><font size = "6">Color Matrix</font><br><br><br>';
print '<table border = "1">'."\n";
for($row = 0; $row < count($text); $row++)
{
if($row == 0)
{
print "<tr><td width =\"150\"></td>";
foreach($background as $color)
{
print "<td width = \"100\"><b>$back_lab[$i] Background</b></td>";
$i++;
}
print '</tr>';
}
print '<tr>'."\n"."<td><b>$text_lab[$row] Text</b></td>";
for($column = 0; $column < count($background); $column++)
{
print "<td bgcolor = \"$background[$column]\"><i><font color = \"$text[$row]\">text</font><i></td>\n";
}
print '</tr>'."\n";
}

print '</table>';
}
else
{
print "<i><font size = \"4\">Error: You must select at least one text and background color.</font></i>";
}
?>
</body>

</html>
