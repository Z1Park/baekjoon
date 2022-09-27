def distance(p):
    x1 = ax1 * p + ax2 * (1 - p)
    y1 = ay1 * p + ay2 * (1 - p)
    x2 = bx1 * p + bx2 * (1 - p)
    y2 = by1 * p + by2 * (1 - p)
    return ((x1 - x2)**2 + (y1 - y2)**2)**0.5

ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 = map(int, input().split())

front, end = 0, 1
while abs(end - front) > 1e-9:
    n_front = (front * 2 + end) / 3
    n_end = (front + end * 2) / 3
    if distance(n_front) > distance(n_end):
        front = n_front
    else:
        end = n_end
print("%1.10f" % distance(front))