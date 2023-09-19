import random
from time import time

n= int(input("Ingrese la cantidad de N que quiere generar: "))
par= 0
Numeros_pares= []
inicio= time()
while n<=0:
    print("El tamaño de la muestra debe ser mayor a 0")
    n= int(input("Ingrese la cantidad de N que quiere generar: "))

for i in range(n):
    numer=random.randint(1, 1000)
    Numeros_pares.append(numer)
    
    if numer%2==0:
        par+=1
print("La cantidad de numeros pares es: ", par/n*100, "%")  
print("Los numeros generados son: ", Numeros_pares) 
print("El tiempo de ejecucion es: ", time()-inicio)     


        
    
       

