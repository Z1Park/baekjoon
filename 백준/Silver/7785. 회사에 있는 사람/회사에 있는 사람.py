import sys
input = lambda : sys.stdin.readline().rstrip()
n = int(input())
hash_dic = dict()
for _ in range(n):
    name, log = map(str, input().split())
    hash_dic[name] = log
res = []
for key in hash_dic:
    if hash_dic[key] == 'enter':
        res.append(key)
for r in reversed(sorted(res)):
    print(r)