n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
points.sort()

def get_distance(p1, p2):
    return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2

def divide_conquer(start, end):
    if start == end:
        return 400000001
    if end - start == 1:
        return get_distance(points[start], points[end])
    mid = (start + end) // 2
    min_val = min(divide_conquer(start, mid), divide_conquer(mid, end))
    
    new_points = []
    for i in range(start, end+1):
        if (points[i][0] - points[mid][0])**2 < min_val:
            new_points.append(points[i])
    new_points.sort(key=lambda x: x[1])
    
    for i in range(len(new_points)-1):
        for j in range(i+1, len(new_points)):
            if (new_points[i][1] - new_points[j][1])**2 < min_val:
                min_val = min(min_val, get_distance(new_points[i], new_points[j]))
            else:
                break
    return min_val

print(divide_conquer(0, n-1))