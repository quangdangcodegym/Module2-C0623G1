import java.util.Arrays;

public class ArrayEx1 {

    public static void main(String[] args) {
        /**
        int[] arr = {1,4,15, 15,7};
//        reverse(arr);
        System.out.println(findSecondeMax1(arr));
        System.out.println(Arrays.toString(arr));

         //        Tính tổng các giá trị lớn hơn giá trị đứng liền trước nó trong mảng 1 chiều các số thực

         float [] arr = {5.0f, 2.4f, 7.0f, 8.0f, 0.4f};
         System.out.println(getTotalFloatAhead(arr));


         //Hãy liệt kê các số trong mảng 1 chiều các số thực thuộc đoạn [x, y] cho trước
         float [] arr = {5.0f, 2.4f, 7.0f, 8.0f, 0.4f};
         // (arr, 3.0, 5.0)


         //Kiểm tra mảng có tăng dần hay không
         int[] arr = {2,2,2,5};
         boolean flag = true;
         int count = 0;
         for(int i=0;i<arr.length-1;i++){
             if (arr[i] > arr[i+1]){
             flag=false;
             break;
             }else if(arr[i] == arr[i+1]){
             count++;
         }
         }
         if(flag && count != arr.length-1){
            System.out.println("Mang tang dan");
         }else if(!flag || count == arr.length-1){
            System.out.println("Mang khong tang dan dan");
         }
         **/

        int[] arr_a = {3,2,7,4,6,3};
        int [][] arr2 = {
                        {3,2,1,0},
                        {5,3,2,1},
                        {3,5,5,2},
                        {1,1,7,5}
                    };


    }

    public static float getTotalFloatAhead(float [] arr){
        float sum = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] > arr[i]) {
                sum += arr[i+1];
            }

        }
        return sum;

    }
    public static void reverse(int[] numbers){
        for (int i = 0; i < numbers.length/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length-1-i] = temp;
        }
    }

//    public static int findSecondMax (int[] num){
//        //{15,1,7,4};
//        int max = num[0];
//        int secondMax = num[1];
//
//        boolean flag = false;
//        for (int i = 1; i < num.length ; i++) {
//            if (num[i] > max && flag == ){
//                secondMax = max;
//                max = num[i];
//            } else if (num[i] > secondMax && num[i] < max){
//                secondMax = num[i];
//            }
//
//        }
//        return secondMax;
//    }
    public static int findSecondeMax1(int [] arr){
        //int[] arr = {1,4,15, 15,7};
        int maxFirst = arr[0];
        int maxSecond = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxSecond==maxFirst){
                maxSecond=arr[i+1];
            }
            if (arr[i] > maxFirst && maxSecond != maxFirst) {
                maxSecond = maxFirst;
                maxFirst = arr[i];
            } else if (arr[i] > maxSecond && arr[i] < maxFirst && maxSecond != maxFirst) {
                maxSecond = arr[i];
            }
        }
        return maxSecond;
    }

    public static void findMax2(int[]arr){
        int max = arr[0];
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]>max){
                max2 = max;
                max = arr[i];
            }else if(arr[i] > max2 && arr[i] <max){
                max2 = arr[i];
            }
        }
        if(max2 == Integer.MIN_VALUE){
            System.out.println("Không có giá trị lớn thứ 2");
        }
        System.out.println("giá trị lớn thứ 2 là: " + max2);
    }
    public static void showArr_2(int[][] arr){
        System.out.println("[ ");
        for(int i = 0; i< arr.length; i++){
            System.out.print("[");
            for (int j = 0; j<arr[i].length;j++){
                System.out.print(arr[i][j]);
                if(j<arr[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println(" ]");
    }
    public static boolean checkReduceArr(int[][] arr, int colum){
        if(colum >= arr.length || colum< 0)
            return  false;
        for(int j = 0; j<arr[colum].length-1;j++){
            if(arr[j][colum] > arr[j+1][colum]) return false;
        }
        return true;
    }
}
