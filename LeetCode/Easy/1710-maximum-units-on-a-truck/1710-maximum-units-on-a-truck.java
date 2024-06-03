class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] boxes = new int[1001];
        for (int[] box : boxTypes)
            boxes[box[1]] += box[0];
        int unitCount = 0;
        for (int i = 1000; truckSize > 0 && i >= 0; i--) {
            if (truckSize < boxes[i]) boxes[i] = truckSize;
            truckSize -= boxes[i];
            unitCount += i * boxes[i];
        }
        return unitCount;
    }
}