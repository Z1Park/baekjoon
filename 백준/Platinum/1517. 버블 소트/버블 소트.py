n = int(input())
lst = list(map(int, input().split()))
cnt = 0

def merge_sort(nums, l):
    global cnt
    if l == 1:
        return nums
    a = merge_sort(nums[:l//2], l//2)
    b = merge_sort(nums[l//2:], l-l//2)
    merged = []
    idx1 = idx2 = 0
    while idx1 + idx2 < l:
        if idx1 >= l//2:
            merged += b[idx2:]
            break
        if idx2 >= l-l//2:
            merged += a[idx1:]
            break
        if a[idx1] > b[idx2]:
            merged.append(b[idx2])
            idx2 += 1
            cnt += len(a)-idx1
        else:
            merged.append(a[idx1])
            idx1 += 1
    return merged

lst = merge_sort(lst, n)
print(cnt)