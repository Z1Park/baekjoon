from itertools import combinations

l, c = map(int, input().split())
lst = list(map(str, input().split()))
a = []
b = []
for alp in lst:
    if alp in ['a', 'e', 'i', 'o', 'u']:
        a.append(alp)
    else:
        b.append(alp)
answer = []
for i in range(1, len(a)+1):
    n = l - i
    if n < 2:
        break
    tmpa = list(combinations(a, i))
    tmpb = list(combinations(b, n))
    for ta in tmpa:
        for tb in tmpb:
            answer.append(''.join(sorted(list(ta+tb))))
answer.sort()
for i in answer:
    print(i)