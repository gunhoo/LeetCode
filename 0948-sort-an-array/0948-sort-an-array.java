class Solution {
    private void merge(int[] array, int left, int mid, int right, int[] tmpArray){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int start1 = left;
        int start2 = mid+1;

        for(int i=0; i<n1; i++){
            tmpArray[start1+i] = array[start1+i];
        }
        for(int i=0; i<n2; i++){
            tmpArray[start2+i] = array[start2+i];
        }

        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(tmpArray[start1+i] <= tmpArray[start2+j]){
                array[k] = tmpArray[start1+i];
                i++;
            } else {
                array[k] = tmpArray[start2+j];
                j++;
            }
            k++;
        }
        while(i<n1){
            array[k++] = tmpArray[start1 + i++];
        }
        while(j<n2){
            array[k++] = tmpArray[start2+ j++];
        }

    }

    private void mergeSort(int[] nums, int left, int right, int[] tmpArray){
        if(left >= right) return;
        
        int mid = (left + right) / 2;
        
        mergeSort(nums, left, mid, tmpArray);
        mergeSort(nums, mid+1, right, tmpArray);
        merge(nums, left, mid, right, tmpArray);
    }

    public int[] sortArray(int[] nums) {
        int[] tmpArray = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, tmpArray);
        return nums;
    }
}