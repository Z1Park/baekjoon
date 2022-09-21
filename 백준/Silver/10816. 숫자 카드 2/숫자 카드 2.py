n = input()
nums = list(map(int, input().split()))
m = input()
cl = list(map(int, input().split()))

dic = {}
for num in nums:
    if num in dic:
        dic[num] = dic[num]+1
    else:
        dic[num] = 1

for c in cl:
    if c not in dic:
        print(0, end = ' ')
    else:
        print(dic[c], end = ' ')