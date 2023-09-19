# 
clave =input('digite clave: ')
c=0
for i in range (0,10):
    for j in range (0,10):
        for k in range (0,10):
            c+=1
            if clave ==str(i)+str(j)+str(k):
                print('la clave es: ', str(i)+str(j)+str(k), ' intentos: ', c)
                break




    


    
    
