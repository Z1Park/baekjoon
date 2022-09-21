lst = list(map(int, input().split()))
new = sorted(lst)
if lst == new:
    print("Good")
else:
    print("Bad")