#!/usr/local/bin/python3 -u

import sys

data = open('../../images/python-logo-master-v3-TM-flattened.png', 'rb').read()
print("Content-Type: image/png\nContent-Length: %d\n" % len(data))
sys.stdout.buffer.write(data)
