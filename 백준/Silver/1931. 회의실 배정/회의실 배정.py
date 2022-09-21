import sys
input = sys.stdin.readline

n = int(input())
lst = [list(map(int, input().split())) for _ in range(n)]
lst.sort(key= lambda x : (x[1], x[0]))
end = -1
count = 0
idx = 0
while idx < n:
    if lst[idx][0] >= end:
        end = lst[idx][1]
        count += 1
    idx += 1
print(count)