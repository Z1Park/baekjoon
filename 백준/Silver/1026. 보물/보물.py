import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
print(sum([a * b for (a, b) in zip(sorted(A), sorted(B, reverse=True))]))