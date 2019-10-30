class PartialLongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.isEmpty())
            return "";
        if(s.length() == 1)
            return s;
        
        String reverse = reverse(s);
        String longPal = findLCS(s, reverse);
        return longPal;
    }
    
    public String findLCS(String a, String b){
        int[][] distance = new int[a.length()][b.length()];
        int[] index = new int[]{0,0};
        int max = 0;
        
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i==0 || j==0){
                        distance[i][j] = 1;
                    } else{
                        distance[i][j] = distance[i-1][j-1] + 1;
                    }
                    if(max < distance[i][j]){
                        max = distance[i][j];
                        index[0] = i;
                        index[1] = j;
                    }
                    
                } else{
                    distance[i][j] = 0;
                }
            }
        }
        
        String lcs = findString(distance, a, b, index);
        return lcs;
    }
    
    public String findString(int[][] dist, String a, String b, int[] index){
        int i=index[0], j=index[1];
        // for(int ind=0;ind<dist.length;ind++)
            System.out.println(Arrays.toString(index));
        StringBuilder result = new StringBuilder();
        while(i>-1 && j>-1 && dist[i][j]!=0){
            result.append(a.charAt(i));
            i--;j--;
        }
        
        return reverse(result.toString());
    }
    
    public String reverse(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i=0;i<len/2;i++){
            swap(chars, i, len-1-i);
        }
        
        return String.valueOf(chars);
    }
    
    private void swap(char[] array, int s, int d){
        char c = array[s];
        array[s] = array[d];
        array[d] = c;
    }
}