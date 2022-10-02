lst = list(map(int, input().split()))
f = lst[0] - lst[1]
i = 0
while i < 7:
    if f * (lst[i] - lst[i+1]) < 0:
        break
    i += 1
if i == 7:
    print("ascending" if f < 0 else "descending")
else:
    print("mixed")