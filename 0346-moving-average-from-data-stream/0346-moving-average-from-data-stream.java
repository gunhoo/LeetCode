class MovingAverage {
    Deque<Integer> q;
    int size;

    public MovingAverage(int size) {
        this.q = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size() == size){
            q.removeFirst();
        }
        q.addLast(val);
        double sum = 0;
        for(int n : q){
            sum += n;
        }
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */