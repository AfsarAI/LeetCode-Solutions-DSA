class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litterId[r][c] = bit assigned to this litter cell
        int[][] litterId = new int[m][n];

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        // Find starting position and assign IDs to litter cells
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char cell = classroom[r].charAt(c);

                if (cell == 'S') {
                    startR = r;
                    startC = c;
                } 
                else if (cell == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        // Initially every litter is uncollected.
        // Example: litterCount = 3 -> 111
        int startMask = totalMasks - 1;

        /*
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        /*
         * State:
         * [row, col, remainingEnergy, mask]
         */
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {
            startR,
            startC,
            energy,
            startMask
        });

        visited[startR][startC][energy][startMask] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // No energy means we cannot make another move.
                // If we are on R, energy would already have been reset.
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char nextCell = classroom[nr].charAt(nc);

                    /*
                     * Normally every move costs 1 energy.
                     * But if we enter R, energy is reset to full.
                     */
                    int nextEnergy;

                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    } else {
                        nextEnergy = currEnergy - 1;
                    }

                    int nextMask = mask;

                    // Collect litter
                    if (nextCell == 'L') {
                        int bit = litterId[nr][nc];

                        nextMask &= ~(1 << bit);
                    }

                    // Already visited this exact state
                    if (visited[nr][nc][nextEnergy][nextMask]) {
                        continue;
                    }

                    visited[nr][nc][nextEnergy][nextMask] = true;

                    queue.offer(new int[] {
                        nr,
                        nc,
                        nextEnergy,
                        nextMask
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}