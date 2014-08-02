#!/usr/local/bin/python3
# FILE: lab3.2.py
# DATE: Jul 12, 2014
# DESC: Text analyzer that counts words, paragraphs, and more

print('Content-type: text/html\n')▫
# Import glob for reading directories, re for regular expressions, and os manipulating path names.
import glob
import re
import os.path

# Read file names, assuming speeches are in public_html/speeches
speeches = glob.glob("../../speeches/*.txt")

# Process each speech
for speech in speeches:
    # Open the speech for reading as utf-8 (Unicode)
    s = open(speech, encoding="utf-8")

    # Get all of the lines for the speech
    lines = s.readlines()

    # Get just the name of the file, not including the path information.
    speech_name = os.path.basename(speech)

    # Turn the list of lines into a single string. The length of the line
    # is the file size.
    # Get all of the lines as lower case.
    all = "".join(lines).lower()
   
# Or you can get the file size with os.path.filesize.
    total_chars = os.path.getsize(speech)
##
# Do the Ten Most Meaningful words optional part of the assignment. 
# Use a list comprehension to get the stop words into a list. Remove the newline from each word.
    stop_words = [i.strip() for i in open('../../stop_words.txt').readlines()]
    count_words = {}
    char_cnt = 0
    for word in all:
        if word in stop_words: continue
        else:
            if count_words.get(word):
                count_words[word] += 1
            else:
                count_words[word] = 1

    speech_parts = speech.split('/')
    speech_name = speech_parts[3].split('.')
    char_cnt = 0

#Format for web
#print('Content-type: text/html\n')▫

#Print speech name
    print('\n', "Speech: ", speech_name[0])

#Print speech link
    print("<a href='http://hills.ccsf.edu/xxx/'>",speech_name[0], "</a>")

#Print characters in file
    print("Number of characters: ", len(all))

#Print the number lines in the files
    num_lines = sum(1 for line in speech)
    print("Number of lines: ", num_lines)

#Print number of words in the file
    print("Number of words: ", count_words[word], end="\n")
