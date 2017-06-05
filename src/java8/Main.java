package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(6, 6);
        Point point2 = new Point(6, 6);
        Point point3 = new Point(6, 6);
        Point point4 = new Point(6, 6);
        Point point5 = new Point(6, 6);
        Point point6 = new Point(6, 6);
        Point point7 = new Point(6, 6);
        Point point8 = new Point(6, 6);
        Point point9 = new Point(6, 6);
        Point point10 = new Point(6, 6);
        List<Point> pointList = Arrays.asList(
                point1,
                point2,
                point3,
                point4,
                point5,
                point6,
                point7,
                point8,
                point9,
                point10);
        pointList.forEach(point -> System.out.println("x: " + point.getX() + "; " + "y: " + point.getY()));

        Predicate<NewPoint> onlyLesserThanThree = point -> point.getA() < 3 && point.getB() < 3;

        IntStream intStream = pointList.stream()
                .map(point -> new NewPoint(point.getX(), point.getY()))
                .filter(onlyLesserThanThree)
                .distinct()
                .mapToInt(newPoint -> newPoint.getA() + newPoint.getB());
        List<Integer> collectedInts = intStream.boxed().collect(Collectors.toList());
        int sum = collectedInts.stream().reduce(0, getSum());
        System.out.println("The sum is :" + sum);
        int multiply = collectedInts.stream().reduce(1, getProduct());
        System.out.println("Multiply result is :" + multiply);
    }

    private static BinaryOperator<Integer> getSum() {
        return (a, b) -> a + b;
    }

    private static BinaryOperator<Integer> getProduct() {
        return (a, b) -> a * b;
    }
}
