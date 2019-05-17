package br.com.coffeeweb.main;

import br.com.coffeeweb.shapes.Square;
import br.com.coffeeweb.shapes.Triangle;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args) {

        int responseMenu;

        do {
            String[] optionsMenu = new String[]{"Circulo", "Quadrado", "Triângulo", "Retângulo"};

            responseMenu = showOptionDialog(null, "Qual forma deseja criar ?", "Formas geométricas",
                    DEFAULT_OPTION, PLAIN_MESSAGE, null, optionsMenu, optionsMenu[0]);

            switch (responseMenu) {
                case 0:

                    double radius = 0;
                    do {
                        try {
                            radius = Float.parseFloat(showInputDialog(null, "Digite o raio :  (cm)", "Circulo", QUESTION_MESSAGE));
                            if (radius <= 0) {
                                showMessageDialog(null, "Digite um número positivo maior que 0!", "Circulo", ERROR_MESSAGE);
                            }
                        } catch (java.lang.NumberFormatException e) {
                            showMessageDialog(null, "Campo obrigatório", "Circulo", ERROR_MESSAGE);
                        } catch (java.lang.NullPointerException e) {
                            break;
                        }
                    } while (radius <= 0);
                    showMessageDialog(null, "Opções :" + radius, "Circulo", INFORMATION_MESSAGE);
                    break;
                case 1:

                    do {

                        boolean sair = false;
                        double side = 0;

                        do {
                            try {
                                side = Float.parseFloat(showInputDialog(null, "Digite um lado do quadrado:  (cm)", "Quadrado", QUESTION_MESSAGE));
                                if (side <= 0) {
                                    showMessageDialog(null, "Digite um número positivo maior que 0!", "Quadrado", ERROR_MESSAGE);
                                }
                            } catch (java.lang.NumberFormatException e) {
                                showMessageDialog(null, "Campo obrigatório", "Quadrado", ERROR_MESSAGE);
                            } catch (java.lang.NullPointerException e) {
                                sair = true;
                                break;
                            }
                        } while (side <= 0);

                        if (!sair) {

                            Square s1 = new Square(side);
                            showMessageDialog(null, s1.toString(), "Quadrado", INFORMATION_MESSAGE);
                        } else {
                            break;
                        }
                    } while (true);

                    break;
                case 2:

                    do {

                        boolean sair = false;
                        double[] sides = new double[3];
                        int i = 0;

                        do {
                            try {
                                sides[i] = Float.parseFloat(showInputDialog(null, "Digite o " + (i + 1) + "° lado do triângulo:  (cm)", "Triângulo", QUESTION_MESSAGE));
                                if (sides[i] <= 0) {
                                    showMessageDialog(null, "Digite um número positivo maior que 0 !", "Triângulo", ERROR_MESSAGE);
                                }
                            } catch (java.lang.NumberFormatException e) {
                                showMessageDialog(null, "Campo obrigatório", "Triângulo", ERROR_MESSAGE);
                            } catch (java.lang.NullPointerException e) {
                                sair = true;
                                break;
                            }
                            if (sides[i] > 0) {
                                i++;
                            }
                        } while (i < sides.length);


                        if (!sair) {

                            Triangle t1 = new Triangle(sides[0], sides[1], sides[2]);

                            if (t1.istTriangle()) {
                                showMessageDialog(null, t1.toString(), "Triângulo", ERROR_MESSAGE);
                            } else {
                                showMessageDialog(null, "Não é um triângulo !", "Triângulo", ERROR_MESSAGE);
                            }
                        } else {
                            break;
                        }
                    } while (true);

                    break;
                case 3:
                    showMessageDialog(null, "Opções :", "Retângulo", INFORMATION_MESSAGE);
                    break;
                default:
                    responseMenu = 4;
                    break;
            }
        } while (responseMenu != 4);
    }
}
