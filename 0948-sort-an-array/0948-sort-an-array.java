class Solution {
    private void merge(int[] nums, int left, int mid, int right, int[] tmpArr){
        int start1 = left;
        int start2 = mid+1;
        int n1 = mid-left+1;
        int n2 = right-mid;

        for(int i=0; i<n1; i++){
            tmpArr[start1+i] = nums[start1+i];
        }
        for(int i=0; i<n2; i++){
            tmpArr[start2+i] = nums[start2+i];
        }

        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(tmpArr[start1+i]<=tmpArr[start2+j]){
                nums[k] = tmpArr[start1+i++];
            } else {
                nums[k] = tmpArr[start2+j++];
            }
            k++;
        }

        while(i<n1){
            nums[k++] = tmpArr[start1+i++];
        }
        while(j<n2){
            nums[k++] = tmpArr[start2+j++];
        }
    }

    private void mergeSort(int[] nums, int left, int right, int[] tmpArr){
        if(left>=right) return;
        int mid = (left+right)/2;
        mergeSort(nums, left, mid, tmpArr);
        mergeSort(nums, mid+1, right, tmpArr);
        merge(nums, left, mid, right, tmpArr);
    }

    public int[] sortArray(int[] nums) {
        int[] tmpArr = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, tmpArr);
        return nums;
    }
}