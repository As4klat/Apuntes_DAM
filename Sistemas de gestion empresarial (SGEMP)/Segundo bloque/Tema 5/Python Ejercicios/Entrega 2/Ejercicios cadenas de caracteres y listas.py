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
        print("Ejercicio " + str(n))
        
    print ("Elige una opcion\n")
 
    opcion = pedirNumeroEntero()
 
    if opcion == 1:

        print("Ejercicio 1".center(50,"="))
        primeraCadena = input("Cadena 1: ")
        segundaCadena = input("Cadena 2: ")
        primeraCadena = primeraCadena.lower()
        segundaCadena = segundaCadena.lower()
        if segundaCadena in primeraCadena:
            print("La segunda cadena es una subcadena de la primera")
        else:
            print("La segunda cadena no es una subcadena de la primera")

        salir = True
    elif opcion == 2:

        print("Ejercicio 2".center(50,"="))
        cadena = input("Introduzca cadena: ")
        cont = 0
        if cont > 2:
            print("Tiene caracteres repetidos")
        else:
            print("NO tiene caracteres repetidos")

        salir = True
    elif opcion == 3:
        print("Opcion 3")
        salir = True
    elif opcion == 4:
        salir = True
    else:
        print ("Introduce un numero entre 1 y 3")
 
print ("Fin")