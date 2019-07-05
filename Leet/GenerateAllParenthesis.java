class Solution {
    public List<String> generateParenthesis(int n) {
        
        if(n==0)
            return new ArrayList<String>();
        
        String open = "(", closed = ")";
        int ocount = n, ccount = n;
        
        List<String> results = new ArrayList<>();
        genParenthesis(results, "", n, 0);
        return results;
    }
    
    private void genParenthesis(List<String> results, String pattern, int openAvailable, int unClosed){
        if(openAvailable==0){
            if(unClosed>0)
                genParenthesis(results, pattern+")", 0, unClosed-1);
            else
                results.add(pattern);            
        } else if(openAvailable>0){
            genParenthesis(results, pattern+"(", openAvailable-1, unClosed+1);
            if(unClosed>0)
                genParenthesis(results, pattern+")", openAvailable, unClosed-1);
        }        
    }
    /*
    private List<String> generateStrings(int open, int closed){
        
        List<String> brackets = new ArrayList<>();
        if(open==1 && closed==1){
            brackets.add("()");
            return brackets;
        }
        
        List<String> subStrings = generateStrings(open-1, closed-1);
        for(String sub:subStrings){
            brackets.add("("+sub+")");
            brackets.add("()"+sub);
            brackets.add(sub+"()");
        }
        
        return brackets;
    }*/

}
