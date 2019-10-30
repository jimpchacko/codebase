class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.isEmpty())
            return "";
        if(s.length() == 1)
            return s;
        
        String pal = findLongestPal(s);
        return pal;
    }
    
    private String findLongestPal(String b){
        int len = b.length();
        int maxLen = 0;
        String longest = "";
        
        for(int i=0;i<len;i++){
            String longestPal = findPal(b, i, i);
            if(longestPal.length() > maxLen){
                longest = longestPal;
                maxLen = longest.length();
            }
            longestPal = findPal(b, i, i+1);
            if(longestPal.length() > maxLen){
                longest = longestPal;
                maxLen = longest.length();
            }
        }
        return longest;
    }
    
    private String findPal(String a, int low, int high){
        
        while(low>-1 && high <a.length() && a.charAt(low)==a.charAt(high)){
            low--;
            high++;
        }
        return a.substring(low+1, high);
    }
}