package practice;

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position
// of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // int[] nums = {5,7,7,8,8,10};
        int[] nums = {5, 7, 7, 8, 8, 10};

        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        return search(nums, target, 0, nums.length - 1);

    }

    private static int[] search(int[] nums, int target, int begin, int end) {
        if (nums[begin] == target && target == nums[end]) return new int[]{begin, end};
        if (nums[begin] <= target && target <= nums[end]) {
            int mid = (begin + end) / 2;
            int[] left = search(nums, target, begin, mid);
            int[] right = search(nums, target, mid + 1, end);
            int l, r;
            if (left[0] == -1 || left[1] == -1 || right[0] == -1 || right[1] == -1)
                return new int[]{Math.max(left[0], right[0]), Math.max(left[1], right[1])};
            return new int[]{left[0], right[1]};
        }
        return new int[]{-1, -1};
    }
}
