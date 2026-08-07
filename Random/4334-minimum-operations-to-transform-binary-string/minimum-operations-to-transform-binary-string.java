class Solution {
    public int minOperations(String s1, String s2) {
        if(s1.equals("1") && s2.equals("0")){
            return -1;
        }

        int n = s1.length();
        char[] s = s1.toCharArray();
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == s2.charAt(i)){
                continue;
            }
            if(s[i] == '0'){
                ans++;
            }else if(i < n-1){
                ans += s[i+1] == '1' ? 1 : 2;
                s[i+1] = '0';
            }else{
                ans += 2;
            }
        }
        return ans;
    }
}