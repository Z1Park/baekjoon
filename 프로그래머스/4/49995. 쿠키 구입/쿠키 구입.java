import java.util.*;

class Solution {
    
    private int[] prefix;
    
    
    private int binarySearch(int[] cookie, int start, int end) {
        int s = start, e = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (prefix[mid+1] - prefix[s] < prefix[e+1] - prefix[mid+1])
                start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
    
    public int solution(int[] cookie) {
        prefix = new int[cookie.length + 1];
        for (int i = 0; i < cookie.length; i++)
            prefix[i+1] = prefix[i] + cookie[i];
        
        int size = cookie.length - 1, maxCount = 0;
        for (int l = 0; l < size; l++) {
            for (int r = cookie.length-1; r > l; r--) {
                if (prefix[r+1] - prefix[l] <= maxCount) continue;
                int idx = binarySearch(cookie, l, r);
                int sum = prefix[idx+1] - prefix[l];
                if (sum == prefix[r+1] - prefix[idx+1])
                   maxCount = Math.max(maxCount, sum);
            }
        }
        return maxCount;
    }
}