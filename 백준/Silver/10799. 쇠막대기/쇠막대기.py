import sys
input = sys.stdin.readline

s = list(input())
del s[-1]
b_cnt = 0
pi = 0
for i in range(len(s)):
    if s[i] == '(':
        if s[i + 1] == ')':
            pi += b_cnt
        else:
            b_cnt += 1
    else:
        if s[i - 1] == ')':
            pi += 1
            b_cnt -= 1
print(pi)