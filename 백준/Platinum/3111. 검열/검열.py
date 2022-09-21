import sys
input = sys.stdin.readline

A = list(input())
A = A[:-1]
rA = list(reversed(A))
T = input()
T = T[:-1]
la = len(A)
lt = len(T)
flag = 0
left = []
right = []
l_idx = 0
r_idx = lt - 1
while (l_idx <= r_idx):
    if flag == 0:
        left.append(T[l_idx])
        l_idx += 1
        tmp = left[-la:]
        if left[-la:] == A:
            left[-la:] = []
            flag = 1
    else:
        right.append(T[r_idx])
        r_idx -= 1
        if right[-la:] == rA:
            right[-la:] = []
            flag = 0
while right:
    left.append(right.pop())
    if left[-la:] == A:
        left[-la:] = []
print(''.join(left))
