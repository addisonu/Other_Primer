#!/usr/bin/python
# Python 2.6!!
# NAME: YOURNAME
# FILE: run_me_first.py
# DESC: Run this script on the command line to initialze the database for lab6.1.cgi.
# or import it into another script.

import sqlite3

create_sql = """
CREATE TABLE student_urls (
id integer primary key, user_name string, assignment integer, url string, created_at datetime) """

def __main__():
    try:
        connect = sqlite3.connect('lab6.1.db')
        cursor = connect.cursor()
        # Check to see if table has been created
        cursor.execute('DROP TABLE IF EXISTS student_urls')
        cursor.execute(create_sql)
    except Exception as e:
        error_string = e
if __name__ == '__main__':
    __main__()
