def pedirNumeroEntero():
 
    correcto=False
    num=0
    while(not correcto):
        try:
            num = int(input("Introduce un numero entero: "))
            correcto=True
        except ValueError:
            print('Error, introduce un numero entero')
     
    return num
 
salir = False
opcion = 0
 
while not salir:

    for n in range(6):
        print("Ejercicio" )
        
    print ("Elige una opcion")
 
    opcion = pedirNumeroEntero()
 
    if opcion == 1:
        print ("Opcion 1")
        salir = True
    elif opcion == 2:
        print ("Opcion 2")
        salir = True
    elif opcion == 3:
        print("Opcion 3")
        salir = True
    else:
        print ("Introduce un numero entre 1 y 3")
 
print ("Fin")