<html>
<head><title>Image Upload Page</title></head>

<body>
<p><font size = "4"><b>Image Upload Page</b></font></p><br><br>
<form method = "post" action = "gallery_form_process.php" enctype = "multipart/form-data">
<input type = "hidden" name = "MAX_FILE_SIZE" value = "50000">
File: <input type = "file" name = "image_file"><br><br>
Password: <input type = "password" name = "pword"><br>
<input type = "submit" value = "Upload Image">
</form>
</body>
</html>

