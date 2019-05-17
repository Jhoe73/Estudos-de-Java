package br.com.coffeeweb.shapes;

import java.text.DecimalFormat;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    private String type;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Boolean istTriangle() {
        return ((Math.abs(side2 - side3) < side1) && (side1 < (side2 + side3))) && ((Math.abs(side1 - side3) < side2) && (side2 < (side1 + side3))) && ((Math.abs(side1 - side2) < side3) && (side3 < (side1 + side2)));
    }

    private void calcType() {
        if (side1 == side2 && side2 == side3 && side3 == side1) {
            type = "Triângulo equilátero";
        } else if ((side1 == side2) && (side2 != side3) || (side2 == side3) && (side3 != side1) || (side3 == side1) && (side1 != side2)) {
            type = "Triângulo isósceles";
        } else if (side1 != side2 && side2 != side3 && side3 != side1) {

            int a = (int) side1;
            int b = (int) side2;
            int c = (int) side3;

            int hp = Math.max(a, Math.max(b, c));
            int cm = Math.min(a, Math.min(b, c));
            int cM = a + b + c - hp - cm;

            if (Math.pow(hp, 2) == Math.pow(cm, 2) + Math.pow(cM, 2)) {
                type = "Triângulo escaleno e triângulo retangulo";
            }

            type = "Triângulo escaleno";

        } else {
            type = "";
        }
    }

    private String getType() {
        calcType();
        return type;
    }

    private double getPerimeter(){
        return side1+side2+side3;
    }

    private double getArea() {
        double p = (side1+side2+side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("0.00");

        return "Triangulo\n" +
                "\nTipo : " + getType() +
                "\nPerimetro : " + df.format(getPerimeter()) + "cm" +
                "\nÁrea : " + df.format(getArea()) + "cm²" +
                "";
    }
}
