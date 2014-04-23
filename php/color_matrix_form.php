<html>
<head><title>Color Matrix Form</title></head>

<body>
<form method = "GET" action = "color_matrix.php">
<p><font size = "5"><b>Color Matrix</b></font></p>

<p>Background Color:</p>
<select name = "back_color[]" size = 5 multiple>
<option value = "#000000" SELECTED> Black
<option value = "#FFFFFF"> White
<option value = "#585858"> Charcoal
<option value = "#58FAD0"> Sea Foam
<option value = "#DF01D7"> Fuchsia
</select>
<br><br>
<p>Text Color:</p>
<select name = "text_color[]" size = 5 multiple>
<option value = "#F2F5A9" SELECTED> Lemon Custard
<option value = "#8A0808"> Ox Blood
<option value = "#9F81F7"> Lilac
<option value = "#0101DF"> Cobalt
<option value = "#3A2F0B"> Chocolate
</select>
<br><br>
<input type = "submit" value = "submit"> 

</form>
</body>

</html>
