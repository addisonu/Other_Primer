<html>
<head><title>Class Schedule></title></head>

<body>
<?php
$semester = $_POST['semester'];
print "Semester: $semester";
print "<h1>Course Listings</h1>";
print "<p><b><table border = \"1\" width = \"70%\"></p>";
print "<p><tr><td>Course Name</td><td>Section</td><td>Instructor</td><td>Location</td><td>Days</td><td>Start Time</td></p>";

  	$mysql_info = file("mysql_info.txt");
	$username = trim($mysql_info[0]);
        $password = trim($mysql_info[1]);
        $db_link = mysql_connect('localhost', $username, $password);
     
        $query = "select courses.course_name, course_section.c_sec_id, faculty.f_first, faculty.f_mi, faculty.f_last, location.bldg_code, location.room, course_section.c_sec_day, course_section.c_sec_time, term.term_id, term.term_desc from course_section join courses on course_section.course_id = courses.course_id join faculty on course_section.f_id = faculty.f_id join location on course_section.loc_id = location.loc_id join term on course_section.term_id = term.term_id where term.term_desc = '$semester' order by course_name, c_sec_id;";
	if(mysql_select_db("northwoods", $db_link))
{ 
        $result = mysql_query($query, $db_link);
        $entries = mysql_num_rows($result);
        
        for($n = 0; $n < $entries; $n++)
	{ 
        	$record = mysql_fetch_assoc($result); 
		$course = $record{'course_name'};
        	$section = $record{'c_sec_id'};
        	$instructor = $record{'f_first'}." ".$record{'f_mi'}.", ".$record{'f_last'};
        	$location = $record{'bldg_code'}." ".$record{'room'};
        	$days = $record{'c_sec_day'};
        	$start_time = $record{'c_sec_time'};

		print "<p><tr><td>$course</td><td>$section</td><td>$instructor</td><td>$location</td><td>$days</td><td>$start_time</td></p>";
	}	
print "</table><br><br>";
        mysql_free_result($result);
}       if(mysql_close($db_link)){print "<i>Request completed</i>\n";}
?>
</body>
</html>
