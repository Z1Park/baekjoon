import sys
input = sys.stdin.readline

n = int(input())
s = []
for i in range(1, n + 1):
    s.append(i)
while (len(s) > 1):
    tmp = []
    for i in range(n):
        if i%2 == 1:
            tmp.append(s[i])
    s.clear()
    s = tmp.copy()
    if len(s) != 1 and n % 2 == 1:
        s.insert(0, 0)
        n += 1
    n //= 2
print(s[0])