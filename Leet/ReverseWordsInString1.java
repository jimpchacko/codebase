class Solution {
    public String reverseWords(String s) {
        
        StringBuilder reverse = new StringBuilder();
        int len = s.length();
        int wordEnd = len, wordBegin = len;
        boolean spaceMode = false;
        for(int i=len-1;i>=0;i--){
            
            if(spaceMode){
                if(s.charAt(i) != ' '){
                    if(reverse.length()!=0)
                        reverse.append(" ");
                    wordEnd = i+1;
                    spaceMode = false;
                    if(i==0){
                        reverse.append(String.valueOf(s.charAt(i)));
                    }
                }
            } else{
                if(s.charAt(i) == ' '){
                    wordBegin = i+1;
                    reverse.append(s.substring(wordBegin, wordEnd));
                    spaceMode = true;
                } else if(i==0){
                    reverse.append(s.substring(0, wordEnd));
                }
            }
        }
        
        return reverse.toString();
    }
}
