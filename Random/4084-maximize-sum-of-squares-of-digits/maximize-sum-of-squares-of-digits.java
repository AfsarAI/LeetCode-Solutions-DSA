class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        while(num > 0 && sum > 0){
            if(sum >= 9){
                ans.append('9');
                sum -= 9;
            }else{
                ans.append((char) (sum + '0'));
                sum -= sum;
            }
            num--;
        }
        if(sum > 0) return "";
        if(num == 0) return ans.toString();
        String s = "0".repeat(num);
        ans.append(s);
        return ans.toString();
    }
}