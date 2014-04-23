<html>
<head><title>Student Advisors</title></head>

<body>
<?php

print "<h1>Student Advisor List</h1>";
print "<table border =\"1\" width = \"45%\">";
	print "<tr>";
		print "<td><b>Student Name</b></td><br><td><b>Faculty Advisor</b></td><br><td><b>Advisor Phone Number</b></td><br>";
	print "</tr>";
     
	$mysql_info = file("mysql_info.txt");
	$username = trim($mysql_info[0]);
	$password = trim($mysql_info[1]);
	$db_link = mysql_connect('localhost', $username, $password);
	$query = "select student_addisonu.s_first, student_addisonu.s_mi, student_addisonu.s_last, faculty.f_first, faculty.f_mi, faculty.f_last, faculty.f_phone from student_addisonu inner join faculty where student_addisonu.f_id = faculty.f_id order by faculty.f_last;";	

	if(mysql_select_db("northwoods", $db_link))
{
	$result = mysql_query($query, $db_link);
	$entries = mysql_num_rows($result);

	for($n = 0; $n < $entries; $n++)
{ 
	$record = mysql_fetch_assoc($result);
	$student_nm = $record{'s_first'}." ".$record{'s_mi'}." ".$record{'s_last'};
	$advisor_nm = $record{'f_first'}." ".$record{'f_mi'}." ".$record{'f_last'};
	$advisor_pn = substr($record{'f_phone'}, 0, 3)."<b >. </b>".substr($record{'f_phone'}, 3, 3)."<b>. </b>".substr($record{'f_phone'}, 6, 4);
		{
		print "<tr><td>$student_nm</td><td>$advisor_nm</td><td>$advisor_pn</td></tr>\n";
		}	
}

print "</table><br><br><footer>";
	mysql_free_result($result);
}	if(mysql_close($db_link)){print "<i>Request completed</i>\n";}
?>
</body>
</html>
