#!/usr/bin/env python
import sys, unicodedata
for ch in range(1, 4).decode('utf-8'):
    try:
        print unicodedata.name(ch)
    except ValueError:
        print 'codepoint ', ord(ch)
