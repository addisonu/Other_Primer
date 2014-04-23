<html>
<head><title>New Student Registration Form</title></head>

<body>
<h1>New Student Registration Form</h1><br><br>
<form method = "POST" action = "new_student_reg.php">
Last Name<font color = "red">*</font>:<input type = "textbox" name = "l_name">
First Name<font color = "red">*</font>:<input type = "textbox" name = "f_name">
Middle Initial:<input type = "textbox" size = "3" maxlength = "1" name = "m_i"><br><br>
Date of birth <i>(mmddyyyy)</i><font color = "red">*</font>:
 month<select name = "bday_m" size = "1">
<option value = "">
<option value = "01">Jan
<option value = "02">Feb
<option value = "03">Mar
<option value = "04">Apr
<option value = "05">May
<option value = "06">Jun
<option value = "07">Jul
<option value = "08">Aug
<option value = "09">Sep
<option value = "10">Oct
<option value = "11">Nov
<option value = "12">Dec
</select>
 day<input type = "textbox" size = "3" maxlength = "2" name = "bday_d">
 year<input type = "textbox" size = "3" maxlength = "4" name = "bday_y"><br><br>
Address<font color = "red">*</font>:<input type = "textbox" size = "45" name = "address"><br><br>
City<font color = "red">*</font>:<input type = "textbox" name = "city">
State<font color = "red">*</font>:<select name = "state">
<option value = "">
<?php
$mysql_info = file("mysql_info.txt");
        $username = trim($mysql_info[0]);
        $password = trim($mysql_info[1]);
        $db_link = mysql_connect('localhost', $username, $password);
	$query = "select s_abbreviation from state;";

if(mysql_select_db("northwoods", $db_link))
{
        $result = mysql_query($query, $db_link);
        $entries = mysql_num_rows($result);

        for($n = 0; $n < $entries; $n++)
{
        $record = mysql_fetch_assoc($result);
	print "<p><option value = \"".$record{'s_abbreviation'}."\">".$record{'s_abbreviation'}."</p>";
}
	mysql_free_result($result);
	mysql_close($db_link);
}
?>
</select>
Zip Code<font color = "red">*</font>:<input type = "textbox" size = "7" maxlength = "5" name = "zip"><br><br>
Phone <i>(xxx-xxx-xxxx)</i><font color = "red">*</font>: (<input type = "textbox" size = "3" name = "area_ph">) -
<input type = "textbox" size = "3" name = "pre_ph"> -
<input type = "textbox" size = "5" name = "suf_ph"><br><br>
<input type = "reset" value = "clear">
<input type = "submit" value = "submit">
</form>
<p><i>All fields followed by <font color = "red">*</font> are required</i></p>
</body>
</html>
