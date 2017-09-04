class Solution {
    //During travel the whoe input string, use a stack to keep track of the unclosed left parentheses. If any new coming right parentheses doesn't match the top element in the left-parentheses, return false.
    //Return true only when the stack is empty at the end of checking.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                else{
                    if (s.charAt(i) == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                    else if(s.charAt(i) == '}'){
                        if (stack.peek() == '{'){
                            stack.pop();
                        }
                        else
                            return false;
                    }
                    else{
                        if (stack.peek() == '['){
                            stack.pop();
                        }
                        else
                            return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}