class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < processorTime.size(); i++)
            result = Math.max(result, processorTime.get(i) + tasks.get(i * 4));
        return result;
    }
}