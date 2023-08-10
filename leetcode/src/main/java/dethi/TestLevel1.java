package dethi;

public class TestLevel1 {
    public static void main(String[] args) {
        /**
         Bài 1: Viết hàm xóa các số nguyên tố trong mảng
         int[] arr = {3, 2, 4, 6, 7};
         public static int[] removePrimesFromArray(int[] arr)

         TEST CASE:
         int[] arr = {3, 2, 4, 6, 7};
         Pass: int [] result = {4,6};


         Bài 2: Đưa các số nguyên tố về đầu mảng
         public static void movePrimesToFront(int[] arr)

         TEST CASE:
         int[] array = {4, 7, 9, 11, 12, 13, 17, 20};
         Pass: arr = {7, 11, 13, 17, 4, 9, 12, 20};

         Bài 3: Xóa một phần tử trong mảng theo vị trí index, độ dài mảng vẫn giữ nguyên các giá trị sau index sẽ được dời lên
         vị trí cuối cùng sẽ có giá trị là 0

         TEST CASE 1:
         int[] array = {4, 7, 9, 11, 12, 13};
         index = 2 (Ở vị trí 2 có giá trị là 9)
         Pass: array = { 4, 7, 11, 12, 13, 0}

         TEST CASE2:
         int[] array = {4, 7, 9, 11, 12, 0};
         index = 3 (ở vị trí 3 có giá trị là 11)
         Pass: array = { 4, 7, 9, 12, 13, 0, 0}





         */







    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
