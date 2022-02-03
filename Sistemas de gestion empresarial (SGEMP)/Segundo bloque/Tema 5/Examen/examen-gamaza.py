import csv

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
 
ficheroCsv = open("liga.csv")
partidos = csv.reader(ficheroCsv)
partidos = list(partidos)

ficheroCsv.close()

equipos = {}
for x in partidos:
    if x[1] not in equipos and x[1] != "Team 1":
        equipos.setdefault(x[1],{"partidosGanados":0,"partidosPerdidos":0,"partidosEmpatados":0,"nPartidos":0, "puntos":0})

print(equipos)

for clave,valor in equipos.items():
    for  x in partidos:
        if clave == x[1] or clave == x[2]:
            resultado = x[3].split("-")
            if x[1]==clave and resultado[0] > resultado[1]:
                valor["partidosGanados"] += 1
                valor["puntos"] += 3
            if x[2]==clave and resultado[0] < resultado[1]:
                valor["partidosGanados"] += 1
                valor["puntos"] += 3
            if x[1]==clave and resultado[0] < resultado[1]:
                valor["partidosPerdidos"] += 1
            if x[2]==clave and resultado[0] > resultado[1]:
                valor["partidosPerdidos"] += 1
            if resultado[0] == resultado[1]:
                valor["partidosEmpatados"] += 1
                valor["puntos"] += 1
            valor["nPartidos"] += 1

while not salir:

    print("1 - Listado equipos")
    print("2 - Buscar equipo")
    print("3 - Guardar clasificación")
    print("4 - Salir de la aplicacion")
        
    print ("Elige una opcion")
 
    opcion = pedirNumeroEntero()
 
    if opcion == 1:
        for clave,valor in equipos.items():
            print(clave,": ", valor)
    elif opcion == 2:
        equipo = input("Nombre del equipo que deseas mirar: ").title()
        print(equipo + ": ", equipos[equipo])
    elif opcion == 3:
        ficheroNuevoCsv = open("equipos-sorted.csv","w")
        contenido = csv.writer(ficheroNuevoCsv)
        listaEquipos = list(equipos.items())
        listaEquipos.sort()
        print(listaEquipos)
        for equipo in listaEquipos:
            contenido.writerow(equipo)
        ficheroNuevoCsv.close()
    elif opcion == 4:
        salir = True
    else:
        print ("Introduce un numero entre 1 y 3")
 
print ("Fin")