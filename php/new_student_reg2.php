<html>
<head><title>New Student Registration Process Page</title></head>

<body>
<?php
#required fields define/undefine status
if(preg("/[a-z/gi", $_POST['l_name']))
	{$l_name = $_POST['l_name'];}
$f_name = $_POST['f_name'];
#if(ereg{[[:alpha:]], $_POST['m_i']); {
$m_i = $_POST['m_i'];#}
$birth = $_POST['bday_y']."-".$_POST['bday_m']."-".$_POST['bday_d'];
$address = $_POST['address'];
$city = $_POST['city'];
$state = $_POST['state'];
#if(ctype_digit($_POST['zip'])	{
$zip = $_POST['zip'];#}
#if(ctype_digit($_POST['area_ph']) && ctype_digit($_POST['pre_ph']) && ctype_digit($_POST['suff_ph']))	{
$phone = $_POST['area_ph'].$_POST['pre_ph'].$_POST['suf_ph'];#}

if(!empty($l_name) && !empty($f_name) && !empty($birth) && !empty($address) && !empty($city) && !empty($state) && !empty($city) && !empty($zip) && !empty($phone))
{
print "all is set MASTA!!";
}
else
{
print "You must complete all required fields. Please return to the new student registration form and complete it.";
}
?>
</body>
</html>
