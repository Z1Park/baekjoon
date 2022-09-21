import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
lst.sort()
count = 0
for i in range(1, n+1):
    count += sum(lst[:i])
print(count)