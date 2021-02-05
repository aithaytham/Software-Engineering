import smbus as smbus 
import time


bus = smbus.SMBus(1)


F1_c1= 0x01 # adre sse disponible de 16 ? 239
F1_c2= 0x02 # numero des cases selon le clavier d’ordi
F1_c3= 0x03
F1_c4= 0x04
F1_c5= 0x05
F1_c6= 0x06
F1_c7= 0x07
F1_c8= 0x08
F1_c9= 0x09
F2_c1= 0x07
F2_c2= 0x08
F2_c3= 0x09
F2_c4= 0x10
F2_c5= 0x11
F2_c6=0x12
F2_c7= 0x11
F2_c8= 0x11
F2_c9= 0x11
F3_c1=0x06
F3_c2=0x07
F3_c3=0x08
F3_c4=0x09
F3_c5=0x10
F3_c6=0x11
F3_c7= 0x11
F3_c8= 0x11
F3_c9= 0x11
F4_c1=0x06
F4_c2=0x07
F4_c3=0x08
F4_c4=0x09
F4_c5=0x10
F4_c6=0x11
F4_c7= 0x11
F4_c8= 0x11
F4_c9= 0x11
F5_c1=0x06
F5_c2=0x07
F5_c3=0x08
F5_c4=0x09
F5_c5=0x10
F5_c6=0x11
F5_c7= 0x11
F5_c8= 0x11
F5_c9= 0x11
F6_c1=0x06
F6_c2=0x07
F6_c3=0x08
F6_c4=0x09
F6_c5=0x10
F6_c6=0x11
F6_c7= 0x11
F6_c8= 0x11
F6_c9= 0x11






blanc=0xFF
bleu=0xF1 # poids faible couleur, poids fort  tous les segments allume
vert=0xF2# segment du haut = 1 (0x10), segment de droite = 2 (0x20) 
rouge=0xF4# segment du bas = 3 (0x40), segment de gauche = 4 (0x80)
jaune=0xF6# jaune -- > rouge et vert
magenta=0xF5# magenta --> rouge et bleu
cyan=0xF3# cyan --> vert et bleu


Face1=[0,0,0,0,0,0,0,0,0,0]
Face2=[0,0,0,0,0,0,0,0,0,0]
Face3=[0,0,0,0,0,0,0,0,0,0]
Face4=[0,0,0,0,0,0,0,0,0,0]
Face5=[0,0,0,0,0,0,0,0,0,0]
Face6=[0,0,0,0,0,0,0,0,0,0]
Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
Tabvictoire[0]=0
Tabvictoire[1]=0
Tabvictoire[2]=0
Tabvictoire[3]=0
Tabvictoire[4]=0
Tabvictoire[5]=0
Tabvictoire[6]=0
Tabvictoire[7]=0
Tabvictoire[8]=0
Tabvictoire[9]=0



def envoiI2c(valeur,adresse):
    bus.write_byte(adresse,valeur)


def face1rouge():
    i=0
    while(i<9):
		envoiI2c(rouge,Face1[i])
		i += 1



def face2rouge():
    i=0
    while(i<9):
        envoiI2c(rouge,Face2[i])
        i += 1


def face3rouge():
    i=0
    while(i<9):
        envoiI2c(rouge,Face3[i])
        i += 1
 



def face4rouge():
    i=0
    while(i<9):
        envoiI2c(rouge,Face4[i])
        i += 1
 


def face5rouge():
    i=0
    while(i<9):
        envoiI2c(rouge,Face5[i])
        i += 1
 


def face6rouge():
    i=0
    while(i<9):
        envoiI2c(rouge,Face6[i])
        i += 1



def face1bleu():
    i=0
    while(i<9):
        envoiI2c(bleu,Face1[i])
        i += 1


def face2bleu():
    i=0
    while(i<9):
		envoiI2c(bleu,Face2[i])
		i += 1


def face3bleu():
    i=0
    while(i<9):
        envoiI2c(bleu,Face3[i])
        i += 1


def face4bleu():
    i=0
    while(i<9):
        envoiI2c(bleu,Face4[i])
		i += 1


def face5bleu():
    i=0
    while(i<9):
		envoiI2c(bleu,Face5[i])
		i += 1


def face6bleu():
    i=0
    while(i<9):
        envoiI2c(bleu,Face6[i])
		i += 1



