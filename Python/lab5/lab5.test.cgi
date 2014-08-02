#!/usr/local/bin/python3

import base64
import binascii
import sys

#import cgitb
#cgitb.enable()

image_dir = '/students/xxx/public_html/images/'
f = open(image_dir + 'skull.jpg', 'rb')
bytes = f.read()


#ff = open(image_dir + 'python_logo_copy.png', 'wb')
#ff.write(data)

encoded2 = str(base64.b64encode(bytes))
encoded2 = str(base64.b64encode(bytes)).replace(r'\n', '')
encoded2 = str(binascii.b2a_base64(bytes)).replace(r'\n', '')
for_css = str(encoded2)[2:-1].strip()

print('Content-type:text/html\n')

print('''<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
            <title>Lab 5.1.cgi</title>
        <style type="text/css">
        body {background-color:white;font-style:none;font-weight:normal;font-family:Courier, Helvetica, Arial, sans-serif, WenQuanYi, Arial Unicode MS, GNU Unifont, Code2000, Lucida Grande;font-weight:bold;font-size:30px;color:#81F7D8;
        text-shadow: 0 0 2px black,0px 0px 8px white;
        background:url(data:image/png;base64,%s);text-align:center}
        h1 {font-size:72px;font-weight:bold}
        h2 {font-weight:normal}
        div {font-family:Arial;font-size:30px;color:#81F7D8;text-align:center;text-shawdow:none;background-color:black;width:900px;margin: auto}.source {width:960px} table {table-layout:fixed;width900px;} th {:text-align:left;}
        </style>
    </head>
        <body>
            <h1>Courier</h1>
            <div>

        </body>
</html>''' % for_css)
print('<html><table border="1" style="width:900px">')
for i in range(33, 4000):
    if i == 127:
        continue
    if i%4 == 0:
        print("<tr>")
        for i in range(i, i+10):
            print("<td>&#{!s}".format(i), "</td>")
        print("</tr>")
print("</table></html>")
    # SOURCE CODE
    ##PRINT SOURCE CODE
