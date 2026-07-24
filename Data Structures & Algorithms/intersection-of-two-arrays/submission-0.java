class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }

        int[] ans = new int[set.size()];
        int i = 0;

        for (int num : set) {
            ans[i++] = num;
        }

        return ans;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}