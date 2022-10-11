import sys
input = sys.stdin.readline
n = int(input())
al, bl, cl, dl = [], [], [], []
for i in range(n):
    a, b, c, d = map(int, input().split())
    al.append(a)
    bl.append(b)
    cl.append(c)
    dl.append(d)

sab, scd = {}, {}
for a in al:
    for b in bl:
        if sab.get(a+b):
            sab[a+b] += 1
        else:
            sab[a+b] = 1

res = 0
for c in cl:
    for d in dl:
        res += sab.get(-c-d, 0)

print(res)