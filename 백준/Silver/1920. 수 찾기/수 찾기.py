n = int(input())
lst = list(sorted(list(map(int, input().split()))))
m = int(input())
check_lst = list(map(int, input().split()))
for cl in check_lst:
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if lst[mid] > cl:
            end = mid-1
        else:
            start = mid+1
    print(1 if cl == lst[end] else 0)