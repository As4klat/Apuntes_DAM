from __future__ import division
from audioop import mul
from cmath import sin
from operator import truediv
from random import randint
from select import select
from tokenize import Double
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

        if diferencia != 1:
            print("Para llegar al año " + str(añoActual) + " faltan " + str(diferencia) + " años")
        else:
            print("Para llegar al año " + str(añoActual) + " falta " + str(diferencia) + " año")
        salir = True

    elif opcion == 3:

        print("COMPARADOR DE TRES NÚMEROS")
        n1 = input("Escriba un número: ")
        n2 = input("Escriba otro número: ")
        n3 = input("Escriba otro número más: ")

        if n1 == n2 == n3:
            print("Ha escrito tres veces el mismo número.")
        elif n1 == n2 or n1 == n3 or n2 == n3:
            print("Ha escrito uno de los números dos veces.")
        else:
            print("Los tres nmúmeros que ha escrito son distintos.")
        salir = True

    elif opcion == 4:

        print("DIVISORES")
        divisor = int(input("Escriba un número mayor de 0: "))
        if divisor < 0:
            print("¡Le he pedido un número mayor que cero!")
        else:
            cadena = "Los divisores de " + str(divisor) + " son " 
            for n in range(1,(divisor//2)+1):
                if divisor % n == 0:
                    cadena += str(n) + " "
            print(cadena + str(divisor))
        salir = True

    elif opcion == 5:

        print("MAYORES QUE EL PRIMERO")
        n = int(input("¿Cuántos valores va a introducir? "))
        if n <= 0:
            print("¡Imposible!")
        else:
            valor = int(input("Escriba un número: "))
            comparacion = valor
            n = n-1
            while n != 0:
                valor = int(input("Escriba un número más grande que " + str(comparacion) +  ": "))
                if comparacion > valor:
                    print("!" + str(valor) + " no es mayor que " + str(comparacion) + "!")
                n = n - 1
        salir = True

    elif opcion == 6:

        def multiplicacion():
            n1 = randint(2,10)
            n2 = randint(2,10)
            respuesta = int(input("¿Cuánto es "+ str(n1) + " x " + str(n2) + "? "))
            if (n1*n2) == respuesta:
                print("¡Respuesta correcta!")
            else:
                print("¡Respuesta incorrecta!")

        print("Apartado 1")
        print("Apartado 2")
        print("Apartado 3")
        opcion = int(input("Elija apartado: "))
        if opcion == 1:
            multiplicacion()
        elif opcion == 2:
            repetir = int(input("Número de preguntas: "))
            if repetir <= 0:
                print("El número de preguntas debe ser al menos 1")
            else:
                while repetir != 0:
                    multiplicacion()
                    repetir = repetir - 1
        elif opcion == 3:
            nPreguntas = int(input("Número de preguntas: "))
            if nPreguntas <= 0:
                print("El número de preguntas debe ser al menos 1")
            else:
                repetir = nPreguntas
                cont = 0
                while repetir != 0:
                    n1 = randint(2,10)
                    n2 = randint(2,10)
                    respuesta = int(input("¿Cuánto es "+ str(n1) + " x " + str(n2) + "? "))
                    if (n1*n2) == respuesta:
                        print("¡Respuesta correcta!")
                        cont = cont + 1
                    else:
                        print("¡Respuesta incorrecta!")
                    repetir = repetir - 1
                nota = cont / nPreguntas * 10
                print("Ha contestado correctamente " + str(cont) + " preguntas")
                print("Le corresponde una nota de " + str(nota))
        else:
            print("Error en la entrada 1-3")    
        salir = True

    else:
        print ("Introduce un numero entre 1 y 6")
print ("Fin")