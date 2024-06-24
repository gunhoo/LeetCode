class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=arr.length-1; i>0; i--){
            if(arr[i]-arr[i-1] < min) min = arr[i]-arr[i-1];
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]-arr[i] > min) break;
                if(arr[j]-arr[i] == min) {
                    list.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
        }
        return list;
    }
}