package james_trycatch;

public class FinallyMain {
    public static void main(String[] args) {
        System.out.println(thuchienphepchia());
    }

    private static String thuchienphepchia() {

        try {
            System.out.println(5 / 6);
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
        }finally {
            System.out.println("thực hiện finally");
            return "XONG";
        }
//        return "OK";
    }


}
