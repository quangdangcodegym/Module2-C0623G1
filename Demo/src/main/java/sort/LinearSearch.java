package sort;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,4,5,8,9,12,15};

//        System.out.println(binarySearch(arr, 122));
        System.out.println(binarySearch1(arr, 679, 0, arr.length-1));
    }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(int [] arr, int value){
        int left = 0;               //0
        int right = arr.length-1;   // 6
        while (left <= right) {
            int mid = (left + right)/2;     // 3 => arr[3] = 8
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                right = mid-1;
            }
            if (arr[mid] < value) {
                left = mid+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int [] arr, int value, int left, int right) {
        int mid = (left + right) / 2;
        if (left <= right) {
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, value, left, mid - 1);
            } else {
                return binarySearch(arr, value, mid + 1, right);
            }
        }
        return -1;


    }
    public static int binarySearch1(int [] arr, int value, int left, int right) {
        int mid = (left + right) / 2;
        if (left <= right) {
            if (arr[mid] == value) {
                return mid;
            } else if (arr[left] == value) {
                return left;
            } else if (arr[right] == value) {
                return right;
            } else if (arr[mid] > value) {
                return binarySearch(arr, value, left+1, mid - 1);
            } else {
                return binarySearch(arr, value, mid + 1, right-1);
            }
        }
        return -1;


    }

}
