import java.util.Random;

public class Solution478 {
    double r;
    double x;
    double y;

    public Solution478(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        while (true) {
            double nx = 2 * r * random.nextDouble() - r;
            double ny = 2 * r * random.nextDouble() - r;
            if (nx * nx + ny * ny <= r * r) {
                return new double[] { nx + x, ny + y };
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */