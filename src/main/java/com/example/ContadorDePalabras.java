package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * La nueva funcionalidad que se desea implementar en la clase ContadorPalabras
 * consiste en agregar una función que permita contabilizar las palabras de un
 * string que estén separadas por un espacio, la cual toma como input el string
 * y devolverá la cantidad de palabras.
 * Para lograr esto, tenemos que tener un contador inicializado en 0 y una flag
 * inicializada en True, el contador aumenta cuando encuentra una letra y cambia
 * la flag a false, cuando encuentre un espacio este flag cambiara a true y
 * podrá volver a contar una nueva palabra.
 * 
 */
class ContadorDePalabras {

    public int contaPalabras(String frase) {

        int contador = 0;
        boolean flag = true;

        for (int index = 0; index < frase.length(); index++) {

            if (Character.isLetter(frase.charAt(index)) && flag) {
                contador++;
                flag = false;
            } else if (Character.isWhitespace(frase.charAt(index))) {
                flag = true;
            }
        }

        return contador;
    }

    /**
     * 
     * 
     * La función contadorVocales recibe una frase como entrada y devuelve un array
     * de dos enteros. Durante su ejecución, cuenta el número de vocales y
     * consonantes en la frase, y al final retorna estos conteos en el array
     * resultante.
     * 
     */

    public int[] contadorVocales(String frase) {

        int contadorVocales = 0;
        int contadorConsonantes = 0;
        String vocales[] = { "a", "e", "i", "o", "u", "A", "E", "I", "O", "U" };

        for (int index = 0; index < frase.length(); index++) {

            if (Character.isLetter(frase.charAt(index))) {
                if (Arrays.asList(vocales).contains(String.valueOf(frase.charAt(index)))) {
                    contadorVocales++;
                } else {
                    contadorConsonantes++;
                }
            }
        }
        int result[] = { contadorConsonantes, contadorVocales };

        return result;
    }

    public int ejercicioB(String frase, int min) {

        int contadorDePalabras = 0;
        int contadorDeCaracteres = 0;

        // boolean flag = true;

        for (int index = 0; index < frase.length(); index++) {

            if (Character.isLetter(frase.charAt(index)) && contadorDeCaracteres <= min) {

                contadorDeCaracteres++;

                if (contadorDeCaracteres > min) {
                    contadorDePalabras++;
                    // flag = false;
                }

            } else if (Character.isWhitespace(frase.charAt(index))) {
                // flag = true;
                contadorDeCaracteres = 0;
            }
        }

        return contadorDePalabras;
    }

    public String[] obtenerLineas(String archivo) {

        String[] result = null;
        int cantLineas = 0;

        try {

            File a = new File(archivo);
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);

            while (br.readLine() != null) {
                cantLineas++;
            }

            result = new String[cantLineas];

            fr = new FileReader(a);
            br = new BufferedReader(fr);

            String line = "";
            for (int i = 0; i < result.length; i++) {
                line = br.readLine();
                result[i] = line;
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int cantPalabras(String[] lineasArchivo) {

        int result = 0;

        for (int i = 0; i < lineasArchivo.length; i++) {
            result += contaPalabras(lineasArchivo[i]);
        }

        return result;
    }
}

class Principal {
    public static void main(String[] args) {

        ContadorDePalabras c = new ContadorDePalabras();

        // System.out.println("EJERCICIO 1\n");
        // String p1 = "Hola me llamo Javier";
        // System.out.println(p1);
        // System.out.println(c.contaPalabras(p1) + "\n");

        // String p2 = "Hola tu";
        // System.out.println(p2);
        // System.out.println(c.contaPalabras(p2) + "\n");

        // String p3 = " ";
        // System.out.println(p3);
        // System.out.println(c.contaPalabras(p3) + "\n");

        // String p4 = "";
        // System.out.println(p4);
        // System.out.println(c.contaPalabras(p4) + "\n");

        // String p5 = "¡Hola!";
        // System.out.println(p5);
        // System.out.println(c.contaPalabras(p5) + "\n");

        // String p6 = "1234";
        // System.out.println(p6);
        // System.out.println(c.contaPalabras(p6) + "\n");

        // String p7 = "1234 111#)/%)&/=#)#/%=$(#$=)";
        // System.out.println(p7);
        // System.out.println(c.contaPalabras(p7) + "\n");

        // String p8 = "¡Hola!Mundo";
        // System.out.println(p8);
        // System.out.println(c.contaPalabras(p8) + "\n");

        // String p9 = " $%#% Hola 134 ";
        // System.out.println(p9);
        // System.out.println(c.contaPalabras(p9) + "\n");

        // String p10 = "Si piensas que tu profesor es exigente,... espera a conocer a
        // tu jefe !";
        // System.out.println(p10);
        // System.out.println(c.contaPalabras(p10) + "\n");

        // System.out.println("EJERCICIO 2\n");

        // String p11 = "Si piensas que tu profesor es exigente,... espera a conocer a
        // tu jefe !";
        // System.out.println(p11);
        // System.out.print("Mas de 4 letras: ");
        // System.out.println(c.ejercicioB(p11, 4) + "\n");

        // String p12 = "Si piensas que tu profesor es exigente,... espera a conocer a
        // tu jefe !";
        // System.out.println(p12);
        // System.out.print("Mas de 0 letras: ");
        // System.out.println(c.ejercicioB(p12, 0) + "\n");

        // String p13 = "1x1x1x1";
        // System.out.println(p13);
        // System.out.print("Mas de 4 letras: ");
        // System.out.println(c.ejercicioB(p13, 4) + "\n");

        // String p14 = "1x1x1x1";
        // System.out.println(p14);
        // System.out.print("Mas de 2 letras: ");
        // System.out.println(c.ejercicioB(p14, 2) + "\n");

        //String v2 = "Si piensas que tu profesor es exigente,... espera a conocer a tu jefe !";
        //System.out.println(v2);
        //System.out.println("consonantes: " + c.contadorVocales(v2)[0] + "\n" + "vocales: " + c.contadorVocales(v2)[1]);

        System.out.println("EJERCICIO 3\n");
        String[] lineas = c.obtenerLineas("src\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
        System.out.println(c.cantPalabras(lineas));

    }

}
