import sys
input = sys.stdin.readline

T = input()
T = T[:-1]
A = list(input())
A = A[:-1]
la = len(A)
lt = len(T)
left = []
idx = 0
while idx < lt:
    left.append(T[idx])
    if left[-la:] == A:
        left[-la:] = []
    idx += 1
if left:
    print(''.join(left))
else:
    print("FRULA")