class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        while (true) {
            int sum = 0;
            boolean flag = true;
            for (int i = 0; i < gas.length; i++) {
                int index = (i + idx) % gas.length;
                sum += gas[index] - cost[index];
                if (sum < 0) {
                    idx = i + idx +1;
                    flag = false;
                    break;
                }
            }
            if (idx >= gas.length) return -1;
            if (flag) return idx;
        }
    }
}