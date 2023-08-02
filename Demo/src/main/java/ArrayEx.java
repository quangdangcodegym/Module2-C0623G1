public class ArrayEx {

    public static void main(String[] args) {
        /**
        // let arr = [2,3,6,8]

        int[] arr = new int[5];
        int length = arr.length;


        String[] names = new String[10];

        for (int i = 0; i < length; i++) {
            names[i] = "Item " + i;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(names[i]);
        }



        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * (100 - 1 + 1) + 1);
        }

        int total = 0;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] % 2 == 0){
                total += arr[i];
            }
        }

        printArray(arr);
        System.out.println("Total: " + total);

         int [] arr = {2,3,6,8,9,4};
         System.out.println("ARRAY: " + toString(arr));
         System.out.println(getTotalPerfectSquare1(arr));

         int a = 2;
         int b = 5;
         swap(a, b);

         System.out.println("Giá trị a: " + a);
         System.out.println("Giá trị b: " + b);


         int [] arr = {2,5};
         swapArray(arr);

         **/




    }
    public static void swapArray(int [] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


    public static void hello(int number){
        for(int i=0;i<number;i++){
            System.out.println(i);
        }
    }
    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static String toString(int [] arr1){
//        [2,3,6,8]
        String str = "[";
        for (int i = 0; i < arr1.length; i++) {
            if(i == arr1.length - 1){
                str += arr1[i] + "]";
            }else{
                str += arr1[i] + ",";
            }
        }
        return str;
    }


    public static float getTotalPerfectSquare(int [] arr){
        int total = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(Math.sqrt(arr[i]) == (int) Math.sqrt(arr[i])){
                total += arr[i];
                count++;
            }
        }
        return total / count;
    }
    //int [] arr = {6,8,9,4};
    public static float getTotalPerfectSquare1(int [] arr){
        int total = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(isPerfectSquare(arr[i])){
                total += arr[i];
                count++;
            }

        }
        return (float) total / count;
    }

    public static boolean isPerfectSquare(int number){
        boolean isPerfect = false;
        for(int j = 1;j<number;j++){
            if(j*j == number){
                isPerfect = true;
                break;
            }
            if(j*j > number){
                isPerfect = false;
                break;
            }
        }
        return isPerfect;
    }
    public static boolean isPerfectSquare1(int number){
        for(int j = 1;j<number;j++){
            if(j*j == number){
                return true;
            }
            if(j*j > number){
                return false;
            }
        }
        return false;
    }

}
