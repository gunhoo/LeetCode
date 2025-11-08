class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 1. sort the products O(NlogN)
        // 2. iterate i = 1 to searchWord.length() O(k)
        //      - find searhWord.substring(0, i) in products array
        //          - iterate j = 0 to products.length to find the products that starts with searchWord.substring(0, i); O(N)
        //              - if found, add it the answer array
        //              - if the size of the answer array == 3 break for(j) loop
        List<List<String>> list = new ArrayList<>();
        Arrays.sort(products); // O(NlogN) N: length of the products, K: length of searchWord
        for(int i=1; i<=searchWord.length(); i++){ // O(K)
            String current = searchWord.substring(0, i);
            List<String> currentSuggestion = new ArrayList<>();
            for(int j=0; j<products.length; j++){ // O(N)
                if(products[j].substring(0, Math.min(products[j].length(), current.length())).equals(current)){
                    currentSuggestion.add(products[j]);
                }
                if(currentSuggestion.size() == 3) break;
            }
            list.add(currentSuggestion);
        } // O(NK)
        return list;
    }
}