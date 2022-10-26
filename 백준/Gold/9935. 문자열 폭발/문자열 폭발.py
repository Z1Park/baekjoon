import sys
input = lambda : sys.stdin.readline().rstrip()
txt = list(input())
bomb = list(input())
res = []
for t in txt:
    res.append(t)
    if len(res) >= len(bomb) and res[-len(bomb):] == bomb:
        res[-len(bomb):] = []
print(''.join(res) if res else "FRULA")