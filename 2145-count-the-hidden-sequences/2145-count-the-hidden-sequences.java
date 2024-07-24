class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long a = 0, max = 0, min = 0;
        for (int diff: differences) {
            a += diff;
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        return (int)Math.max(0, (upper - lower) - (max - min) + 1);
    }
}