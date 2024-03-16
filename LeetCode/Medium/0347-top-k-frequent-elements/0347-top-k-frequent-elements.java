class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) 
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        return freqMap.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .map(e -> e.getKey())
            .mapToInt(Integer::intValue)
            .limit(k).toArray();
    }
}