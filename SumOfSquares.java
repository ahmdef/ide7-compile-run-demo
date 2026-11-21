public class SumOfSquares {
    public static void main(String[] args) {
        int sum = 0;
        for (int n = 1; n <= 5; n++) {
            sum += n * n;
        }
        System.out.println("Sum of squares (1 to 5): " + sum);
    }
}
