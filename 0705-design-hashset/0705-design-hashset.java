class MyHashSet {
    
    List<Integer> myHash = new ArrayList<>();
    
    public MyHashSet() {
    }
    
    public void add(int key) {
        for(int i = 0 ; i < myHash.size(); i++){
            if( myHash.get(i) == key ) return;
        }
        myHash.add(key);
    }
    
    public void remove(int key) {
        for(int i = 0 ; i < myHash.size(); i++){
            if( myHash.get(i) == key ) myHash.remove(i);
        }
    }
    
    public boolean contains(int key) {
        for(int k : myHash){
            if(k == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */