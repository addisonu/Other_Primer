#!/usr/local/bin/python3
#FILE: circle.py
#DESC: A circle class that subclasses Shape, with is_collision(), distance(), and __str__() methods

from shape import Shape
from math import sqrt

class Circle(Shape):
    """Circle Class: inherits from Shape and has method area"""
    pi = 3.14159
    def __init__(self, r = 1, x = 0, y = 0):
        Shape.__init__(self, x, y)
        self.radius = r
    def area(self):
        """Circle area method: returns the area of the circle."""
        return self.radius * self.radius * self.pi
    def __str__(self):
        return "Circle of radius {:.0f} at coordinate ({:.0f}, {:.0f})"\
                .format(self.radius, self.x, self.y)
   
    @classmethod
    def distance(Circle, c1, c2):
        '''calculate distance between two circle'''
        circ_distance = sqrt(c1.x**2 + c2.x**2)
        return circ_distance
    @classmethod
    def is_collision(Circle, c1, c2):
        '''Return True or None'''
        if c2.radius > (c2.distance(c1, c2) - c1.radius):
            return True
        else:
            return None
