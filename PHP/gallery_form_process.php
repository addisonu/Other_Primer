<html>
<head><title><Art Gallery></title></head>

<body>
<?php

$filelist = glob("../images/*gif");

if(isset($_FILES['image_file']))
{
$file_name = $_FILES['image_file']['name'];
$image_dir = "xxx/xxx/xxx"."$file_name";

if($_FILES['image_file']['error'] != UPLOAD_ERR_OK||
$_FILES['image_file']['type'] != "image/gif"||
$_POST['pword']!= "cs130a")
{
print "<p>File not uploaded successfully :(</p>";
print "<p>To upload another file <a href = 'gallery_form.php'>CLICK HERE</a></p>";
}
else
{
move_uploaded_file($_FILES['image_file']['tmp_name'],$image_dir)
or die("Unable to move file to $image_dir");
print "<p><b><div align = \"center\"><font size = \"6\">Art Gallery</font></div></b><br><i>The file was uploaded sucessfully</i></p>";

$filelist = glob("../images/*gif");
  if ($filelist != false) {
    print "<p><b><font size = \"5\">Here are some pictures:</font></b></p>";
    foreach ($filelist as $file) {
      $url = 'images/'.substr($file, strrpos($file, '/') + 1);
print "<p><b>".substr($file, strrpos($file, '/') + 1).":<br><img src = '$url'></b></p>";  
}
  }
print "<p>To upload another file <a href = 'gallery_form.php'>CLICK HERE</a></p><br>";
}
}
elseif($filelist == false)
{
print "<p><i><font size = \"4\">Sorry, there are no pictures to display</font></i></p>";
}
else
{ 
if ($filelist != false) {
    print "<p><b><div align = \"center\"><font size = \"6\">Art Gallery</font></div><br><font size = \"5\">Here are some pictures:</font></b></p>";
    foreach ($filelist as $file) {
      $url = 'images/'.substr($file, strrpos($file, '/') + 1);
print "<p><b>".substr($file, strrpos($file, '/') + 1).":<br><img src = '$url'></b></p>";
}
  }
print "<p>To upload another file <a href = 'gallery_form.php'>CLICK HERE</a></p><br>";

}
?>
</body>

</html>
