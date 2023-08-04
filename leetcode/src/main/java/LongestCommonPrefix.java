public class LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
    public String longestCommonPrefix(String[] strs) {
        //Input: strs = ["flower","flow","flight"]
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if( i < strs[j].length() && strs[0].charAt(i) != strs[j].charAt(i)){
                    return str;
                }
                if (i == strs[j].length()) {
                    return str;
                }
            }
            str += strs[0].charAt(i);

        }
        return str;

    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String [] arr  = {"ab", "a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));;



    }
}
