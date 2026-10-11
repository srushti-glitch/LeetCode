class Solution {

    static String[] arr = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> l = new ArrayList<>();

        if (digits.length() == 0)
            return l;

        comb(0, digits, "", l);

        return l;
    }

    public static void comb(int i, String digits, String ans, List<String> l) {

        if (i == digits.length()) {
            l.add(ans);
            return;
        }

        int idx = digits.charAt(i) - '0';
        String s = arr[idx];

        for (int j = 0; j < s.length(); j++) {
            comb(i + 1, digits, ans + s.charAt(j), l);
        }
    }
}