class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
   
    private List<Integer> currentSubset = new ArrayList<>();
    
    private int[] nums;

    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        this.nums = nums;
       
        backtrack(0);
        return result;
    }

    
    private void backtrack(int index) {
        
        if (index >= nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
      
        
        currentSubset.add(nums[index]);
        backtrack(index + 1);
        int removedElement = currentSubset.remove(currentSubset.size() - 1);
      
        
        while (index + 1 < nums.length && nums[index + 1] == removedElement) {
            index++;
        }
      
        
        backtrack(index + 1);
    }
}