def face1vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face1[i])



def face2vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face2[i])


def face3vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face3[i])



def face4vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face4[i])


def face5vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face5[i])


def face6vert():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(vert,Face6[i])


def face1blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face1[i])


def face2blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face2[i])


def face3blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face3[i])


def face4blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face4[i])


def face5blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face5[i])


def face6blanc():
    i=0
    while(i<9):
		i += 1   
		envoiI2c(blanc,Face6[i])




def remplissage_tableau():
    Face1[1] = F1_c1
    Face1[2] = F1_c2
    Face1[3] = F1_c3
    Face1[4] = F1_c4
    Face1[5] = F1_c5
    Face1[6] = F1_c6
    Face1[7] = F1_c7
    Face1[8] = F1_c8
    Face1[9] = F1_c9
  


    
    Face2[1] = F2_c1
    Face2[2] = F2_c2
    Face2[3] = F2_c3
    Face2[4] = F2_c4
    Face2[5] = F2_c5
    Face2[6] = F2_c6
    Face2[7] = F2_c7
    Face2[8] = F2_c8
    Face3[9] = F2_c9

    Face3[1] = F3_c1
    Face3[2] = F3_c2
    Face3[3] = F3_c3
    Face3[4] = F3_c4
    Face3[5] = F3_c5
    Face3[6] = F3_c6
    Face3[7] = F3_c7
    Face3[8] = F3_c8
    Face3[9] = F3_c9

    Face4[1] = F4_c1
    Face4[2] = F4_c2
    Face4[3] = F4_c3
    Face4[4] = F4_c4
    Face4[5] = F4_c5
    Face4[6] = F4_c6
    Face4[7] = F4_c7
    Face4[8] = F4_c8
    Face4[9] = F4_c9

    Face5[1] = F5_c1
    Face5[2] = F5_c2
    Face5[3] = F5_c3
    Face5[4] = F5_c4
    Face5[5] = F5_c5
    Face5[6] = F5_c6
    Face5[7] = F5_c7
    Face5[8] = F5_c8
    Face5[9] = F5_c9








    Face6[1] = F6_c1
    Face6[2] = F6_c2
    Face6[3] = F6_c3
    Face6[4] = F6_c4
    Face6[5] = F6_c5
    Face6[6] = F6_c6
    Face6[7] = F6_c7
    Face6[8] = F6_c8
    Face6[9] = F6_c9

















def animation_1case() :

    envoiI2c(rouge, F1_c1)
    print("rouge")
    time.sleep(3)
    envoiI2c(vert, F1_c1)
    print("vert")
    time.sleep(3)
    envoiI2c(bleu, F1_c1)
    print("bleu") 
    time.sleep(3)
    envoiI2c(vert, F1_c1)
    print("vert")
    time.sleep(3)
    envoiI2c(bleu, F1_c1)
    print("bleu")
    time.sleep(3)
    envoiI2c(rouge, F1_c1)
    print("rouge")
    time.sleep(1)

















def animation_iut(): 
    envoiI2c(rouge, F1_c2)
    time.sleep(1)
    envoiI2c(rouge, F1_c5)
    time.sleep(1)
    envoiI2c(rouge, F1_c8)
    time.sleep(1)
    envoiI2c(bleu, F2_c7)
    time.sleep(1)
    envoiI2c(bleu, F2_c4)
    time.sleep(1)
    envoiI2c(bleu, F2_c1)
    time.sleep(1)
    envoiI2c(bleu, F2_c2)
    time.sleep(1)
    envoiI2c(bleu, F2_c3)
    time.sleep(1)
    envoiI2c(bleu, F2_c6)
    time.sleep(1)
    envoiI2c(bleu, F2_c9)
    time.sleep(1)
    envoiI2c(vert, F3_c2)
    time.sleep(1)
    envoiI2c(vert, F3_c5)
    time.sleep(1)
    envoiI2c(vert, F3_c8)
    time.sleep(1)
    envoiI2c(vert, F3_c7)
    time.sleep(1)
    envoiI2c(vert, F3_c9)
    time.sleep(1)
    envoiI2c(rouge, F4_c4)
    time.sleep(1)
    envoiI2c(rouge, F4_c8)
    time.sleep(1)
    envoiI2c(rouge, F4_c5)
    time.sleep(1)
    envoiI2c(rouge, F4_c2)
    time.sleep(1)
    face5bleu() #face en haut et en bas en couleur 
    face6vert()









