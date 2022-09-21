import sys
input = sys.stdin.readline

n, m = map(int, input().split())
get = list(map(int, input().split()))
lst = []
for i in range(n):
    lst.append(i + 1)
count = 0
for g in get:
    idx = lst.index(g)
    l = len(lst)
    while (lst[0] != g):
        count += 1
        if (idx > l // 2):
            lst.insert(0, lst.pop())
        else:
            lst.append(lst[0])
            del lst[0]
    del lst[0]
print(count)