import java.util.*;

public class Node implements Comparable<Node>{
    public int row, numbers;

    public Node(int row, int numbers){
        this.row = row;
        this.numbers = numbers;
    }    

    @Override
    public int compareTo(Node o1){
        if(this.numbers == o1.numbers) return this.row - o1.row;
        return this.numbers - o1.numbers;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0 ; i < mat.length ; i++){
            int numOfOne = 0;
            for(int j = 0 ; j < mat[i].length; j++){
                if(mat[i][j] == 1) numOfOne++;
                else break;
            }
            list.add(new Node(i, numOfOne));
        }
        Collections.sort(list);
        
        int[] answer = new int[k];
        for(int i =0 ;i < k ;i++){
            answer[i] = list.get(i).row;
        }
        return answer;
    }
}