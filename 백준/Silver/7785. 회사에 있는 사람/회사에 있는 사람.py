import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(list(map(str, input().split())))
lst.sort(key= lambda x: x[0], reverse=True)
tmp = lst[0][0]
cnt = 0
for l in lst:
    if l[0] == tmp:
        if l[1] == "enter":
            cnt += 1
        else:
            cnt -= 1
    else:
        if cnt > 0:
            print(tmp)
        tmp = l[0]
        cnt = 1
if cnt > 0:
    print(tmp)