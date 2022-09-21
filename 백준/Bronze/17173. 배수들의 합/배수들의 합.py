n, m = map(int, input().split())
lst = [0]*n
nums = list(map(int, input().split()))

for i in nums:
    idx = 1
    while (idx * i <= n):
        lst[i * idx - 1] = 1
        idx += 1

s = 0
for i in range(n):
    if lst[i] == 1:
        s += i + 1
print(s)