public class Tangent {
    static final double PI = 3.14159265358979;
    static final double MinimumCheck = 1E-10;

    public static double calculateTangent(double x) {
        // Reduce x to within -PI to PI
        x = x % PI;

        // If x is close to PI/2 or -PI/2, tangent is undefined
        if (Math.abs(x - PI / 2) < MinimumCheck || Math.abs(x + PI / 2) < MinimumCheck) {
            throw new ArithmeticException("Tangent is undefined for this value.");
        }

        // Calculate sine and cosine of x
        double sinValue = sin(x);
        double cosValue = cos(x);

        // Check if cosine is zero to avoid division by zero
        if (Math.abs(cosValue) < MinimumCheck) {
            throw new ArithmeticException("Tangent is undefined for this value.");
        }

        // Calculate tangent as sine/cosine
        return sinValue / cosValue;
    }

    // Taylor series for sine
    public static double sin(double x) {
        double term = x;
        double sum = x;
        int n = 1;
        while (Math.abs(term) > MinimumCheck) {
            term *= -x * x / (2 * n * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    // Taylor series for cosine
    public static double cos(double x) {
        double term = 1;
        double sum = 1;
        int n = 1;
        while (Math.abs(term) > MinimumCheck) {
            term *= -x * x / (2 * n - 1) / (2 * n);
            sum += term;
            n++;
        }
        return sum;
    }
}
