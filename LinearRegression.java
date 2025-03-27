public class LinearRegression {
    /**
     * Calculates the slope (m) using the least squares method.
     * @param data 2D array where each row is {x, y}
     * @return slope (m)
     */
    public static double calcM(double[][] data) {
        int n = data.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (double[] point : data) {
            double x = point[0];
            double y = point[1];
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        return (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    }

    /**
     * Calculates the y-intercept (b) using the least squares method.
     * @param data 2D array where each row is {x, y}
     * @return y-intercept (b)
     */
    public static double calcB(double[][] data) {
        int n = data.length;
        double sumX = 0, sumY = 0;

        for (double[] point : data) {
            sumX += point[0];
            sumY += point[1];
        }

        double m = calcM(data);
        return (sumY - m * sumX) / n;
    }
}
