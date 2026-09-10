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
        int count;
        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    int ans = 0;
    private Pair solve(TreeNode node){
        if(node == null) return new Pair(0, 0);
        Pair left = solve(node.left);
        Pair right = solve(node.right);
        int sum = node.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;
        if (node.val == sum / count) ans++;
        return new Pair(sum, count);
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
}