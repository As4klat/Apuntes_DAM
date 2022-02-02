import numbers
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

    for n in range(4):
        print("Ejercicio ", n+1)
        
    print ("Elige una opcion")
 
    opcion = pedirNumeroEntero()
 
    if opcion == 1:
        def HoraASegundos(hora:str):
            arr = hora.split(':')
            segundosHoras = int(arr[0])*3600
            segundosMinutos = int(arr[1])*60
            segundos = segundosHoras + segundosMinutos + int(arr[2])

            return str(segundos)

        def SegundosHoras(segundosHora):
            operando = True
            horas = 0
            minutos = 0
            segundos = 0
            while operando:    
                if segundosHora >= 3600:
                    segundosHora  = segundosHora-3600
                    horas = horas+1
                elif segundosHora >= 60:
                    segundosHora  = segundosHora-60
                    minutos = minutos+1
                else:
                    segundos = segundosHora
                    operando=False
            return horas, ':',minutos, ':',segundos

        selec = int(input('Segundos a hora(1) o horas a segundos(2) '))
        if selec == 1:
            hora=input('Introduzca hora: ')
            print(HoraASegundos(hora))
        elif selec == 2:
            segundos=input('Introduzca el número de horas: ')
            print(SegundosHoras(int(segundos)))
        salir = True
    elif opcion == 2:
        salir = True
    elif opcion == 3:
        salir = True
    elif opcion == 4: 
        salir = True        
    else:
        print ("Introduce un numero entre 1 y 4")
 
print ("Fin")