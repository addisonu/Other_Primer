#!/usr/local/bin/python3
#FILE: shape.py
#DESC: A shape class form The Quick Python Book (pg. 30)

"""sh module. Contains classes Shape, Square, and Circle"""

class Shape:
    """Shape class: has method move"""
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def move(self, deltaX, deltaY):
        self.x = self.x + deltaX
        self.y = self.y + deltaY
    def location(self):
        '''Returns a tuple containing the ~x,y~ cooridinates of an object.'''
        coords = (self.x, self.y)
        return coords
class Square(Shape):
    def __init__(self, side = 1, x = 0, y = 0):
        super().__init__(x, y)
        self.side = side
