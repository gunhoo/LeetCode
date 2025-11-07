class Solution {
    public int leastInterval(char[] tasks, int n) {
	PriorityQueue<Frequency> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
	Map<Character, Integer> map = new HashMap<>();
	for(char c : tasks){
	    map.put(c, map.getOrDefault(c, 0)+1);
	}
	for(Map.Entry<Character, Integer> entry : map.entrySet()){
	    pq.add(new Frequency(entry.getKey(), entry.getValue()));
	}
	int answer = 0;

	while(!pq.isEmpty()){
	    Queue<Frequency> q = new LinkedList<>();
	    for(int i=0; i<n+1; i++){
            if(pq.isEmpty() && q.isEmpty()) break;
		    answer += 1;
            if(pq.isEmpty()) continue;
		    Frequency f = pq.poll();
		    f = new Frequency(f.c, f.count-1);
		    if(f.count > 0){
		        q.add(f);
		    }
        }
        while(!q.isEmpty()){
            pq.add(q.poll());
        }
	}
	    
	return answer;
		
	// AAABBC 2 A B _ A
	// A _ _ | A _ _ | A _  => n+1 is the length of cycle, and the first char should be the most frequently used character
	// A B _ | A B _ | A _ => the second char should be the second most frequently used character ...
    }

    class Frequency{
	char c;
	int count;
	public Frequency(char c, int count){
	    this.c = c;
	    this.count = count;
	}
    }
}