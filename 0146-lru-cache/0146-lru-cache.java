class LRUCache {
    private Map<Integer, Integer> map;
    private Deque<Integer> stack;
    private int capacity;
    private int lru;

    public LRUCache(int capacity) {
        this.stack = new ArrayDeque<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            stack.remove(key);
            stack.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            stack.remove(key);
            stack.addLast(key);
        } 
        else if(this.map.size() == this.capacity){
            map.remove(stack.pollFirst());
            map.put(key, value);
            stack.addLast(key);
        } else {
            map.put(key, value);
            stack.addLast(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */