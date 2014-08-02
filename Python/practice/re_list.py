#!/usr/local/bin/python3

import re

re_list = dir(re)
re_flist = []

for func in re_list:
    if func.startswith("_"):
        continue
    if func != func.lower():
        continue
    if func.count("find") > 0:
        re_flist.append(func)

print(re_flist)
print(sorted(re_flist, reverse=True))
