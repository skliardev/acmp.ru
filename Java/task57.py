import sys
from math import sqrt

class Point2D:
    def __init__(self, xp, yp):
        self.x = xp
        self.y = yp

    def distance(self, objPoint2D):
        if isinstance(objPoint2D, Point2D):
            dx = self.x - objPoint2D.x
            dy = self.y - objPoint2D.y
            return sqrt(dx * dx + dy * dy)
        return NotImplemented

    # def __str__(self):
    #     return str(self.x) + ":" + str(self.y)
    #
    # def __repr__(self):
    #     return ":".join([str(self.x), str(self.y)])

n, c, m = [int(e) for e in input().split()]
stack = list()

for line in sys.stdin:
    x = int(line.split()[0])
    y = int(line.split()[1])
    stack.append(Point2D(x, y))

prov = stack.pop()
smin = m + 1
for fpoint in stack:
    s = 0
    for spoint in stack:
        s += fpoint.distance(spoint)
        if s > smin: break
    s += fpoint.distance(prov)
    smin = s if s < smin else smin

print('YES' if smin*c <= m else 'NO')

