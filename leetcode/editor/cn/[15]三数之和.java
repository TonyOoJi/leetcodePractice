//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2457 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*// 排序，保证后面的大于前面的并且第一个整数也是递增
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        if (nums.length <= 2) {
            return sums;
        }
        Arrays.sort(nums);
        int len = nums.length;
        // 第一个数
        int a1 = nums[0],a2 = nums[1];
        for (int i = 0; i < len - 2; i++) {
            // 相同时跳过
            if (nums[i] == a1 && i != 0) {
                continue;
            }
            a1 = nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                // 相同时跳过
                if (nums[j] == a2 && j != 1) {
                    continue;
                }
                a2 = nums[j];
                for (int k = j + 1; k < len; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> threeSum = new ArrayList<Integer>();
                        threeSum.add(nums[i]);
                        threeSum.add(nums[j]);
                        threeSum.add(nums[k]);
                        sums.add(threeSum);
                        break;
                    }
                }
            }
        }
        return sums;*/
        /*// 排序，保证后面的大于前面的并且第一个整数也是递增
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        if (nums.length <= 2) {
            return sums;
        }
        Arrays.sort(nums);
        int len = nums.length, pointer0 = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < 0 && nums[i+1] >= 0) {
                pointer0 = i + 1;
            }
        }
        if (pointer0 == 0) {
            pointer0 = len/2;
        }
        // 第一个数
        int a1 = nums[0],a2 = nums[1];
        for (int i = 0; i < pointer0; i++) {
            // 相同时跳过
            if (nums[i] == a1 && i != 0) {
                continue;
            }
            a1 = nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                // 相同时跳过
                if (nums[j] == a2 && j != 1) {
                    continue;
                }
                a2 = nums[j];
                int index = pointer0 > j + 1 ? pointer0 : j + 1;
                for (int k = index; k < len; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> threeSum = new ArrayList<Integer>();
                        threeSum.add(nums[i]);
                        threeSum.add(nums[j]);
                        threeSum.add(nums[k]);
                        sums.add(threeSum);
                        break;
                    }
                }
            }
        }
        return sums;*/
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
