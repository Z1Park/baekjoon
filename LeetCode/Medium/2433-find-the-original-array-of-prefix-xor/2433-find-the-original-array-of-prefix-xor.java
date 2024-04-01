class Solution {
    public int[] findArray(int[] pref) {
        int[] array = new int[pref.length];
        array[0] = pref[0];
        for (int i = 1; i < pref.length; i++)
            array[i] = pref[i] ^ pref[i-1];
        return array;
    }
}