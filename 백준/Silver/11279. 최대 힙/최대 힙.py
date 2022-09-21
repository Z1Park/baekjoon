import sys
import heapq
input = sys.stdin.readline

n = int(input())
h = []
for i in range(n):
    tmp = int(input())
    if tmp != 0:
        heapq.heappush(h, (-tmp, tmp))
    else:
        if len(h) > 0:
            print(heapq.heappop(h)[1])
        else:
            print(0)