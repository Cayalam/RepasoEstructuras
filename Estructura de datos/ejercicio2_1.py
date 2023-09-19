import random
from time import time

vector =[]
inicio=time()
for i in range (4000):
    vector.append(random.randint(1,2000))
 

n=4000
for i in range(n-1):      
    for j in range(n-1-i): 
        if vector[j] > vector[j+1]:
            vector[j], vector[j+1] = vector[j+1], vector[j]


print("Tiempo de ejecucíon: ",time()-inicio)