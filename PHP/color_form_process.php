<html>
<head>
<title>Color Form Processor</title>
</head>

<body>
<?php

$text_color = $_GET['text_color'];
$background_color = $_GET['background_color'];

switch($text_color) 
{
 case '#A9F5D0': $text = "sea foam green";
 break;
 case '#BCF5A9': $text = "pale lime green" ;
 break;
case '#00FFFF': $text = "teal foam green";
 break;
case '#ACFA58': $text = "lime green";
 break;
case '#0B614B': $text = "viridian green";
 break;
case '#FFFFFF': $text = "white";
 break;
case '#000000': $text = "black";
 break;
}

switch($background_color) 
{
 case '#A9F5D0': $background = "sea foam green";
 break;
 case '#BCF5A9': $background = "pale lime green" ;
 break;
case '#00FFFF': $background = "teal foam green";
 break;
case '#ACFA58': $background = "lime green";
 break;
case '#0B614B': $background = "viridian green";
 break;
case '#FFFFFF': $background = "white";
 break;
case '#000000': $background = "black";
 break;
}
if($text_color == $background_color)
{
print "<br><i><p style =\"color:black;background-color:white;font-size:large;\"> Error: The background color selected must be different from the text color selected.</p><i>";
}
else
{
print "<br><i><p style =\"color:$text_color;background-color:$background_color;font-size:large;\"> The background color displayed is $background. The text color displayed is $text.</p><i>";
}
?>
</body>

</html>
