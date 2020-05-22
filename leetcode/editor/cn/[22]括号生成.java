//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        int d = 2 * n, l = 2 << (d-1);
        // 二维数组模拟树
        Node[][] treeArr = new Node[d][l];
        treeArr[0][0] = new Node();
        treeArr[0][0].Parenthesis = "(";
        treeArr[0][0].left = 1;
        treeArr[0][0].unmatching = 1;
        for (int i = 0; i < d-1; i++) {
            for (int j = 0, len = (int) Math.pow(2,i); j < len; j++) {
                Node parent = treeArr[i][j];
                if (parent != null && parent.Parenthesis != "") {
                    int left = parent.left;
                    int unmatching = parent.unmatching;
                    // 左孩子
                    if (left + 1 <= n) {
                        treeArr[i + 1][j * 2] = new Node();
                        treeArr[i + 1][j * 2].Parenthesis = parent.Parenthesis + "(";
                        treeArr[i + 1][j * 2].left = left + 1;
                        treeArr[i + 1][j * 2].unmatching = unmatching + 1;
                    }
                    // 右孩子 未匹配数>0时添加
                    if (unmatching > 0) {
                        treeArr[i + 1][j * 2 + 1] = new Node();
                        treeArr[i + 1][j * 2 + 1].Parenthesis = parent.Parenthesis + ")";
                        // 加右括号时 未匹配计数减一
                        treeArr[i + 1][j * 2 + 1].left = left;
                        treeArr[i + 1][j * 2 + 1].unmatching = unmatching - 1;
                    }
                }
            }
        }
        for (int i = 0; i < l; i++) {
            Node parent = treeArr[d - 1][i];
            if (parent != null && parent.Parenthesis != "") {
                ans.add(treeArr[d-1][i].Parenthesis);
            }
        }
        return ans;
    }

    class Node {
        public String Parenthesis;
        public int left = 0, unmatching = 0;
    }


    /*public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
