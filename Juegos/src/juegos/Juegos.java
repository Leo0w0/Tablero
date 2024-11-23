package juegos;
import java.util.Scanner;

public class Juegos {
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        char [][] tablero = new char [3][3];
        InicializarTablero(tablero);
        imprimirTableroX0(tablero);
    }
    
    public static void InicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    
    // Hecho por Luis Franco
    public static void imprimirTableroX0(char[][] tablero){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                if(j < 2){
                    System.out.print(" " + tablero[i][j] + " |");
                }
                else{
                    System.out.print(" " + tablero[i][j]);
                }
            }
            System.out.println();
            if(i < 2){
                System.out.println("---+---+---");
            }            
        }
    }
    
    public static boolean Empate(char[][] tablero){
        for (int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                if(tablero[i][j] != 'x' ||tablero[i][j] != 'X' && tablero[i][j] != '0')
                    return false;
            }
        }
    return true;
    }
}

