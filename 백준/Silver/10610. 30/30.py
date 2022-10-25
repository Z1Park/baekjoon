import sys
input = sys.stdin.readline

lst = list(input())
lst.pop()

s = 0
for l in lst:
    s += int(l)
if s%3 != 0 or '0' not in lst:
    print(-1)
else:
    print(''.join(sorted(lst, reverse=True)))