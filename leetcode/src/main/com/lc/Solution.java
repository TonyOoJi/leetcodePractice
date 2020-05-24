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
     * 198 打家劫舍
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

    /**
     * 22 括号生成
     * @param n
     * @return
     */
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

    /**
     * 3 无重复字符的最长子串
     * @param s
     * @return
     */
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

    /**
     * 4 寻找两个正序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0D;
        int len1 = nums1.length,len2 = nums2.length, len = len1+len2;
        int[] nums = new int[len];
        int pointer1 = 0, pointer2 = 0;
        for (int i = 0; i < len; i++) {
            if (pointer1 >= len1) {
                for (int j = pointer2; j < len2; j++) {
                    nums[i] = nums2[j];
                    i++;
                }
                break;
            }
            if (pointer2 >= len2) {
                for (int j = pointer1; j < len1; j++) {
                    nums[i] = nums1[j];
                    i++;
                }
                break;
            }
            if (nums1[pointer1] < nums2[pointer2]) {
                nums[i] = nums1[pointer1];
                pointer1 ++;
            } else {
                nums[i] = nums2[pointer2];
                pointer2 ++;
            }
        }
        if (len % 2 == 0) {
            median = ((double) (nums[len/2 - 1] + nums[len/2]))/2;
        } else {
            median = nums[len/2];
        }
        return median;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double median = 0D;
        int len1 = nums1.length,len2 = nums2.length, len = (len1+len2)/2 + 1, reaLen = len1 + len2;
        int[] nums = new int[len];
        int pointer1 = 0, pointer2 = 0;
        for (int i = 0; i < len; i++) {
            if (pointer1 >= len1) {
                for (int j = pointer2; j < len2 && i < len; j++) {
                    nums[i] = nums2[j];
                    i++;
                }
                break;
            }
            if (pointer2 >= len2) {
                for (int j = pointer1; j < len1 && i < len; j++) {
                    nums[i] = nums1[j];
                    i++;
                }
                break;
            }
            if (nums1[pointer1] < nums2[pointer2]) {
                nums[i] = nums1[pointer1];
                pointer1 ++;
            } else {
                nums[i] = nums2[pointer2];
                pointer2 ++;
            }
        }
        if (reaLen % 2 == 0) {
            median = ((double) (nums[len - 1] + nums[len - 2]))/2;
        } else {
            median = nums[len - 1];
        }
        return median;
    }

    /**
     * 5 最长回文子串 动归DP
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 边界 长度为1时 和 2 时，为1时 判断两侧， 为2时判断本身及两侧
        int p1 = 1, p2 = 2;
        String longestStr = "";
        char[] chars = s.toCharArray();
//        if (s.length() == 1) {
//            longestStr = s.substring(0,1);
//        } else if (s.length() == 2) {
//            if (chars[0] == chars [1])
//                longestStr = s.substring(0, 2);
//            else
//                longestStr = s.substring(0,1);
//        }
        if (s.length() > 0) {
            longestStr = String.valueOf(chars[0]);
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            int border = Math.min(len - i - 1, i);
            // 中心为1
            for (int j = 1; j <= border; j++) {
                if (chars[i-j] == chars[i+j]) {
                    if (j*2+1 > longestStr.length()) {
                        longestStr = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }

            }
            // 中心为2
            if ((i-1)>= 0 && chars[i] == chars[i-1]) {
                if (longestStr.length() <= 1) {
                    longestStr = s.substring(i-1,i+1);
                }
                border = Math.min(len - i - 1, i - 1);
                for (int j = 1; j <= border; j++) {
                    if (chars[i-j-1] == chars[i+j]) {
                        if (j*2+2 > longestStr.length()) {
                            longestStr = s.substring(i - j - 1, i + j + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("sasddsa"));
    }

}
