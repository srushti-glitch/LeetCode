class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct=Integer.MIN_VALUE;;
       for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
       

             int product=(nums[i]-1)*(nums[j]-1);
            maxproduct = Math.max(maxproduct, product);
        }
    }
    return maxproduct;

    }
}