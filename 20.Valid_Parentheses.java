/*这道题的难度是easy，但是还是有两个重要的地方我没有考虑到
 1. 如果输入的都是正括号，就不会有switch里的判断，所以在循环结束后要确定栈是否为空
 2. 如果输入的都是反括号，栈里就不会有元素，pop函数会出错，所以在pop前要先判断栈是否为空，如果为空直接返回false
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                parentheses.push(s.charAt(i));
            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(parentheses.empty())
                    return false;
                char open_paren = parentheses.pop();
                switch (s.charAt(i)){
                    case ')':
                        if(open_paren != '(')
                            return false;
                        break;
                    case '}':
                        if(open_paren != '{')
                            return false;
                        break;
                    case ']':
                        if(open_paren != '[')
                            return false;
                        break;
                }
            }
        }
        if(parentheses.empty())
            return true;
        else
            return false;
    }
}
