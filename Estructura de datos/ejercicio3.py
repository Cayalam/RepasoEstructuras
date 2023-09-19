import random
from time import time

n= int(input("Ingrese la cantidad de N que quiere generar: "))
valores=[5000,10000,15000,20000,25000]
Numeros= []

while n not in valores:
    print("El tamaño de la muestra debe estardentro del rango")
    n= int(input("Ingrese la cantidad de N que quiere generar: "))
    
inicio= time()

for i in range(n):
    numer=random.randint(1, 2000)
    Numeros.append(numer)
def quicksort(Numeros, izquierda, derecha):
    if izquierda < derecha:
        indiceParticion = particion(Numeros, izquierda, derecha)
        quicksort(Numeros, izquierda, indiceParticion)
        quicksort(Numeros, indiceParticion + 1, derecha)


def particion(Numeros, izquierda, derecha):
    pivote = Numeros[izquierda]
    while True:
       
        while Numeros[izquierda] < pivote:
            izquierda += 1

        
        while Numeros[derecha] > pivote:
            derecha -= 1

   
        if izquierda >= derecha:
            
            return derecha
        else:
            
            Numeros[izquierda], Numeros[derecha] = Numeros[derecha],    Numeros[izquierda]
           
            izquierda += 1
            derecha -= 1




quicksort(Numeros, 0, len(Numeros) - 1)
print("Después de ordenarlo: ")
print(Numeros)

    
    
print("El tiempo de ejecucion es: ", time()-inicio)   