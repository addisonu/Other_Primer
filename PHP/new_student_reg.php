<html>
<head><title>New Student Registration Process Page</title></head>

<body>
<?php
#required fields define/undefine status
if(preg_match("/^[a-z][a-z '-]*$/i", $_POST['l_name']))
	{$l_name = $_POST['l_name'];}
if(preg_match("/^[a-z][a-z '-]*$/i", $_POST['f_name']))
	{$f_name = $_POST['f_name'];}
if(preg_match("/^[a-z]$/i", $_POST['m_i']))
	{$m_i = $_POST['m_i'];}
if(
!empty($_POST['bday_m']) &&
ctype_digit($_POST['bday_d']) && strlen($_POST['bday_d']) == 2 &&
ctype_digit($_POST['bday_y']) && strlen($_POST['bday_y']) == 4)
	{$birth = $_POST['bday_y']."-".$_POST['bday_m']."-".$_POST['bday_d'];}
if(preg_match("/^[0-9a-z \.-]*$/i", $_POST['address']))
	{$address = $_POST['address'];}
if(preg_match("/^[a-z \.'-]*$/i", $_POST['city']))	
	{$city = $_POST['city'];}
$state = $_POST['state'];
if(ctype_digit($_POST['zip']) && strlen($_POST['zip']) == 5)
	{$zip = $_POST['zip'];}
if(
ctype_digit($_POST['area_ph']) && strlen($_POST['area_ph']) == 3 &&
ctype_digit($_POST['pre_ph']) && strlen($_POST['pre_ph']) == 3 &&
ctype_digit($_POST['suf_ph']) && strlen($_POST['suf_ph']) == 4)
	{$phone = $_POST['area_ph'].$_POST['pre_ph'].$_POST['suf_ph'];}
if(!empty($l_name) && !empty($f_name) && !empty($address) && !empty($city) && !empty($state) && !empty($city) && !empty($zip) && !empty($phone) && !empty($birth))
{
	$s_pin = "";	
	for($n = 0; $n < 4; $n++)
	{
		$s_pin = $s_pin.(rand(0, 9));
	} 
	$f_id = rand(1, 5);	

	$mysql_info = file("mysql_info.txt");
        $username = trim($mysql_info[0]);
        $password = trim($mysql_info[1]);
        $db_link = mysql_connect('localhost', $username, $password);

	if(mysql_select_db("southbeach", $db_link))
	{
		$query = 	"INSERT INTO table_s 
				(s_last, s_first, s_mi, s_address, s_city, s_state, s_zip, s_phone,
				s_class, s_dob, s_pin, f_id) 
				VALUES ('$l_name', '$f_name', '$m_i', '$address', '$city', '$state', 
				'$zip', '$phone', 'FR', '$birth', '$s_pin', '$f_id');";
		$update = mysql_query($query, $db_link);
		if($update)
		{
			print "Your registration has been successful,
			 and your new pin number is $s_pin.";
		}	
	}
	if(mysql_close($db_link)){print "<i><br><br>Request completed</i>\n";}

}
else
{
	$field = array("l_name"=>"Last Name", "f_name"=>"First Name", "m_i"=>"Middle Initial", "bday_m"=>"Date of birth", "bday_d"=>"Date of birth", "bday_y"=>"Date of birth", "address"=>"Address", "city"=>"City", "state"=>"State", "zip"=>"Zip Code", "area_ph"=>"Phone Number", "pre_ph"=>"Phone Number", "suf_ph"=>"Phone Number"); 
	
	print "<font size = '5'><b>You must complete all required fields.
	Currently, the following fields have been left blank or entered incorrectly:
		<br><br></b></font><font size = '4'>";
	foreach ($field as $input)
	{
		$input_key = array_search($input, $field); 
		
		if(empty($_POST[$input_key]) && $input_key != "m_i"){$blank_field[$input] = $input_key;}
	}
	foreach(array_keys($blank_field) as $empty_key)
	{
		print "$empty_key <br>";
	}	
	print "<br>Please <a href=http://.php>return</a> to the new student registration form and complete it.</font>";
}
?>
</body>
</html>
