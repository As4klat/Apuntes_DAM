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

    for n in range(7):
        print("Ejercicio " + str(n+1))
        
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
        cadena=input("Palabra:")
        lista=[]
        while cadena != " ":
            lista.append(cadena)
            cadena=input("Palabra2 , escribe espacio para termina:")		

        buscar=input("Palabra a buscar:")
        print ("La he encontrado %d veces"% lista.count(buscar))


        salir = True
    elif opcion == 3:
        
        salir = True
    elif opcion == 4:
        lista = []
        cadena = input("Introduce una cadena. (* para terminar):")
        while cadena != "*":
            lista.append(cadena)
            cadena = input("Introduce una cadena. (* para terminar):")
        while True:
            print("\n")
            print("1. Contar")
            print("2. Modificar")
            print("3. Eliminar")
            print("4. Mostrar")
            print("5. Salir")
            opcion = int(input("Dime opción:"))
            if opcion == 1:
                cadena = input("Introduce una cadena a buscar:")
                print("La cadena aparece %d veces" % lista.count(cadena))
            elif opcion == 2:
                cadena = input("Introduce una cadena a buscar:")
                cadena2 = input("Introduce una cadena a modificar:")
                indice = 0
                for elemento in lista:
                    if elemento == cadena:
                        lista[indice] = cadena2
                    indice += 1
            elif opcion == 3:
                cadena = input("Introduce una cadena a eliminar:")
                if cadena in lista:
                    while cadena in lista:
                        lista.remove(cadena)
                else:
                    print("No existe la cadena en la lista.")
            elif opcion == 4:
                for elemento in lista:
                    print(elemento," ",end="")
            elif opcion == 5:
                break
            else:
                print("Opción incorrecta")
        salir = True
    elif opcion == 5:
        palabra=input("Palabra lista 1:")
        lista1=[]
        while palabra != " ":
            lista1.append(palabra)
            palabra=input("Palabra lista 1:")		

        palabra=input("Palabra lista 2:")
        lista2=[]
        while palabra != " ":
            lista2.append(palabra)
            palabra=input("Palabra lista 2:")		

		
        listaaux=[]
        for cad in lista1:
            if not cad in listaaux:
                listaaux.append(cad)
        lista1=listaaux[:]

        print (lista1)		

		
        listaaux=[]
        for cad in lista2:
            if not cad in listaaux:
                listaaux.append(cad)
        lista2=listaaux[:]
        print (lista2)		

        print ("Lista de palabras que aparecen en las dos listas.")
        lista3=lista1[:]
        lista3.extend(lista2)		


        listaaux=[]
        for cad in lista3:
            if not cad in listaaux:
                listaaux.append(cad)
        lista3=listaaux[:]
        print (lista3)		

        print ("Lista de palabras que aparecen en la primera lista, pero no en la segunda.")
        lista4=[]
        for cad in lista1:
            if not cad in lista2:
                lista4.append(cad)
        print (lista4)
	
        print ("Lista de palabras que aparecen en la segunda lista, pero no en la primera.")
        lista5=[]
        for cad in lista2:
            if not cad in lista1:
                lista5.append(cad)
        print (lista5)	

        print ("Lista de palabras que aparecen en ambas listas.")
        lista6=[]
        for cad in lista1:
            if cad in lista2:
                lista6.append(cad)
        print (lista6)
        salir = True
    elif opcion == 6:
        conwhile=1
        alumnos=[]
        while conwhile==1:
            nombrealum=input("Introduce nombre del alumno y pulse ('*' para finalizar): ")
            if nombrealum!="*":
                edad=int(input("Introduce la edad: "))
                alumnos.append(nombrealum)
                alumnos.append(edad)
            else:
                conwhile=0

        masviejo=[]
        mayorEdad=0
        cont=0

        while cont<len(alumnos):
            if cont==1:
                mayorEdad=alumnos[1]
            else:
                if cont%2!=0:
                    if alumnos[cont]>mayorEdad:
                        mayorEdad=alumnos[cont]
            cont=cont+1

        cont=0

        while cont<len(alumnos):
            if cont%2!=0:
                if alumnos[cont]>=mayorEdad:
                    masviejo.append(alumnos[cont-1])
            cont=cont+1

        print("Los nombres de los alumnos con más edad: "+str(masviejo))

        media=0

        for element in alumnos:
            if type(element) is int:
                media=media+element

        media=media/(len(alumnos)/2)

        print("La media de edad de la clase: "+str(media))

        nombrealum=input("Introduce el nombre del alumno del que quieras saber la edad: ")

        alumnosEdad=[]

        cont=0

        while cont<len(alumnos):
            if cont%2==0:
                if alumnos[cont]==nombrealum:
                    print("Alumno: "+alumnos[cont]+" Edad: "+str(alumnos[cont+1]))
        cont=cont+1

        alumnosMayoresDeEdad=[]

        cont=0

        while cont<len(alumnos):
            if cont%2!=0:
                 if alumnos[cont]>=18:
                    alumnosMayoresDeEdad.append(alumnos[cont-1])
                    alumnosMayoresDeEdad.append(alumnos[cont])
        cont=cont+1

        print("Los alumnos con mayoria de edad son: "+str(alumnosMayoresDeEdad))
        salir = True
    elif opcion == 7:
        salir = True            
    else:
        print ("Introduce un numero entre 1 y 3")
 
print ("Fin")