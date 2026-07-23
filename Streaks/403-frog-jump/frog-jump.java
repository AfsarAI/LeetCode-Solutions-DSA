class Solution {

    public boolean canCross(int[] stones) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(0);

        for (int stone : stones) {

            for (int jump : map.get(stone)) {

                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {

                    if (nextJump <= 0)
                        continue;

                    int nextStone = stone + nextJump;

                    if (map.containsKey(nextStone)) {
                        map.get(nextStone).add(nextJump);
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}