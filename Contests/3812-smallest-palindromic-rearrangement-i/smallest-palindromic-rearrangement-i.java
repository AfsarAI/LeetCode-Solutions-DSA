class Solution {
    public String smallestPalindrome(String s) {
        int size = s.length();
        int index = size / 2;
        String mid = "";
        if (size % 2 != 0)
            mid = String.valueOf(s.charAt(index));

        int[] charCount = new int[26];

        for (int i = 0; i < index; i++){
            char c = s.charAt(i);
            charCount[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();

        for (int i = 0; i < 26; i++){
            for (int j = 0; j < charCount[i]; j++) {
                firstHalf.append((char)('a' + i));
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        StringBuilder ans = new StringBuilder();
        ans.append(firstHalf)
        .append(mid)
        .append(secondHalf);

        return ans.toString();
    }
}