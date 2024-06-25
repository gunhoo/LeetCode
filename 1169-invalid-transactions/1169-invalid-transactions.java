class Solution {
    
    class Transaction{
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String transaction){
            String[] s = transaction.split(",");
            this.name = s[0];
            this.time = Integer.parseInt(s[1]);
            this.amount = Integer.parseInt(s[2]);
            this.city = s[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new LinkedList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            if(map.containsKey(t.name)){
                map.get(t.name).add(t);
            }else {
                List<Transaction> list = new ArrayList<>();
                list.add(t);
                map.put(t.name, list);
            }
        }
        for(String transaction : transactions){
            if(isInvalid(new Transaction(transaction), map.get(transaction.split(",")[0]))){
                ans.add(transaction);
            }
        }
        return ans;
    }
    
    private boolean isInvalid(Transaction t, List<Transaction> list){
        if(t.amount > 1000) return true;
        for(Transaction tran : list){
            if( t.name.equals(tran.name) && Math.abs(t.time - tran.time) <= 60 && !t.city.equals(tran.city)){
                return true; // invalid
            }
        }
        return false; 
    }
}