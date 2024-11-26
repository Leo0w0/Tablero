package juegos;

import java.util.Scanner;
import java.util.Random;

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

                    JugarBattleShip();

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
            System.out.println("Turno del jugador " + ((turno % 2) + 1) + " (" + Jugador + ")");
            System.out.print("Ingrese la fila (0-2): ");
            int fil = leer.nextInt();
            System.out.print("Ingrese la columna (0-2): ");
            int col = leer.nextInt();

            tablero = MetodoX0(tablero, fil, col, Jugador); //// Remplazando el tablero anterior por el nuevo con las nuevas cordenadas

            if (ganador(tablero, Jugador)) {
                imprimirTableroX0(tablero);
                System.out.println("El jugador" + " " + Jugador + " " + "gana");
                break;
            }

            if (empate(tablero)) {
                imprimirTableroX0(tablero);
                System.out.println("Es un empate");
                break;
            }
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
        System.out.println();
    }

    public static boolean ganador(char[][] tablero, char jugador) {
        return SimbolosConsecutivos(tablero); //Aqui retorna quien fue el jugador que gano
    }

    public static boolean empate(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
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

    //TERMINA EL JUEGO X-0
    ///
    ///
    ///
    //INICIA BATTLESHIP
public static void JugarBattleShip() {
        int filas = 7;
        int columnas = 7;
        int turnos = 15;
        int turnosRestantes = turnos;
        int numBarcos = 3;
        int tamanoBarco = 3;

        
        char[][] matrizVisible = new char[filas][columnas];
        int[][] tablero = GenerarBarcos(filas, columnas, numBarcos, tamanoBarco);
        int[][] matrizPrincipal = tablero;
        matrizVisible = MatrizVisible(matrizVisible, filas, columnas); ///////Inicializar La matriz Visible        
        boolean[][] disparosRealizados = new boolean[filas][columnas]; //////// Matriz hecha para rastrear los disparos -Juan

        int x = -1; /// Inicio las variables en -1 para que entren al while
        int y = -1;

        while ( turnosRestantes > 0) { ////ciclo entero del juego, aca van los boolean que terminan el ciclo - Juan

            System.out.println("Turnos restantes: " + turnosRestantes);

            boolean EsValido = false; ///// Variable que decide si deja pasar las coordenadas -Juan

            while (!EsValido) { //////// Dejar salir las coordenadas siempre y cuando sean validas -Juan

                ImprimirMatriz(matrizVisible);

                System.out.println("Ingrese la fila para disparar (0-6)");
                x = leer.nextInt(); /////// X ES LA FILA A DISPARAR
                System.out.println("Ingrese la columna para disparar (0-6)");
                y = leer.nextInt();  ///////// Y ES LA COLUMNA A DISPARAR

                if (x < 0 || x >= filas || y < 0 || y >= columnas) {
                    System.out.println("Coordenadas invalidas");
                    continue;
                }
                EsValido = validarDisparo(disparosRealizados, x, y);

                if (EsValido == true) {
                    System.out.println("Bien! Disparaste en " + x + " " + y);
                } else {
                    System.out.println("Ya has disparado en " + x + " " + y);
                }
                
                registrarDisparo(matrizPrincipal, matrizVisible, x, y);
            }

            if (Ganador(matrizVisible, matrizPrincipal)) {
                System.out.println("Ha hundido todos los barcos");
                ImprimirMatriz(matrizPrincipal);
                turnosRestantes = -1;
            }

            /// ACA VA EL METODO QUE REGISTRA EL DISPARO YA CUANDO LAS COORDENADAS SEAN VALIDAS
            /// SE RESTA UN TURNO MENOS -Juan
            turnosRestantes--;
            
            if(turnosRestantes == 0){
                System.out.println("Se acabaron los turnos");
                ImprimirMatriz(matrizPrincipal);
                break;
            }

        }

        

    }

    public static int[][] GenerarBarcos(int filas, int columnas, int numBarcos, int tamanoBarco) {
        Random r = new Random();
        int[][] tablero = new int[filas][columnas];

        for (int b = 0; b < numBarcos; b++) {
            boolean colocado = false;

            while (!colocado) {
                int filaInicio = r.nextInt(filas);
                int columnaInicio = r.nextInt(columnas);

                // Comprobar si el barco cabe horizontalmente sin salirse ni chocar con otro barco
                if (columnaInicio + tamanoBarco <= columnas) {
                    boolean espacioLibre = true;

                    // Verificar si las celdas están libres
                    for (int j = columnaInicio; j < columnaInicio + tamanoBarco; j++) {
                        if (tablero[filaInicio][j] == 1) {
                            espacioLibre = false;
                            break;
                        }
                    }

                    // Colocar el barco si hay espacio libre
                    if (espacioLibre) {
                        for (int j = columnaInicio; j < columnaInicio + tamanoBarco; j++) {
                            tablero[filaInicio][j] = 1; // Marcar las posiciones del barco
                        }
                        colocado = true;
                    }
                }
            }
        }

        return tablero;
    }



    static void registrarDisparo(int[][] matrizPrincipal, char[][] matrizVisible, int fila, int colum) {
        if (matrizPrincipal[fila][colum] == 1) {
            System.out.println("Ha golpeado un barco.");
            matrizVisible[fila][colum] = 'X';
        } else {
            System.out.println("Ha impactado con el agua");
            matrizVisible[fila][colum] = '~';
        }
    }

    static char[][] MatrizVisible(char[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = '-';
            }
        }
        return matriz;
    }

    static void ImprimirMatriz(char[][] matriz) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void ImprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //??para imprimir la visible y la principal

    public static boolean validarColocacionBarco(char[][] tablero, int fila, int col, int tamano) { //?? no encuentro la variable tamano
        // Verifica que el barco no se salga del tablero
        if (col + tamano > 7) {
            return false;
        }

        // Verifica que no haya otros barcos en las posiciones donde se quiere colocar
        for (int i = 0; i < tamano; i++) {
            if (tablero[fila][col + i] != ' ') {
                return false;
            }
        }

        return true;
    }

    public static boolean Ganador(char[][] tablero, int[][] matrizPrincipal) {
        int partesDeBarcosRestantes = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (matrizPrincipal[i][j] == 1 && tablero[i][j] != 'X') { // Busca partes de barcos
                    partesDeBarcosRestantes++;
                }
            }
        }
        return partesDeBarcosRestantes == 0; // Ganador si no hay partes restantes
    }

    public static boolean validarDisparo(boolean[][] disparosRealizados, int x, int y) {
        // Revisar la matriz que rastrea los disparos para ver si ya uso esas coordenadas
        if (disparosRealizados[x][y]) {
            return false;
        }

        // Si no ha disparado, marcar la posicion como true
        disparosRealizados[x][y] = true;
        return true;
    }

    //TERMINA BATTLESHIP
}
