import sys
input = lambda : sys.stdin.readline().rstrip()
tc = int(input())

def uptoroot(node):
    while node != parent[node]:
        parent[node] = parent[parent[node]]
        node = parent[node]
    return node

def union(a, b):
    rta = uptoroot(a)
    rtb = uptoroot(b)
    if rta != rtb:
        parent[rtb] = rta
        count[rta] += count[rtb]

for t in range(tc):
    f = int(input())
    parent = dict()
    count = dict()
    for _ in range(f):
        a, b = input().split()
        if not parent.get(a):
            parent[a] = a
            count[a] = 1
        if not parent.get(b):
            parent[b] = b
            count[b] = 1
        union(a, b)
        print(count[uptoroot(a)])