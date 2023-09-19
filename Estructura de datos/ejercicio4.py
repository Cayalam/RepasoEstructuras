import random
from time import time

N= int(input("Digite la cantidad de numeros pares que quiere ordenar: "))
while N<0:
    print("valor incorrecto")
    N= int(input("Digite la cantidad de numeros pares que quiere ordenar: "))

pares= 0
sumaVector= 0
Numero= []
MenorPromedio= 0
Vector_Menor= []
inicio = time()
while pares!=N: #ciclo para generar los numeros pares
  numero=random.randint(1, 1000)#genera numeros aleatorios
  if numero%2==0:#condicion para que el numero sea par
    pares+=1
    Numero.append(numero)
suma_pares=len(Numero)
for i in range (suma_pares):#ciclo para sumar los numeros pares
  sumaVector=  sumaVector +Numero[i]#suma los numeros pares
promedio=sumaVector/N#saca el promedio de los numeros pares

for i in range (N):#ciclo para saber cuantos numeros son menores al promedio
  if promedio>Numero[i]:
    MenorPromedio+= 1
    Vector_Menor.append(Numero[i])#Agrega los numeros menores al promedio a un vector
if N/2>MenorPromedio:#condicion para saber si la cantidad de numeros menores al promedio es mayor a la mitad de los numeros pares
  def quicksort(Vector_Menor, izquierda, derecha):
    if izquierda < derecha:
        indiceParticion = particion(Vector_Menor, izquierda, derecha)
        quicksort(Vector_Menor, izquierda, indiceParticion)
        quicksort(Vector_Menor, indiceParticion + 1, derecha)


  def particion(Vector_Menor, izquierda, derecha):

    pivote = Vector_Menor[izquierda]
    while True:
       
        while Vector_Menor[izquierda] < pivote:
            izquierda += 1

        
        while Vector_Menor[derecha] > pivote:
            derecha -= 1

   
        if izquierda >= derecha:
            
            return derecha
        else:
            
            Vector_Menor[izquierda], Vector_Menor[derecha] = Vector_Menor[derecha],    Vector_Menor[izquierda]
           
            izquierda += 1
            derecha -= 1



  quicksort(Vector_Menor, 0, len(Vector_Menor) - 1)


    
    
print("El tiempo de ejecucion es: ", time()-inicio)   


    
  

   


  

  




