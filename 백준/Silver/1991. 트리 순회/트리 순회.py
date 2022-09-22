import sys
input = sys.stdin.readline

def prefix(root, tree):
    for t in tree:
        if t[0] == root:
            left = t[1]
            right = t[2]
            break
    print(root, end = '')
    if left != '.':
        prefix(left, tree)
    if right != '.':
        prefix(right, tree)

def infix(root, tree):
    for t in tree:
        if t[0] == root:
            left = t[1]
            right = t[2]
            break
    if left != '.':
        infix(left, tree)
    print(root, end = '')
    if right != '.':
        infix(right, tree)

def surfix(root, tree):
    for t in tree:
        if t[0] == root:
            left = t[1]
            right = t[2]
            break
    if left != '.':
        surfix(left, tree)
    if right != '.':
        surfix(right, tree)
    print(root, end = '')

n = int(input())
tree = [list(input().split()) for _ in range(n)]
prefix(tree[0][0], tree)
print()
infix(tree[0][0], tree)
print()
surfix(tree[0][0], tree)