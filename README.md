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

## reglas
