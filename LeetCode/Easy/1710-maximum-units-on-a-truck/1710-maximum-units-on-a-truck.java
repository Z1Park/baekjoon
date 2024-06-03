class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparing(arr -> -arr[1]));
        int i = 0, n = boxTypes.length, unitCount = 0;
        while (i < n) {
            unitCount += boxTypes[i][0] * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            if (truckSize < 0) {
                unitCount += boxTypes[i][1] * truckSize;
                break;
            }
            i++;
        }
        return unitCount;
    }
}