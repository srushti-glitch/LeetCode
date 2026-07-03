class Solution {
    public boolean isPerfectSquare(int num) {
       if(num>=0) {
        int sq=(int)Math.sqrt(num);
        return (sq * sq==num);
       }
       return false;
    }
}