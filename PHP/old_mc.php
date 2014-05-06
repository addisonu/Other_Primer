<html>
<head><title>Old MacDonald had a farm, la la la laahh!</title></head>

<body>
<?php

$choice = $_POST['verseData'];

foreach ($choice as $selection)
{
$list = explode(':', $selection);
$name[] = $list[0];
$sound[] = $list[1];
}

function printOneVerse($name,$sound)
{
for($i = 0; $i < count($name); $i++)
{
$verse = <<< VERSE

<pre>
Old MacDonald had a farm, E-I-E-I-O! 
And on that farm he had a $name[$i], E-I-E-I-O! 
With a $sound[$i]-$sound[$i] here and a $sound[$i]-$sound[$i] there

Here a $sound[$i], there a $sound[$i], everywhere a $sound[$i]-$sound[$i]
Old MacDonald had a farm, E-I-E-I-O!
</pre>
VERSE;

print "$verse";
}
}

printOneVerse($name, $sound);
?>
</body>
</html>
