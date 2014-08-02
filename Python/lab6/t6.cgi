#!/usr/bin/python
# Python 2.6.6!!!
# File: lab6.1.cgi
# Description: collect student assignment URLs

import htmllib
import cgitb
cgitb.enable()
import cgi
import os
import sqlite3

# defaults
user_name = ''
assignment = ''
url = ''

# Students who can use form
ccsf_students = "dputnam,smccorm2,jgurung2,wli13,kkrauss,cmyers,eyao,csander6,jsteimni,jlarsen3,aboak,jmencha1,mhawver,jmo6,bparra,mkunze,ckwan17,iburenin,mnicasio,rtzeg,whuttner,gwong7,abettini,ahapp,cferrei2,creeve,psakhark,dboone1,npachec2,ftan".split(',')

# Use only this password
password = 'summer2014cohort!'
links = []

# Allowed student
# Use the ccsf_students list

try:
    # Initial setup runs one time
    connect = sqlite3.connect('apps.db')
    cursor = connect.cursor()
except Exception as e:
    error_string = e
request = cgi.FieldStorage()

print("Content-type: text/html\n")

# Check for empty fields
if os.environ['REQUEST_METHOD'] == 'POST':
    if ('user_name' in request) and request["user_name"].value.strip in ccsf_students:
        user_name = request["user_name"].value
    else:
        errors.append('Username incorrect or missing')
    if ('url' in request) and request["url"]:
        url = request["url"].value
    else:
        errors.append('URL incorrect or missing')
    if ('password' in request) and request["password"].value.strip == password:
        continue
    else:
        errors.append('Password incorrect or missing')

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
                <option value "7">7 APP Engine</option>
            </select>
        </p>
        <p>
            <label for = "user_name">Hills UserID</label>
            <input type = "text" name = "user_name" value = "{user_name}" id = "user_name" required>
            </p>
        <p>
            <label for = "url">Cloud URL</label>
            <input type = "url" name = "url" value = "{url}" required>
        </p>
        <p>
            Use the password specified in Assignment 6.</p>
        <p>
            <label for = "url">Authentication</label>
            <input type = "password" name = "password" value ="{password}" required>
        </p>
        <p style = "text-align:center;padding-top:1.4em;margin-bottom:0">
            <input type = "submit" name = "submit" value = "Submit URL">
        </p>
        </form>'''.format(user_name=cgi.escape(user_name), url=cgi.escape(url), password=cgi.escape(password)))
print('''
    </body>
<html>''')

