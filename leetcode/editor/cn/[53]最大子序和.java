//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // 遍历当加上一个新数 比新数字小的时候。说明前面的一串数字之和小于0了，则舍弃前面的 重新计算

        int sum = 0; //和
        int maxSum = nums[0]; //当前最大和

        for (int num : nums) {
            if (sum + num > num) { //加下一个 大于下一个才保留 ，
            //if (sum > 0) { // 表达式右侧移动到左侧减去num后：sum > 0
                sum += num;
            } else {
                sum = num;
            }
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
