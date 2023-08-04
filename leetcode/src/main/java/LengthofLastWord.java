public class LengthofLastWord {
    public int lengthOfLastWord1(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String result = "";
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                result = s.substring(i+1, s.length());
                break;
            }
            if (i == 0) {
                result = s.substring(i, s.length());
                break;
            }
        }
        return result.length();

    }

    public static void main(String[] args) {
        LengthofLastWord lengthofLastWord = new LengthofLastWord();

        System.out.println(lengthofLastWord.lengthOfLastWord("a"));
    }
}
