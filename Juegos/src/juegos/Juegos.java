/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegos;
import java.util.Scanner;
/**
 *
 * @author leona
 */
public class Juegos {
    static Scanner leer = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char [][] tablero = new char [3][3];
        InicializarTablero(tablero);
        ImprimirTablero(tablero);
    }
    public static void InicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    public static void ImprimirTablero(char[][] tablero) {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -+-+-");
        }
        System.out.println();
    }
}
