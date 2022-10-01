from itertools import permutations
n = int(input())
lst = list(map(int, input().split()))
m = 0
for tmp in permutations(lst, len(lst)):
    s = 0
    for j in range(n-1):
        s += abs(tmp[j] - tmp[j+1])
    if m < s:
        m = s
print(m)