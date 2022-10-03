n = int(input())
strs = [input() for _ in range(n)]
res = []
for s in strs:
    tmp = list(s)
    idx = 0
    while idx < len(tmp):
        if tmp[idx].isnumeric():
            a = ""
            while idx < len(tmp) and tmp[idx].isnumeric():
                a += tmp[idx]
                idx += 1
            res.append(int(a))
        else:
            idx += 1
res.sort()
for r in res:
    print(r)