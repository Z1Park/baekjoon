class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCount = 0;
        for (int candy : candies)
            if (maxCount < candy)
                maxCount = candy;
        
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies)
            result.add(candy + extraCandies >= maxCount);
        return result;
    }
}