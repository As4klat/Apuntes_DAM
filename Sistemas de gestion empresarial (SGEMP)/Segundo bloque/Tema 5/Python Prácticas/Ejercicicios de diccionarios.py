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

        print("Ejercicio 1".center(50,"="))
        cadena = input("Introduzca cadena: ")
        dic = {}
        for x in cadena.split():
            if x in dic:
                dic[x] += 1
            else:
                dic.setdefault(x,1)
        for clave,valor in dic.items():
            print(clave, " - ", valor)

        salir = True
    elif opcion == 2:
        print("Ejercicio 2".center(50,"="))

        morse = {
            'A': '.-',     'B': '-...',    'C': '-.-.',
            'D': '-..',    'E': '.',       'F': '..-.',
            'G': '--.',    'H': '....',    'I': '..',
            'J': '.---',   'K': '-.-',     'L': '.-..',
            'M': '--',     'N': '-.',      'O': '---',
            'P': '.--.',   'Q': '--.-',    'R': '.-.',
            'S': '...',    'T': '-',       'U': '..-',
            'V': '...-',   'W': '.--',     'X': '-..-',
            'Y': '-.--',   'Z': '--..',    '1': '.----',
            '2': '..---',  '3': '...--',   '4': '....-',
            '5': '.....',  '6': '-....',   '7': '--...',
            '8': '---..',  '9': '----.',   '0': '-----',
            '.': '.-.-.-', ',': '--..--',  ':': '---...',
            ';': '-.-.-.', '?': '..--..',  '!': '-.-.--',
            '"': '.-..-.', "'": '.----.',  '+': '.-.-.',
            '-': '-....-', '/': '-..-.',   '=': '-...-',
            '_': '..--.-', '$': '...-..-', '@': '.--.-.',
            '&': '.-...',  '(': '-.--.',   ')': '-.--.-'
        }

        palabra = input("Introduzca palabra: ")
        palabraMorse = ""
        for x in palabra.upper():
            palabraMorse += morse[x]
        print(palabraMorse)

        salir = True
    elif opcion == 3:
        print("Ejercicio 3".center(50,"="))

        morse = {
            'A': '.-',     'B': '-...',    'C': '-.-.',
            'D': '-..',    'E': '.',       'F': '..-.',
            'G': '--.',    'H': '....',    'I': '..',
            'J': '.---',   'K': '-.-',     'L': '.-..',
            'M': '--',     'N': '-.',      'O': '---',
            'P': '.--.',   'Q': '--.-',    'R': '.-.',
            'S': '...',    'T': '-',       'U': '..-',
            'V': '...-',   'W': '.--',     'X': '-..-',
            'Y': '-.--',   'Z': '--..',    '1': '.----',
            '2': '..---',  '3': '...--',   '4': '....-',
            '5': '.....',  '6': '-....',   '7': '--...',
            '8': '---..',  '9': '----.',   '0': '-----',
            '.': '.-.-.-', ',': '--..--',  ':': '---...',
            ';': '-.-.-.', '?': '..--..',  '!': '-.-.--',
            '"': '.-..-.', "'": '.----.',  '+': '.-.-.',
            '-': '-....-', '/': '-..-.',   '=': '-...-',
            '_': '..--.-', '$': '...-..-', '@': '.--.-.',
            '&': '.-...',  '(': '-.--.',   ')': '-.--.-'
        }

        palabraMorse = input("Introduzca palabra en codigo morse: ")
        palabra = ""
        for x in palabraMorse.split(" "):
            for clave,valor in morse.items():
                if valor==x:
                    palabra+=clave
        print(palabra)

        salir = True
    elif opcion == 4:

        dic = {}
        nombre = input("Nombre de la persona: ")
        while nombre != "*":
            gusto = input("Gusto de la persona: ")
            if nombre in dic:
                if gusto not in dic[nombre]:
                    dic[nombre].append(gusto)
            else:
                dic.setdefault(nombre, [gusto])
            nombre = input("Nombre de la persona: ")     
        else:
            for clave,valor in dic.items():
                print(clave, "-", valor)           
    else:
        print ("Introduce un numero entre 1 y 4")
 
print ("Fin")