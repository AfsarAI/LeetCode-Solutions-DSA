// class Solution {
//     public String smallestPalindrome(String s) {
//         int size = s.length();
//         int midIndex = size / 2;
//         String mid = "";
//         if (size % 2 != 0)
//             mid = String.valueOf(s.charAt(midIndex));

//         int[] charCount = new int[26];

//         for (int i = 0; i < midIndex; i++){
//             char c = s.charAt(i);
//             charCount[c - 'a']++;
//         }

//         StringBuilder firstHalf = new StringBuilder();

//         for (int i = 0; i < 26; i++){
//             for (int j = 0; j < charCount[i]; j++) {
//                 firstHalf.append((char)('a' + i));
//             }
//         }

//         StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

//         StringBuilder ans = new StringBuilder();
//         ans.append(firstHalf).append(mid).append(secondHalf);

//         return ans.toString();
//     }
// }

class Solution {
    public String smallestPalindrome(String s) {
        int size = s.length();
        int midIndex = size / 2;
        String mid = "";
        if (size % 2 != 0)
            mid = String.valueOf(s.charAt(midIndex));

        String first = s.substring(0, midIndex);

        char[] arr = first.toCharArray();
        Arrays.sort(arr);

        StringBuilder firstHalf = new StringBuilder(new String(arr));
        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        return firstHalf + mid + secondHalf.toString();
    }
}