def morpion(): 
    choixcouleur=0
    valeurcouleur1=0 
    valeurcouleur2=0
    Case=0
    choix1=[0,0,0,0,0]
    choix2=[0,0,0,0,0]
    global Tabvictoire
    while(1):
        choixcouleur= input("Joueur 1 saisissez une couleur:") 
        choixcouleur=int(choixcouleur)
        if (choixcouleur == 1): # premier joueur choisit sa couleur
            valeurcouleur1 = bleu
            print("Joueur 1 Bleu  ",valeurcouleur1)
        elif(choixcouleur == 2):
			valeurcouleur1 = vert
			print("Joueur 1 vert  ",valeurcouleur1)
        elif(choixcouleur == 3):
            valeurcouleur1 = rouge
            print("Joueur 1 rouge  ",valeurcouleur1)
        elif(choixcouleur == 4):
            valeurcouleur1 = jaune
            print("Joueur 1 jaune  ",valeurcouleur1)
        elif(choixcouleur == 5):
            valeurcouleur1 = magenta
            print("Joueur 1 magenta  ",valeurcouleur1)
        elif(choixcouleur == 6):
            valeurcouleur1 = cyan
            print("Joueur 1 cyan  ",valeurcouleur1)
     


        choixcouleur=input("Joueur 2 saisissez une couleur:") 
        choixcouleur=int(choixcouleur)




        if (choixcouleur == 1 and valeurcouleur1 != bleu):
            valeurcouleur2 = bleu
            print("Joueur 2 Bleu  ",valeurcouleur2)

        elif(choixcouleur == 2 and valeurcouleur1 != vert):
            valeurcouleur2 = vert
            print("Joueur 2 vert  ",valeurcouleur2)

        elif(choixcouleur == 3 and valeurcouleur1 != rouge):
            valeurcouleur2 = rouge
            print("Joueur 2 rouge  ",valeurcouleur2)
        
        elif(choixcouleur == 4 and valeurcouleur1 != jaune):
            valeurcouleur1 = jaune
            print("Joueur 2 jaune  ",valeurcouleur1)
        elif(choixcouleur == 5 and valeurcouleur1 != magenta):
            valeurcouleur1 = magenta
            print("Joueur 2 magenta  ",valeurcouleur1)
        elif(choixcouleur == 6 and valeurcouleur1 != cyan):
            valeurcouleur1 = cyan
            print("Joueur 2 cyan  ",valeurcouleur1)    

        else:
            while valeurcouleur1 != valeurcouleur2 :
                choixcouleur=input("Joueur 2 saisissez une couleur differente du joueur1:")
                choixcouleur=int(choixcouleur)
                if(choixcouleur==1 and valeurcouleur1!=bleu):
               
                    valeurcouleur2=bleu
                    print("Joueur 2 Bleu  ",valeurcouleur2)
                    break
 
                elif(choixcouleur==2 and valeurcouleur1!=vert):
               
                    valeurcouleur2=vert
                    print("Joueur 2 vert  ",valeurcouleur2)
                    break
 
                elif(choixcouleur==3 and valeurcouleur1!=rouge):
                
                    valeurcouleur2=rouge
                    print("Joueur 2 rouge  ",valeurcouleur2)
                    break
                elif(choixcouleur == 4 and valeurcouleur1 != jaune):
                    valeurcouleur2 = jaune
                    print("Joueur 2 jaune  ",valeurcouleur2)
                    break
                elif(choixcouleur == 5 and valeurcouleur1 != magenta):
                    valeurcouleur2 = magenta
                    print("Joueur 2 magenta  ",valeurcouleur2)
                    break
                elif(choixcouleur == 6 and valeurcouleur1 != cyan):
                    valeurcouleur2 = cyan
                    print("Joueur 2 cyan  ",valeurcouleur2)
                    break


        Case=input("Saisissez une case:")   #Sélection de la case 
        Case=int(Case)
        choix1[0] = Case
        Tabvictoire[Case] = 1
        print("Joueur 1  ",Case,Tabvictoire[Case],valeurcouleur1,Face1[Case])
        envoiI2c(valeurcouleur1, Face1[Case])

        Case=input("Saisissez une case:") 
        Case=int(Case)
        choix2[0] = Case
        Tabvictoire[Case] = 2
        print("Joueur 2  ",Case,Tabvictoire[Case],valeurcouleur2,Face1[Case])
        envoiI2c(valeurcouleur2, Face1[Case])

        Case=input("Saisissez une case:") 
        Case=int(Case)
        choix1[1] = Case
        Tabvictoire[Case] = 1
        print("Joueur 1  ",Case,Tabvictoire[Case],valeurcouleur1,Face1[Case])
        envoiI2c(valeurcouleur1, Face1[Case])


        Case=input("Saisissez une case:") 
        Case=int(Case)
        choix2[1] = Case
        Tabvictoire[Case] = 2
        print("Joueur 2  ",Case,Tabvictoire[Case],valeurcouleur2,Face1[Case])
        envoiI2c(valeurcouleur2, Face1[Case])


        Case=input("Saisissez une case:") 
        Case=int(Case)
        choix1[2] = Case
        Tabvictoire[Case] = 1
        print("Joueur 1  ",Case,Tabvictoire[Case],valeurcouleur1,Face1[Case])
        envoiI2c(valeurcouleur1, Face1[Case])

    

        v=testvictoire()
        if (v==1):
		
            choix1=[0,0,0,0,0]
            choix2=[0,0,0,0,0]
            
            print("Joueur 1 WIN")
            animation1()
    
        else :
		
            Case=input("Saisissez une case:") 
            Case=int(Case)
            choix2[2] = Case
            Tabvictoire[Case] = 2
            envoiI2c(valeurcouleur2, Face1[Case])
            print("Joueur 2  ",Case,Tabvictoire[Case],valeurcouleur2,Face1[Case])
            v=testvictoire()
            if (v == 2):
			
                    choix1=[0,0,0,0,0]
                    choix2=[0,0,0,0,0]
                    Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
                    animation2() #en python mise à 0 d’un tab 
                    print("Joueur 2 WIN")




            else:
			
				Case=input("Saisissez une case:") 
				Case=int(Case)
				choix1[3]=Case
				Tabvictoire[Case]=1
				print("Joueur 1  ",Case,Tabvictoire[Case],valeurcouleur1,Face1[Case])
				envoiI2c(valeurcouleur1,Face1[Case])
				v=testvictoire()
				if(v == 1):
				
							choix1=[0,0,0,0,0]
							choix2=[0,0,0,0,0]
							Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
							animation1()
							print("Joueur 1 WIN")
				else:
				
							Case=input("Saisissez une case:") 
							Case=int(Case)
							choix2[3]=Case
							Tabvictoire[Case]=2
							print("Joueur 2  ",Case,Tabvictoire[Case],valeurcouleur2,Face1[Case])
							envoiI2c(valeurcouleur2,Face1[Case])
							v=testvictoire()
							if(v==2):
							
									choix1=[0,0,0,0,0]
									choix2=[0,0,0,0,0]
									Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
									animation2() #en python mise à 0 d’un tab 
									print("Joueur 2 WIN")
							else:
							
									Case=input("Saisissez une case:")    #match nul maybe 
									Case=int(Case)
									choix1[4]=Case
									Tabvictoire[Case]=1
									print("Joueur 1  ",Case,Tabvictoire[Case],valeurcouleur1,Face1[Case])
									envoiI2c(valeurcouleur1,Face1[Case])
									v=testvictoire()
									if(v==1):
									
											choix1=[0,0,0,0,0]
											choix2=[0,0,0,0,0]
											Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
											animation1()
											print("Joueur 1 WIN")
									else:
									
											egalite()
											choix1=[0,0,0,0,0]
											choix2=[0,0,0,0,0]
											Tabvictoire=[0,0,0,0,0,0,0,0,0,0]
											print("egalite")
											egalite()
 
	replay=input("Voulez vous rejouer? :")
	replay=int(replay)
	if(replay== 0):
            break
	elif(replay==1):
            print("Bonne partie")
            egalite() #sers a remettre en blanc toute les cases 
 


