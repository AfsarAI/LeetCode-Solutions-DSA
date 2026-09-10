/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        int sum;
        int cnt;

        Pair(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }
    int ans = 0;
    private Pair solve(TreeNode node){
        if(node == null) return new Pair(0, 0);
        Pair left = solve(node.left);
        Pair right = solve(node.right);
        int sum = node.val + left.sum + right.sum;
        int count = 1 + left.cnt + right.cnt;
        if (node.val == sum / count) ans++;
        return new Pair(sum, count);
    }
    public int averageOfSubtree(TreeNode root) {
        Pair p = solve(root);
        return ans;
    }
}