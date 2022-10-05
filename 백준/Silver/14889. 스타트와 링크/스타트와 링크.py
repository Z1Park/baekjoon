from itertools import combinations
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
member = [i for i in range(n)]
m = 2000
for comb in combinations(member, n//2):
    team1 = list(comb)
    team2 = list(set(member) - set(comb))
    s = 0
    for i in range(n//2 - 1):
        for j in range(i+1, n//2):
            s += arr[team1[i]][team1[j]] + arr[team1[j]][team1[i]]
            s -= arr[team2[i]][team2[j]] + arr[team2[j]][team2[i]]
    if m > abs(s):
        m = abs(s)
print(m)