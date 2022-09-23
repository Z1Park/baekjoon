import sys
input = sys.stdin.readline

n = int(input())
count = 0
lst = []

def dfs(x):
    global count
    for i in range(len(lst)):
        if abs(lst[i] - x) == len(lst) - i:
            return
    lst.append(x)
    if len(lst) == n:
        count += 1
        lst.pop()
        return
    for i in range(n):
        if i not in lst:
            dfs(i)
    lst.pop()

for i in range(n):
    dfs(i)
print(count)