N, M = map(int, input().split())
s = []
for i in range(N):
    s.append(input())

count = 0
for i in range(M):
    tmp = input()
    if tmp in s:
        count += 1

print(count)