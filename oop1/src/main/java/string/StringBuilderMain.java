package string;

public class StringBuilderMain {
    public static void main(String[] args) {
        String s1 = "Hello C06";                    // Không sửa được

        s1.charAt(3);

        StringBuilder s2 = new StringBuilder("Hello C06");          // Sửa đổi được
        s2.append(" đang học ở Codegym");
        s2.charAt(3);

    }
}
