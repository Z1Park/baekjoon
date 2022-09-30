from itertools import combinations
while True:
    tmp = list(map(int, input().split()))
    if tmp[0] == 0:
        break
    for i in combinations(tmp[1:], 6):
        print(*i)
    print()