import sys
input = sys.stdin.readline

n,t  = int(input()), int(input())
lst = [0] * n
conn = []
for i in range(t):
    a, b = map(int, input().split())
    conn.append([a, b])
    conn.append([b, a])

def infect(idx):
    global lst, conn
    lst[idx-1] = 1
    for c in conn:
        if c[0] == idx and lst[c[1] - 1] != 1:
            infect(c[1])

infect(1)
lst[0] = 0
print(sum(lst))