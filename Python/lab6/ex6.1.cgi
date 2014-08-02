#!/usr/bin/python
# NAME: YOUR NAME
# FILE: ex6.1.cgi
# DESC: Connect to sqlite3 database, drop, create table and insert rows

import cgitb
import sqlite3

cgitb.enable()

try:

    connection = sqlite3.connect('lab6.1.db')
    cursor = connection.cursor()
    '''cursor.execute('DROP TABLE IF EXISTS users')
    cursor.execute('CREATE TABLE users (id integer primary key, first_name string, last_name string, color string)')
    cursor.execute('INSERT INTO users values(null, ?, ?, ?)', ('joe', 'smith', 'red'))
    cursor.execute('INSERT INTO users values(null, ?, ?, ?)', ('mary', 'jones', 'green'))
    cursor.execute('INSERT INTO users values(null, ?, ?, ?)', ('tom', 'brown', 'blue'))'''
    all = cursor.execute('SELECT * FROM student_urls')

except Exception as e:
    print('Content-type:text/html\n')
    print(e)
for row in all:
    print(row)
