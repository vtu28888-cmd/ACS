class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;

        int total = 0;
        int leftSum = 0;

        int[] ans = new int[n];

       
        for (int x : nums) {
            total += x;
        }

    
        for (int i = 0; i < n; i++) {

            //
            int ls = nums[i] * i - leftSum;

           
            int rs = (total - leftSum - nums[i])
                    - (n - i - 1) * nums[i];

            ans[i] = ls + rs;

            leftSum += nums[i];
        }

        return ans;
    }
}