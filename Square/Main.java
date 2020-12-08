import java.util.Scanner;

public class Main {
    public static class Shape {
        private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final int MIN_POINTS = 3;
        private final int MAX_POINTS = ALPHABET.length();

        private final Point[] points;

        public Point[] getPoints() {
            return this.points;
        }

        public Shape(Point... points) {
            checkPoints(points);
            this.points = points;
        }

        private void checkPoints(Point... points) {
            if (points == null) {
                throw new IllegalArgumentException("The shape have not points...");
            } else if (points.length < MIN_POINTS && points.length > MAX_POINTS) {
                throw new IllegalArgumentException(String.format("The shape have points range [%d..%d]...", MIN_POINTS, MAX_POINTS));
            } else {
                for (Point point : points) {
                    if (point == null) {
                        throw new IllegalArgumentException("The point not may be null...");
                    }
                }
            }
        }

        private double[] getSides() {
            double[] sides = new double[this.points.length];
            for (int index = 1; index < this.points.length; index++) {
                sides[index - 1] = this.points[index - 1].distanceTo(this.points[index]);
            }
            sides[sides.length - 1] = this.points[0].distanceTo(this.points[points.length - 1]);
            return sides;
        }

        public double getPerimeter() {
            double perimeter = 0;
            for (double side : getSides()) {
                perimeter += side;
            }
            return perimeter;
        }

        public double getArea() {
            double x = 0.;
            double y = 0.;
            for (int index = 0; index < this.points.length - 1; index++) {
                x += this.points[index].getX() * this.points[index + 1].getY();
                y += this.points[index].getY() * this.points[index + 1].getX();
            }
            return Math.abs((x - y) / 2);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("");
            sb.append("Points:").append("\n");
            for (int index = 0; index < this.points.length; index++) {
                sb.append("   ").append(ALPHABET.charAt(index)).append(": ").append(this.points[index]).append("\n");
            }
            sb.append("\n").append("Sides:").append("\n");
            double[] sides = getSides();
            for (int index = 0; index < sides.length; index++) {
                sb.append("   ");
                if (index < sides.length - 1) {
                    sb.append(ALPHABET.charAt(index)).append(ALPHABET.charAt(index + 1));
                } else {
                    sb.append(ALPHABET.charAt(index)).append(ALPHABET.charAt(0));
                }
                sb.append(": ").append(String.format("%.2f", sides[index])).append("\n");
            }
            sb.append("\n").append("Perimeter: ").append(String.format("%.2f", getPerimeter())).append("\n");
            sb.append("\n").append("Area: ").append(String.format("%.2f", getArea())).append("\n");
            return sb.toString();
        }
    }

    static class Point {
        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point point) {
            double temp = Math.pow(point.getX() - x, 2);
            temp += Math.pow(point.getY() - y, 2);
            return Math.sqrt(temp);
        }

        @Override
        public String toString() {
            return String.format("[%.1f, %.1f]", this.x, this.y);
        }
    }

    static class ShapeTest {
        public static void main(String[] args) {
            Scanner read = new Scanner(System.in);
            System.out.print("Input amount points [N]: ");
            int n = read.nextInt();
            Point[] points = new Point[n];
            for (int count = 0; count < n; count++) {
                System.out.println("Point #" + (count + 1) + ":");
                System.out.print("   Input coordinate X: ");
                double x = read.nextDouble();
                System.out.print("   Input coordinate Y: ");
                double y = read.nextDouble();
                points[count] = new Point(x, y);
            }

            Shape shape = new Shape(points);
            System.out.println("Shape:\n" + shape);
        }
    }
}
