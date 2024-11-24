package juegos;

import java.util.Scanner;

public class Juegos {

    static Scanner leer = new Scanner(System.in);
    static int turno = 0; ///////La variable turno tiene que ser static -Juan Fernando

    public static void main(String[] args) {
        char resp = 's';
        do {
            int opc = Menu();
            switcher(opc);
            System.out.println("Quiere continuar(s/n)? ");
            resp = leer.next().charAt(0);
        } while (resp == 's');
        System.out.println("Saliendo...");
    }

    public static int Menu() {
        System.out.println("--Menu de Juegos--");
        System.out.println("0. Salir");
        System.out.println("1. XO");
        System.out.println("2. Battleship");
        System.out.print("Ingrese su opcion: ");
        int opc = leer.nextInt();
        return opc;
    }

    public static void switcher(int opc) {
        if (opc != 0) {
            switch (opc) {
                case 1: {
                    JugarXO();
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    System.out.println("Error: opcion no valida");
                }
            }
        }
    }

    public static void JugarXO() {
        char[][] tablero = new char[3][3];
        InicializarTablero(tablero);

        while (true) {  // Aca van los metodos que acaban el ciclo, SimbolosConsecutivos, Empate, EstaLLeno ETC - Juan Fernando

            imprimirTableroX0(tablero);

            char Jugador = ' '; //////Si el residuo es 0, es turno del jugador X, si el residuo es 1, es turno del jugador 0 - Juan Fernando
            if (turno % 2 == 0) {
                Jugador = 'X';
            } else {
                Jugador = '0';
            }
            System.out.println("Turno del jugador " + turno % 2);
            System.out.print("Ingrese la fila (0-2): ");
            int fil = leer.nextInt();
            System.out.print("Ingrese la columna (0-2): ");
            int col = leer.nextInt();

            tablero = MetodoX0(tablero, fil, col, Jugador); //// Remplazando el tablero anterior por el nuevo con las nuevas cordenadas
        }

    }

    public static void InicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public static char[][] MetodoX0(char[][] tablero, int fil, int col, char Jugador) {

        if (fil >= 0 && fil < 3 && col >= 0 && col < 3 && tablero[fil][col] == ' ') {
            tablero[fil][col] = Jugador; /////// Se ingresa el caracter del jugador a las coordenadas ingresadas
            turno++; // Cambiar el turno
        } else {
            System.out.println("Movimiento no valido");
        }

        return tablero;
    }

    // Hecho por Luis Franco
    public static void imprimirTableroX0(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j < 2) {
                    System.out.print(" " + tablero[i][j] + " |");
                } else {
                    System.out.print(" " + tablero[i][j]);
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    public static boolean empate(char[][] tablero) {
        boolean isFull = true;
        boolean empate = false;
        
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == ' ') {
                    isFull = false;
                }
            }
        }
        
        boolean hayGanador = SimbolosConsecutivos(tablero); // Aquí usamos el método SimbolosConsecutivos
        
        if(isFull && (!hayGanador)) {
            empate = true;
        }
        
        return empate;
    }
    public static boolean SimbolosConsecutivos(char[][] tablero) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != ' ' && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }
        
        // Verificar diagonal principal
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        
        // Verificar diagonal secundaria
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }
        
        return false;
    }
}