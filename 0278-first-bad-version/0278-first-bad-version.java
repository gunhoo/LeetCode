/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Binary Search
        if(n == 1) return 1;
        return findFirstBadVersion(1, n);
    }

    private int findFirstBadVersion(int left, int right){
        int mid = (int)(((long)left + (long)right) / 2);
        if(mid == left ){
            if(isBadVersion(mid)) return mid;
            return right;
        }
        if(isBadVersion(mid)){
            if(isBadVersion(mid-1)) return findFirstBadVersion(left, mid-1);
            return mid;
        }
        return findFirstBadVersion(mid+1, right);
    }
}