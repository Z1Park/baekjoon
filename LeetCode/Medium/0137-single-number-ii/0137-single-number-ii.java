class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else {
                int count = map.get(num);
                if (count < 2) map.put(num, count+1);
                else map.remove(num);
            }
        }
        for (int key : map.keySet())
            return key;
        return -1;
    }
}