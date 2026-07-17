class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();

        int currentRank = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, currentRank);
                currentRank++;
            }
        }

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = rank.get(arr[i]);
        }
        
        return answer;
    }
}