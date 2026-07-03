class Solution {
    public boolean checkPerfectNumber(int num) {

        if (num <= 1) {
            return false;
        }

        int sum = 1;   // 1 is always a divisor
        int original = num;

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                sum = sum + i;

                if (i != num / i) {
                    sum = sum + (num / i);
                }
            }
        }

        if (sum == original) {
            return true;
        }

        return false;
    }
}