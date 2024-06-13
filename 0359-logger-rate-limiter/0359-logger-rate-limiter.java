class Logger {
    
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int t = map.get(message);
            if(timestamp < t) return false;
            map.put(message, timestamp+10);
            System.out.println(map.entrySet());
            return true;
        } else {
            map.put(message, timestamp+10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */