from sys import stdin


def input():
    return stdin.readline().rstrip()

N, M = map(int, input().split())

doc = {}
for i in range(1, N+1):
    tmp = input().rstrip()
    doc[tmp] = i
    doc[i] = tmp

for i in range(M):
    tmp = input().rstrip()
    if tmp.isdigit():
        print(doc[int(tmp)])
    else:
        print(doc[tmp])