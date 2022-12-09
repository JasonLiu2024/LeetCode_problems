class Solution {
    public boolean isValid(String s) {
        int len = s.length(); char read; char prev;
        Stack<Character> check = new Stack<Character>();
        for(int i = 0; i < len; i++){
            read = s.charAt(i);
            if(check.isEmpty() == true){
                check.push(read);
            }else{
                prev = check.peek();
            if(prev == '(' && read == ')'){
                check.pop();
            }else if(prev == '[' && read == ']'){
                check.pop();
            }else if(prev == '{' && read == '}'){
                check.pop();
            }else{
                check.push(read);
            }
            }                
        }
        if(check.isEmpty() == true){
            return true;
        }else{
            return false;
        }
    }
}
