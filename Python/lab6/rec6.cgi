#!/usr/bin/python
# Python 2.6.6!!!
# File: lab6.1.cgi
# Description: collect student assignment URLs

#PROGRESS: Remove .format() code

import htmllib
import cgitb
cgitb.enable()
import cgi
import os
import sqlite3
import sys

# defaults
user_name = ''
url = ''
assignment = 0
errors = []

# Students that can use form
ccsf_students = "dputnam,smccorm2,jgurung2,wli13,kkrauss,cmyers,eyao,csander6,jsteimni,jlarsen3,aboak,jmencha1,mhawver,jmo6,bparra,mkunze,ckwan17,iburenin,mnicasio,rtzeng,whuttner,gwong7,abettini,ahapp,cferrei2,creeve,psakhark,dboone1,npachec2,ftan".split(',')

# Use only this password
password = 'summer2014cohort!'
links = []

try:
    # Initial setup runs one time
    connect = sqlite3.connect('lab6.1.db')
    cursor = connect.cursor()
except Exception as e:
    error_string = e

request = cgi.FieldStorage()

print("Content-type: text/html\n")

if os.environ['REQUEST_METHOD'] == 'POST':

    assignment = request["assignment"].value
    if('user_name' in request) and request["user_name"].value.strip() in ccsf_students:
        user_name = request["user_name"].value.strip()
    else:
        errors.append("Username incorrect or missing")
    if('url' in request):
        # URL must be http://subdomain.appspot.com or http://subdomain.herokuapp.com
        valid_url = request["url"].value.strip()
        valid_url = valid_url.split('.')
        if len(valid_url) == 3:
            if valid_url[0].startswith('http://') and valid_url[1] in ('herokuapp', 'appspot') and valid_url[2] == "com":
                url = request["url"].value.strip()
                links.append(url)
            else:
                errors.append('Url incorrect or missing')
        else:
            errors.append('Url incorrect or missing')
    else:
        errors.append('Url incorrect or missing')
    if('password' in request) and request["password"].value == password:
        pass
    else:
        errors.append('Password incorrect or missing')

    if len(errors) == 0:
        cursor.execute("INSERT INTO student_urls (user_name, assignment, url, created_at) values(?, ?, ?, date('now'))" ,(user_name, assignment, url))
        connect.commit()
    if len(errors) == 0:
        print('''Status: 302 Moved Temporarily
        X-Powered-By: Python 3.3
        Location: <a href="http://hills.ccsf.edu/xxx/cs131a/rec6.cgi">Register your Cloud web app</a>
        Content-type: text/html\n''')
        sys.exit()

#Html form to gather user data
print('''

<!doctype html>
<html lang = "en-us">
    <head>
        <meta charset = "utf-8">
        <title>Lab 6.1: CGI Form</title>
        <meta name = "description" content = "Form for entering AppEngine and Herokuapp URLs">
        <meat name = "author" content = "xxx"
        <!-- [if lt IE 9]>
        <script src = "http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
        <form action = "" method = "post">
        <div id = "headline"><h1>Register your Cloud web app</h1></div>
        <p>
            <label for = "assignment">Assignment</label>
            <select name = "assignment">
                <option value = "6">6 CGI Form</option>
                <option value = "7">7 APP Engine</option>
            </select>
        </p>
        <p>
            <label for = "user_name">Hills UserID</label>
            <input type = "text" name = "user_name" value = "" id = "user_name" required>
            </p>
        <p>
            <label for = "url">Cloud URL</label>
            <input type = "url" name = "url" value = "" required>
        </p>
        <p>
            Use the password specified in Assignment 6.</p>
        <p>
            <label for = "url">Authentication</label>
            <input type = "password" name = "password" value = "" required>
        </p>
        <p style = "text-align:center;padding-top:1.4em;margin-bottom:0">
            <input type = "submit" name = "submit" value = "Submit URL">
        </p>
        </form>
    </body>
<html>''')

if errors:
    for error in errors:
        print('<ul><li>')
        print(error)
        print('</li></ul>')

'''if len(errors) == 0:
    cursor.execute("INSERT INTO student_urls (user_name, assignment, url, created_at) values(?, ?, ?, date('now'))" ,(user_name, assignment, url))
     connect.commit()'''
all = cursor.execute("SELECT * FROM student_urls order by created_at, user_name")
cnt = 1
for row in all:
    #Escape strings and ensure that integers are integers by using int()
    student = cgi.escape(row[1])
    course = int(row[2])
    url = cgi.escape(row[3])
    date = cgi.escape(row[4])
    url_link = '<a href="' + url + '"> ' + url + '</a> <div style="float:right">{}</div>'
    print(cnt)
    print(str(student))
    print(str(course))
    print(url_link)
    print(str(date))
    print('<br><br>')
    cnt+= 1
