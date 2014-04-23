<html>
<head></head>
<body>
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
        #print "<p><option value = \"$record\">$record</p>";
        print "<p>".$record{'s_abbreviation'}.$record{'s_abbreviation'}."</p>";
}
        mysql_free_result($result);
        mysql_close($db_link);
}
?>
</body>
</html>
