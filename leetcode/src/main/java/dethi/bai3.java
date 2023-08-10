package dethi;

public class bai3 {
    public static void main(String[] args) {
        int[] array = {4, 7, 9, 11, 13, 17, 20};

        int indexToRemove = 2; // Vị trí index muốn xóa (ví dụ: index 2)

        removeElement(array, indexToRemove);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void removeElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            return; // Không thực hiện gì nếu index nằm ngoài khoảng của mảng
        }

        // Dời các phần tử sau index lên một vị trí
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Đặt giá trị cuối cùng là 0
        arr[arr.length - 1] = 0;
    }
}
