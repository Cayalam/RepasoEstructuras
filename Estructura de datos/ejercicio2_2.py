import random
from time import time
inicio = time()
valores=[4000,8000,12000,16000]
vector=[]
N= int(input("Digite un numero: "))
while N not in valores:
    print("valor incorrecto")
    N= int(input("Digite un numero: "))

x= int(N/5)
for i in range(x):
    vector.append(random.randint(1, 400))
    
for i in range(x):
    vector.append(random.randint(401, 800))
    
for i in range(x):
    vector.append(random.randint(801, 1200))
    
for i in range(x):
    vector.append(random.randint(1201, 1600))
    
for i in range(x):
    vector.append(random.randint(1601, 2000))
   
for i in range(N-1):
    for j in range(N-i-1):
        if vector[j]>vector[j+1]:
            if vector [j]>vector[j+1]:
                vector[j], vector[j+1] = vector[j+1], vector[j]
print(vector)
print("Tiempo de ejecución: ",time()-inicio)


     

                         

