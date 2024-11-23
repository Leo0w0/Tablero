package juegos;
import java.util.Scanner;

public class Juegos {
    static Scanner leer = new Scanner(System.in);
    static int turno=0; ///////La variable turno tiene que ser static -Juan Fernando
    
    public static void main(String[] args) {
        char [][] tablero = new char [3][3];
                InicializarTablero(tablero);        
        
        while (true){  // Aca van los metodos que acaban el ciclo, SimbolosConsecutivos, Empate, EstaLLeno ETC - Juan Fernando
            
            imprimirTableroX0(tablero);
            
            char Jugador = ' '; //////Si el residuo es 0, es turno del jugador X, si el residuo es 1, es turno del jugador 0 - Juan Fernando
                    if (turno % 2 == 0){
                        Jugador ='X';
                    }
                    else {
                        Jugador = '0';
                    }
            System.out.println("Turno del jugador "+ turno%2);
            System.out.print("Ingrese la fila (0-2): ");
            int fil = leer.nextInt();
            System.out.print("Ingrese la columna (0-2): ");
            int col = leer.nextInt();
            
            tablero=MetodoX0(tablero, fil, col, Jugador); //// Remplazando el tablero anterior por el nuevo con las nuevas cordenadas
        }
        

    }
    
    public static void InicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    
    public static char [] [] MetodoX0 (char [][] tablero , int fil, int col, char Jugador){
              
        
            if (fil >= 0 && fil < 3 && col >= 0 && col < 3 && tablero[fil][col] == ' ') {
                tablero[fil][col] = Jugador; /////// Se ingresa el caracter del jugador a las coordenadas ingresadas
                turno++; // Cambiar el turno
            } else {
                System.out.println("Movimiento no valido");
            }
            
       return tablero;        
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
