package br.com.coffeeweb.shapes;

import java.text.DecimalFormat;

public class Square {

    private double sides;

    public Square(double sides) {
        this.sides = sides;
    }

    private double getSide(){
        return sides;
    }

    private double getPerimeter(){
        return sides*4;
    }

    private double getArea() {
        return Math.pow(sides, 2);
    }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("0.00");

        return "Quadrado\n" +
                "\nLados : " + df.format(getSide()) + "cm" +
                "\nPerimetro : " + df.format(getPerimeter()) + "cm" +
                "\nÁrea : " + df.format(getArea()) + "cm²" +
                "";
    }
}
