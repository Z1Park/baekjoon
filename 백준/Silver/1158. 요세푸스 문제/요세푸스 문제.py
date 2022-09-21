import sys
input = sys.stdin.readline

n, k = map(int, input().split())
prt = []
lst = [i for i in range(1, n + 1)]

idx = 0
while lst:
    idx += k -1
    if idx >= len(lst):
        idx %= len(lst)
    prt.append(lst.pop(idx))
print("<", end='')
for p in prt:
    if p == prt[-1]:
        print(p, end='')
    else:
        print(p, end=", ")
print(">")