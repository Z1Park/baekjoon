class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        
        int len = processorTime.size(), result = Integer.MIN_VALUE;
        for (int i = 0, j = tasks.size()-1; i < len; i++, j -= 4)
            result = Math.max(result, processorTime.get(i) + tasks.get(j));
        return result;
    }
}