def testvictoire(): 
    var = 0
    global Tabvictoire
    print("Joueur 1  ",Tabvictoire[1])
    
    if Tabvictoire[1]==1 and Tabvictoire[5]==1 and Tabvictoire[9]==1 :
        var=1

    elif Tabvictoire[1] == 1  and  Tabvictoire[4] == 1  and  Tabvictoire[7] == 1  :
        var = 1

    elif  Tabvictoire[1] == 1  and  Tabvictoire[2] == 1  and Tabvictoire[3] == 1  :
        var=1

    elif  Tabvictoire[2] == 1  and  Tabvictoire[5] == 1  and Tabvictoire[8] == 1  :
        var=1

    elif  Tabvictoire[3] == 1  and  Tabvictoire[6] == 1  and Tabvictoire[9] == 1  :
        var=1


    elif Tabvictoire[3] == 1  and  Tabvictoire[5] == 1  and Tabvictoire[7] == 1  :
        var=1


    elif  Tabvictoire[4] == 1  and  Tabvictoire[5] == 1  and Tabvictoire[6] == 1  :
        var=1


    elif  Tabvictoire[7] == 1  and  Tabvictoire[8] == 1  and Tabvictoire[9] == 1  :
        var=1


    elif  Tabvictoire[1] == 2  and  Tabvictoire[5] == 2  and  Tabvictoire[9] == 2  :
        var = 2


    elif  Tabvictoire[1] == 2  and  Tabvictoire[4] == 2  and  Tabvictoire[7] == 2  :
        var = 2


    elif  Tabvictoire[1] == 2  and  Tabvictoire[2] == 2  and  Tabvictoire[3] == 2  :
        var = 2


    elif  Tabvictoire[2] == 2  and  Tabvictoire[5] == 2  and  Tabvictoire[8] == 2  :
        var = 2


    elif  Tabvictoire[3] == 2  and  Tabvictoire[6] == 2  and  Tabvictoire[9] == 2  :
        var = 2


    elif  Tabvictoire[3] == 2  and  Tabvictoire[5] == 2  and  Tabvictoire[7] == 2  :
        var = 2


    elif  Tabvictoire[4] == 2  and  Tabvictoire[5] == 2  and  Tabvictoire[6] == 2  :
        var = 2


    elif  Tabvictoire[7] == 2  and  Tabvictoire[8] == 2  and  Tabvictoire[9] == 2  :
        var = 2


    return var













