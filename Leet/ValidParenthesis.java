class Solution {
    private HashMap<Character, Character> bracket;
    public Solution(){
        bracket = new HashMap<Character, Character>();
        bracket.put('}', '{');
        bracket.put(')', '(');
        bracket.put(']', '[');
    }
    
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        
        Stack<Character> bucket = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char item = s.charAt(i);
            if(!bracket.containsKey(item))
                bucket.push(item);
            else{
                char inStack = bucket.isEmpty()?'#':bucket.pop();
                if(inStack != bracket.get(item))
                    return false;
            }
        }
        
        return bucket.isEmpty();
    }
    
    public boolean isValid1(String s) {
        
        if(s.length() == 0)
            return true;
        if(s.length() %2 !=0)
            return false;
        
        char[] chars = s.toCharArray();
        int i = 0;
        
        Stack<Character> bucket = new Stack<>();
        while(i<s.length()){
            char c = chars[i];
            
            switch(c){
                case '{':
                    bucket.push('{');
                    break;
                case '(':
                    bucket.push('(');
                    break;
                case '[':
                    bucket.push('[');
                    break;
                case '}':
                    if(bucket.isEmpty())
                        return false;
                    if(!('{' == bucket.peek()))
                        return false;
                    else
                        bucket.pop();
                    break;
                case ')':
                    if(bucket.isEmpty())
                        return false;
                    if(!('(' == bucket.peek()))
                        return false;
                    else
                        bucket.pop();
                    break;
                case ']':
                    if(bucket.isEmpty())
                        return false;

                    if(!('[' == bucket.peek()))
                        return false;
                    else
                        bucket.pop();
                    break;
                default:
                    return false;
            }
            
            i++;
        }
        
        return bucket.isEmpty();
    }
}
