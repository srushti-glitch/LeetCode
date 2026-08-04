class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
       int []temp=new int[n];
       for(int i=0;i<n;i++){
        int cnt=0;
        for(int j=0;j<n;j++){
            if(i!=j && nums[j]<nums[i]){
                cnt++;
            }
        }
        temp[i]=cnt;
       } 
       return temp;
    }
}