# Main
- Metodos:

> `Main`
> 
> `Menu`

# Metodo de Entrada:

- El jugador Ingresada una cordenada:

> pedir la fila, y la columna.

# XO

- Metodos

> `CrearTablero` Metodo retorna tablero => Ariel Castillo
> 
> `ImprimirTablero`Metodo void imprime matriz => Luis Franco
> 
> `MetodoXO` Retorna una matriz con el char respectivo => Juan Fernando
> 
> `SimbolosConsecutivos`Metodo boolean que revisa si alguien ha ganado => Leonardo
> 
> `EstaLLeno` Metodo boolean que revisa si esta lleno => Abraham
> 
> `Estarepetido` Metodo boolean que verifique si una casilla esta llena => Raihane

- Programa tiene que dejar a dos jugadores ingresar una coordenada de forma alterna.

```Java
int contador = 2;
do{
	if(contador % 2 == 0){
	System.out.print("fila para jugador 1(X): ");
	int fila = scan.nextInt();
	columna para jugador 1(X):
	int columna = scan.nextInt();
	int[][] Matriz = MetodoXO(X,fila,columa);
	}
	else{
	fila para jugador 2(O):
	int columna = scan.nextInt();
	columna para jugador 2(O):
	int columna = scan.nextInt();
	int[][] Matriz = MetodoXO(O,fila,columna);
	}
	SimbolosConsecutivos(Matriz);
	EstaLLeno(Matriz);
	
}while(!SimbolosConsecutivos(Matriz) || !EstaLLeno(Matriz) )
```

- se crea otro metodo tipo `int[][]`  `MetodoXO` que retorna una matriz, se reciben tres parametros:  
> el tablero, la fila y la columna.  
  
- Se llama otro metodo tipo boolean llamado `SimbolosConsecutivos` que revisa si alguien ha ganado.  
- Se Llama otro metodo tipo boolean llamado `EstaLleno` que revisa si esta lleno  
- se Imprime el estado de la matriz despues de cada turno con un metodo `ImprimirMatriz`
# Battleship
>`CrearTablero` crea las dos matrices vacias
>
>`Colocar barcos`
>
>`validar posiciones` que verifique que las posiciones esten dentro del tablero, que esten en lineas rectas
>
>`disparos` procesar los disparos
>
>`validacion de los disparos` validar que no sea un disparo repetido
>
>`validar impacto` ver si el disparo le dio al barco, y agregarlo
>
>>`actualizar los tableros`
>>
>`cambiar los turnos de los jugadores`
>
>`validar ganador`
>
>
## reglas
>Tablero de 10x10
>
>Los barcos: 1 de 4 casillas, 2 de 3 casillas y 3 de 2 casillas
>
>Los barcos deben de estar en linea recta (horizontal y vertical), no diagonales ni sobreponerse
>
>No se puede disparar dos veces en la misma posicion
>
>Informar si el disparo impacto al agua, toco al barco o lo hundio(ya cuando impacto todas las partes del barco)
