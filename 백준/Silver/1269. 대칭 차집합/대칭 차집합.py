from sys import stdin

n, m = map(int, stdin.readline().split())
a = set(stdin.readline().split())
b = set(stdin.readline().split())
print(len(a-b) + len(b-a))