class Solution {
    public int maximumWidth(int[] planks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> answer = new HashMap<>();
        for (int x : planks)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(freq.entrySet());
        for (Map.Entry<Integer, Integer> e : list)
            answer.put(e.getKey(), e.getValue());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int h = list.get(i).getKey() + list.get(j).getKey();
                int ways;
                if (i == j)
                    ways = list.get(i).getValue() / 2;
                else
                    ways = Math.min(list.get(i).getValue(),
                                    list.get(j).getValue());
                answer.put(h,
                    answer.getOrDefault(h, 0) + ways);
            }
        }
        int ans = 1;
        for (int x : answer.values())
            ans = Math.max(ans, x);
        return ans;
    }
}