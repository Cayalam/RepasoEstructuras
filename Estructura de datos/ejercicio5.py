
Numero_perfecto=0
for i in range(1,10001):
    x=int(i/2+1)
    for j in range(1,x):
        if i%j==0:
            Numero_perfecto+=j
    if Numero_perfecto==i:
        print("Numero perfecto: ",i)
    Numero_perfecto=0
        


