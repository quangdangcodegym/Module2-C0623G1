package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 1213;

        System.out.println(palindromeNumber.isPalindrome(x));
    }
    public  boolean isPalindrome(int x) {
        // x: 121
        String strX = String.valueOf(x);
        int left = 0;
        int right = strX.length()-1;

        while (left <= right) {
            if (strX.charAt(left) != strX.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
