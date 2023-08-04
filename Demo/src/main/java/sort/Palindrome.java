package sort;

public class Palindrome {
    public static boolean isPalindrome(int number) {
        // 1221 => "1221"
        String str = String.valueOf(number);
        return checkPalindrome(str, 0, str.length()-1 );
    }

    private static boolean checkPalindrome(String str, int left, int right) {
        if (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }else{
                return checkPalindrome(str, left + 1, right - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("Doi xung: " + isPalindrome(1221));
    }
}
