class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
//         for(int i=0; i<pushed.length; i++){
//             if(stack.isEmpty()) {
//                 if(pushed[i] == popped[idx]){
//                     idx++; // 비었는데 바로 pop 해야하면, push 안하고 바로 idx 만 옮겨
//                 } else {
//                     stack.push(pushed[i]); // 비었는데 바로 pop 하는거 아니면 push 해
//                 }
//             } else { // 비어있지 않았을 때
//                 if(pushed[i] == popped[idx]) { // 다음에 넣어야하는게 바로 빼야하는거면
//                     idx++; // push 안하고 idx만 옮겨
//                     continue;
//                 } else if(stack.peek() == popped[idx]) { // 스택맨 위에 있는게 pop 해야하는거면 
//                     stack.pop();  // pop 먼저하고
//                     stack.push(pushed[i]); // push 하고
//                     idx++; // idx 옮기고
//                 } else  { // 스택에 그냥 쌓아야하는거면
//                     stack.push(pushed[i]); // 그냥 push 만해
//                 }
//             }
//         }
        
//         return stack.isEmpty() && idx == popped.length-1;
//     }
        
        for(int i=0; i<pushed.length; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}