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
bdo = {}
 
while not salir:

    print("1 - Añadir alumno")
    print("2 - Eliminar alumno")
    print("3 - Mostrar alumno")
    print("4 - Mostrar lista de alumnos")
    print("5 - Mostrar lista de repetidores")
    print("6 - Salir")
        
    print ("Elige una opcion")
 
    opcion = pedirNumeroEntero()
    

    if opcion == 1:
        nif = input("NIF del alumno: ")
        nombre = input("Nombre del alumno: ")
        telefono = input("Telefono: ")
        correo = input("Correo: ")
        repetidor = input("¿Es repetidor? ")

        if repetidor == "si":
            repetidor = True
        else:
            repetidor = False    

        alumno = {nif: {
            'nombre': nombre,
            'telefono': telefono,
            'correo': correo,
            'repetidor': repetidor
        }}

        if nif not in bdo:
            bdo.update(alumno)

    elif opcion == 2:
        print("")
    elif opcion == 3:
        nif = input("NIF del alumno a mostrar: ")
        for clave,valor in bdo.items():
            if clave == nif:
                print(clave, ' - ', valor)
    elif opcion == 4:
        for clave,valor in bdo.items():
            print(clave, ' - ', valor['nombre'])
    elif opcion == 5:
        for clave,valor in bdo.items():
            if valor['repetidor'] == True:
                print(clave, ' - ', valor['nombre'])
    elif opcion == 6:
        print("Finalización del programa.")
        salir = True
    else:
        print ("Introduce un numero entre 1 y 6")
 
print ("Fin")