public class CustomUtils {
    public static double pythagoras(double a, double b){
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static boolean checkCircleOverlap(int x2, int x1, int y2, int y1){
        int centerLenght = (int) CustomUtils.pythagoras(x2 - x1, y2 - y1);

        // checking the overlap
        return centerLenght < 50 ? true : false;
    }
}
