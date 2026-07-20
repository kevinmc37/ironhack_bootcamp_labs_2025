import classes.videoService.*;
import classes.carInventory.*;
import classes.intList.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal("3865.38537856736");
        System.out.println("Number " + number1 + " is rounded to " + roundToHundredth(number1));
        System.out.println("Number inverted: " + invertNumber(number1) + "\n");

        Car car1 = new Sedan("4859HND", "L497397GS", 490);
        Car car2 = new Truck("9583GHD", "Subaru", "583784W45B", 600, 2500);
        Car car3 = new UtilityVehicle("9583GHD", "Subaru", "583784W45B", 600, false);

        System.out.println(car1.getInfo());
        System.out.println(car2.getInfo());
        System.out.println(car3.getInfo());

        Video video1 = new Movie("Life of Pi", 25347870, 6.7);
        Video video2 = new TvSeries("The Simpsons", 36000, 4500);

        System.out.println(video1.getInfo());
        System.out.println(video2.getInfo());

        intList intArray1 = new intArrayList();
        intList intVector1 = new intVector();

        intArray1.add(4);
        intArray1.add(1);
        intArray1.add(2);
        intArray1.add(3);
        intArray1.add(6);
        intArray1.add(89);
        intArray1.add(0);
        intArray1.add(40);
        intArray1.add(3);
        intArray1.add(23);
        intArray1.add(76);
        intArray1.add(18);

        intArray1.get(0);
        intArray1.get(1);
        intArray1.get(2);
        intArray1.get(3);
        intArray1.get(4);
        intArray1.get(5);
        intArray1.get(6);
        intArray1.get(7);
        intArray1.get(8);
        intArray1.get(9);
        intArray1.get(10);
        intArray1.get(11);
        intArray1.get(12); // Empty index == 0

        intVector1.add(45);
        intVector1.add(34);
        intVector1.add(68);
        intVector1.add(3);
        intVector1.add(57);
        intVector1.add(8);
        intVector1.add(0);
        intVector1.add(0);
        intVector1.add(0);
        intVector1.add(34);
        intVector1.add(28);
        intVector1.add(24);
        intVector1.add(245);
        intVector1.add(247);
        intVector1.add(2);
        intVector1.add(13);
        intVector1.add(-8);
        intVector1.add(6);
        intVector1.add(54);
        intVector1.add(6);
        intVector1.add(16);

        intVector1.get(0);
        intVector1.get(1);
        intVector1.get(2);
        intVector1.get(3);
        intVector1.get(4);
        intVector1.get(5);
        intVector1.get(6);
        intVector1.get(7);
        intVector1.get(8);
        intVector1.get(9);
        intVector1.get(10);
        intVector1.get(11);
        intVector1.get(12);
        intVector1.get(13);
        intVector1.get(14);
        intVector1.get(15);
        intVector1.get(16);
        intVector1.get(17);
        intVector1.get(18);
        intVector1.get(19);
        intVector1.get(20);
        intVector1.get(21); // Last four indexes are empty == 0
        intVector1.get(22);
        intVector1.get(23);
        intVector1.get(24);
    }

    public static double roundToHundredth(BigDecimal number) {
        BigDecimal roundedNumber = number.setScale(2, RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }

    public static double invertNumber(BigDecimal number) {
        BigDecimal roundedNumber = number.setScale(1, RoundingMode.HALF_UP).negate();
        return roundedNumber.doubleValue();
    }


}