def egalite ():

    face1blanc()
    face1blanc()
    face1blanc()
    face1blanc()
    face1blanc()
    face1blanc()




def animation1(): # ecriture de 1 avec les segments des blocs lors d’une victoire du j1

    envoiI2c(rouge, F1_c4)
    time.sleep(1)
    envoiI2c(rouge, F1_c8)
    time.sleep(1)
    envoiI2c(rouge, F1_c5)
    time.sleep(1)
    envoiI2c(rouge, F1_c2)
    time.sleep(1)

    envoiI2c(rouge, F2_c4)
    time.sleep(1)
    envoiI2c(rouge, F2_c8)
    time.sleep(1)
    envoiI2c(rouge, F2_c5)
    time.sleep(1)
    envoiI2c(rouge, F2_c2)
    time.sleep(1)

    envoiI2c(rouge, F3_c4)
    time.sleep(1)
    envoiI2c(rouge, F3_c8)
    time.sleep(1)
    envoiI2c(rouge, F3_c5)
    time.sleep(1)
    envoiI2c(rouge, F3_c2)
    time.sleep(1)

    envoiI2c(rouge, F4_c4)
    time.sleep(1)
    envoiI2c(rouge, F4_c8)
    time.sleep(1)
    envoiI2c(rouge, F4_c5)
    time.sleep(1)
    envoiI2c(rouge, F4_c2)
    time.sleep(1)

    envoiI2c(rouge, F5_c4)
    time.sleep(1)
    envoiI2c(rouge, F5_c8)
    time.sleep(1)
    envoiI2c(rouge, F5_c5)
    time.sleep(1)
    envoiI2c(rouge, F5_c2)
    time.sleep(1)

    envoiI2c(rouge, F6_c4)
    time.sleep(1)
    envoiI2c(rouge, F6_c8)
    time.sleep(1)
    envoiI2c(rouge, F6_c5)
    time.sleep(1)
    envoiI2c(rouge, F6_c2)
    time.sleep(1)




