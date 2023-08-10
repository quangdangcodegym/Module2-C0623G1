package dethi;

public class bai2 {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public static void movePrimesToFront(int[] arr) {


        int[] tempArr = new int[arr.length];
        int newIndex = 0;

        for (int num : arr) {
            if (isPrime(num)) {
                tempArr[newIndex++] = num;
            }
        }

        for (int num : arr) {
            if (!isPrime(num)) {
                tempArr[newIndex++] = num;
            }
        }

        System.arraycopy(tempArr, 0, arr, 0, arr.length);
    }


    public static void movePrimesToFront2(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (!isPrime(arr[i]) && isPrime(arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 9, 11, 12, 13, 17, 20};

        movePrimesToFront(array);

        // cach 2: 7 11 13 17 12 9 4 20
        // cach 1: 7 11 13 17 12 9 4 20

        System.out.print("Mảng sau khi di chuyển số nguyên tố về đầu: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
