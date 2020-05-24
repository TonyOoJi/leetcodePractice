//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 排序解法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0D;
        int len1 = nums1.length,len2 = nums2.length, len = (len1+len2)/2 + 1, reaLen = len1 + len2;
        // 半长数组
        int[] nums = new int[len];
        int pointer1 = 0, pointer2 = 0;
        // 合并排序两个数组 排序一半
        for (int i = 0; i < len; i++) {
            // 其中一个数据指向到末尾时 将另一个数组添加进来
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
        // 根据总长度奇偶 取最后一个数或最后两个数平均
        if (reaLen % 2 == 0) {
            median = ((double) (nums[len - 1] + nums[len - 2]))/2;
        } else {
            median = nums[len - 1];
        }
        return median;
    }

    // 递归法
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
