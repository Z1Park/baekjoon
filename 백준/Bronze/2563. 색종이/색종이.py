n = int(input())
lst = [[0 for a in range(100)] for b in range(100)]
for i in range(n):
    x, y = map(int, input().split())
    for j in range(10):
        for k in range(10):
            lst[x + j][y + k] = 1
s = 0
for i in range(100):
    s += sum(lst[i])
print(s)