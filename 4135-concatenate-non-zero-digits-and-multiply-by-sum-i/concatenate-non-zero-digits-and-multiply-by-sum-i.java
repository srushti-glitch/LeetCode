class Solution {
    public long sumAndMultiply(int n) {
        int x=0;
        int p=1;
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum=sum+digit;
            if(digit!=0){
              x=x+digit*p;
              p*=10;  
            }
            n/=10;
            

        }
        return 1L * x * sum;
    }
}