class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int curr = 1;
        for (int t : target) {
            int tmp = t - curr;
            if (curr > t) tmp += n;
            for (int i = 0; i < tmp; i++) {
                result.add("Push");
                result.add("Pop");
            }
            result.add("Push");
            curr = t+1;
        }
        return result;
    }
}