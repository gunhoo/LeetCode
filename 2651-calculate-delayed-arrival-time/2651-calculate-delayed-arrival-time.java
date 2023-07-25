class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return arrivalTime + delayedTime >= 24 ? -24 + arrivalTime + delayedTime : delayedTime + arrivalTime;
    }
}