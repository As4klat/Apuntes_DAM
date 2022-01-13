from __future__ import division
from unicodedata import decimal


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

    for n in range(1,7):
        print("Ejercicio " + str(n))
        
    print ("\nElige una opcion")
 
    opcion = pedirNumeroEntero()
 
    if opcion == 1:

        print("DIVISOR DE NÚMEROS")
        dividiendo = int(input("Escriba el dividiendo: "))
        divisor = int(input("Escriba el divisor: "))

        if divisor == 0:
            print("El divisor no puede ser 0.")
        
        total = divmod(dividiendo,divisor)

        if total[1] == 0:
            exacta = "La división es exacta."
        else:
            exacta = "La división no es exacta."
        
        print(exacta + " Consciente: "+str(total[0]) + " Resto: " + str(total[1]))
        salir = True

    elif opcion == 2:

        print("COMPARADOR DE AÑOS")
        añoActual = int(input("¿En que año estamos? "))
        año = int(input("Escriba un año cualquiera: "))

        diferencia = añoActual - año

        
        salir = True
    elif opcion == 3:
        salir = True
    elif opcion == 4:
        salir = True
    elif opcion == 5:
        salir = True
    elif opcion == 6:
        salir = True
    else:
        print ("Introduce un numero entre 1 y 6")
 
print ("Fin")