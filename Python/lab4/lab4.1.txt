#!/usr/local/bin/python3
#FILE: lap4.1.py
#DATE: 07/20/14
#DESC: Exercise in modules

from shape import Shape
from circle import Circle

c1 = Circle(7, 10, 10)
c2 = Circle(25, 0, 0)

c1_xdelta = 2
c1_ydelta = 3
c2_xdelta = 1
c2_ydelta = -1

for i in range(1, 20):
    if i%10 == 0:
        c1.move(-10 + i, -10 - i )
    else:
        c1.move(c1_xdelta, c1_ydelta)
    c2.move(c2_xdelta, c2_ydelta)
    # Print c1.__str__()
    print(c1)
    #Print c2.__str__()
    print(c2)
    #Print collision True or None
    print("Collision: {collision}".format(collision = Circle.is_collision(c1, c2)))
