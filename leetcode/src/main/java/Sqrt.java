public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                // Nếu mid^2 <= x, thì cập nhật result và tìm căn bậc hai lớn hơn
                result = mid;
                left = mid + 1;
            } else {
                // Nếu mid^2 > x, tiếp tục tìm căn bậc hai nhỏ hơn
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8));
    }
}
