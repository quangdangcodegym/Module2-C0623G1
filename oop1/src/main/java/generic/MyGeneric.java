package generic;

// cơ chế : cho phép

/**
 cơ chế :
            + Có thể định nghĩa lớp hoặc interface theo cách mà có thể hoạt động với các kiểu dử liệu khác nhau
            + cho phép định nghĩa trước kiểu dữ liệu generic (chung chung), sau đó mình có thể truyền kiểu dữ lieu vao nhu là tham số
            + phát hiện sai kiểu dữ liệu tại thời điểm biên dịch
 */
class MyGeneric<T> {
    T obj;

    void add(T obj) {
        this.obj = obj;
    }

    T get() {
        return obj;
    }

    public static <E> E[] printArray(E[] elements) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
        return elements;
    }
    public static <E> E[] printArray(E[] elements, E name) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
        return elements;
    }
    public static void main(String[] args) {
        MyGeneric<String> myGeneric = new MyGeneric<>();


        Integer[] arr = {4, 6, 8};

        String[] arr1 = {"Quang", "Nhat"};
        MyGeneric.printArray(arr1, "Quang");
        Test.printArray1(arr1);

    }
}