def animation2(): # ecriture de 2 avec les segments des blocs lors d’une victoire du j2

    envoiI2c(0x36, F1_c9) #jaune sur le segment du bas
    time.sleep(1)
    envoiI2c(0x36, F1_c8)
    time.sleep(1)
    envoiI2c(0x36, F1_c7)
    time.sleep(1)
    envoiI2c(0x26, F1_c6) #jaune sur le segment de droite
    time.sleep(1)
    envoiI2c(0x36, F1_c5)
    time.sleep(1)
    envoiI2c(0x46, F1_c4)
    time.sleep(1)
    envoiI2c(0x36, F1_c3)
    time.sleep(1)
    envoiI2c(0x36, F1_c2)
    time.sleep(1)
    envoiI2c(0x36, F1_c1)


    envoiI2c(0x36, F2_c9)
    time.sleep(1)
    envoiI2c(0x36, F2_c8)
    time.sleep(1)
    envoiI2c(0x36, F2_c7)
    time.sleep(1)
    envoiI2c(0x26, F2_c6)
    time.sleep(1)
    envoiI2c(0x36, F2_c5)
    time.sleep(1)
    envoiI2c(0x46, F2_c4)
    time.sleep(1)
    envoiI2c(0x36, F2_c3)
    time.sleep(1)
    envoiI2c(0x36, F2_c2)
    time.sleep(1)
    envoiI2c(0x36, F2_c1)



    envoiI2c(0x36, F3_c9)
    time.sleep(1)
    envoiI2c(0x36, F3_c8)
    time.sleep(1)
    envoiI2c(0x36, F3_c7)
    time.sleep(1)
    envoiI2c(0x26, F3_c6)
    time.sleep(1)
    envoiI2c(0x36, F3_c5)
    time.sleep(1)
    envoiI2c(0x46, F3_c4)
    time.sleep(1)
    envoiI2c(0x36, F3_c3)
    time.sleep(1)
    envoiI2c(0x36, F3_c2)
    time.sleep(1)
    envoiI2c(0x36, F3_c1)


    envoiI2c(0x36, F4_c9)
    time.sleep(1)
    envoiI2c(0x36, F4_c8)
    time.sleep(1)
    envoiI2c(0x36, F4_c7)
    time.sleep(1)
    envoiI2c(0x26, F4_c6)
    time.sleep(1)
    envoiI2c(0x36, F4_c5)
    time.sleep(1)
    envoiI2c(0x46, F4_c4)
    time.sleep(1)
    envoiI2c(0x36, F4_c3)
    time.sleep(1)
    envoiI2c(0x36, F4_c2)
    time.sleep(1)
    envoiI2c(0x36, F4_c1)




    envoiI2c(0x36, F5_c9)
    time.sleep(1)
    envoiI2c(0x36, F5_c8)
    time.sleep(1)
    envoiI2c(0x36, F5_c7)
    time.sleep(1)
    envoiI2c(0x26, F5_c6)
    time.sleep(1)
    envoiI2c(0x36, F5_c5)
    time.sleep(1)
    envoiI2c(0x46, F5_c4)
    time.sleep(1)
    envoiI2c(0x36, F5_c3)
    time.sleep(1)
    envoiI2c(0x36, F5_c2)
    time.sleep(1)
    envoiI2c(0x36, F5_c1)




    envoiI2c(0x36, F6_c9)
    time.sleep(1)
    envoiI2c(0x36, F6_c8)
    time.sleep(1)
    envoiI2c(0x36, F6_c7)
    time.sleep(1)
    envoiI2c(0x26, F6_c6)
    time.sleep(1)
    envoiI2c(0x36, F6_c5)
    time.sleep(1)
    envoiI2c(0x46, F6_c4)
    time.sleep(1)
    envoiI2c(0x36, F6_c3)
    time.sleep(1)
    envoiI2c(0x36, F6_c2)
    time.sleep(1)
    envoiI2c(0x36, F6_c1)




#main


c_mode=0


remplissage_tableau()
c_mode=input("Saisissez un mode de jeu:") 
c_mode=int(c_mode)
if (c_mode == 1): #animation basique 1 case fille
	animation_1case()
 
elif(c_mode == 2): #animation basique toute les case fille
 animation_iut()
 
elif(c_mode == 3): #morpion
	morpion()
 
#elif(c_mode == 4)#rubiks cube:
