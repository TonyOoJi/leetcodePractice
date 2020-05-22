package com.lc;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName:
 * @ProjectName:
 * @Package: com.lc
 * @Description: note
 * @Author:
 * @date: 2020/4/23
 * @CreateDate: 2020/4/23 10:31
 * @UpdateUser:
 * @UpdateDate: 2020/4/23 10:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 **/
public class Solution {

    /**
     * 打家劫舍
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i += 2) {
            a += nums[i];
            if (i + 1 < nums.length) {
                b += nums[i + 1];
            }
        }
        return Math.max(a, b);
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        int d = 2 * n, l = 2 << (d - 1);
        // 二维数组模拟树
        Node[][] treeArr = new Node[d][l];
        treeArr[0][0] = new Node();
        treeArr[0][0].Parenthesis = "(";
        treeArr[0][0].left = 1;
        treeArr[0][0].unmatching = 1;
        for (int i = 0; i < d - 1; i++) {
            for (int j = 0, len = (int) Math.pow(2, i); j < len; j++) {
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
                ans.add(treeArr[d - 1][i].Parenthesis);
            }
        }
        return ans;
    }

    class Node {
        public String Parenthesis;
        public int left = 0, unmatching = 0;
    }

    public int lengthOfLongestSubstring(String s) {
        int begin = 0, end = 0, len = s.length(), max = 1, maxT = 1;
        if (len == 0) {
            return 0;
        }
        while (end < len - 1) {
            String window = s.substring(begin, end + 1);
            int contain = window.indexOf(s.charAt(end + 1));
            if (contain < 0) {
                end ++;
                maxT ++;
            } else {
                begin =begin + contain + 1;
                end ++;
                maxT = end - begin + 1;
            }
            if (maxT > max) {
                max = maxT;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

}
