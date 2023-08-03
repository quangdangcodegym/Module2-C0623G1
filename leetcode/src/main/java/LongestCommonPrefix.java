public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i)){

                }
            }

        }
        return str;

    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String [] arr  = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));;



    }
}
