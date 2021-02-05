/*
 * File:   main4.c
 * Author: Ait Ettajer Haytham
 *
 * Created on 16 septembre 2016, 19:26
 */

// PIC16F886 Configuration Bit Settings

// 'C' source line config statements

#include <xc.h>

// #pragma config statements should precede project file includes.
// Use project enums instead of #define for ON and OFF.

// CONFIG1
#pragma config FOSC = INTRC_NOCLKOUT// Oscillator Selection bits (INTOSCIO oscillator: I/O function on RA6/OSC2/CLKOUT pin, I/O function on RA7/OSC1/CLKIN)
#pragma config WDTE = OFF       // Watchdog Timer Enable bit (WDT disabled and can be enabled by SWDTEN bit of the WDTCON register)
#pragma config PWRTE = OFF      // Power-up Timer Enable bit (PWRT disabled)
#pragma config MCLRE = ON       // RE3/MCLR pin function select bit (RE3/MCLR pin function is MCLR)
#pragma config CP = OFF         // Code Protection bit (Program memory code protection is disabled)
#pragma config CPD = OFF        // Data Code Protection bit (Data memory code protection is disabled)
#pragma config BOREN = ON       // Brown Out Reset Selection bits (BOR enabled)
#pragma config IESO = ON        // Internal External Switchover bit (Internal/External Switchover mode is enabled)
#pragma config FCMEN = ON       // Fail-Safe Clock Monitor Enabled bit (Fail-Safe Clock Monitor is enabled)
#pragma config LVP = OFF        // Low Voltage Programming Enable bit (RB3 pin has digital I/O, HV on MCLR must be used for programming)

// CONFIG2
#pragma config BOR4V = BOR21V   // Brown-out Reset Selection bit (Brown-out Reset set to 2.1V)
#pragma config WRT = OFF        // Flash Program Memory Self Write Enable bits (Write protection off)

#define D 13
#define RESET 0
#define TEST 1
#define ENVOIE 2
#define RECEP 3
#define FM 4
#define FD 5
#define TFD 6
#define RECHERCHE 7
#define HORLOGE 8
#define ADMIN 9
#define RS RC5
#define RW RC4
#define E RB7

unsigned char ETAT ;//@ 0x7C;
unsigned char PLUS=0;
unsigned char ECRAN=HORLOGE;
unsigned char texte[6]={"Coucou"};
unsigned char tailletexte[10]=6;
unsigned char i;// @ 0x76;
unsigned char j ;//@ 0x78;
unsigned char octet;// @ 0x79;
unsigned char cpt1s=0;
unsigned short cpt1ms=0;

unsigned char heure[3]={23,50,58};
unsigned char data[8] ;//@  0x20;
unsigned char id[8] ;//@ 0x29;
unsigned char card[8]={0xE6,0x5F,0x89,0xC0,0x00,0x00,0x00,0x03};

unsigned char test_recherche(unsigned char o);
unsigned char recherche(void);
unsigned char  validation ();
void led(unsigned char ok);
void horloge(void);
void clear();

void newcard(unsigned char * tab);
void reset_eeprom(void);
void write_tab_eeprom(unsigned char * tab,unsigned char longeur,unsigned char adresse);
void read_eeprom_tab(unsigned char * tab,unsigned char longeur,unsigned char adresse);
unsigned char eeprom_read(unsigned char address);
void eeprom_write(unsigned char address, unsigned char value);

void AttLCD(void);
void LCD_inst_wr(unsigned char inst);
unsigned char  LCD_inst_rd(void);
void LCD_data_wr(unsigned char inst);
unsigned char LCD_data_rd(void);
void inilcd2(void);
void crlcd1(void);
void crlcd2(void);
void clrlcd(void);
unsigned char putchar(unsigned char c);
void putnb (unsigned short Nb);
void putstring (unsigned char *TB, unsigned char Nb_TB);

void tempo1ms(unsigned char Nb);
void tempo1s(unsigned char Nb);


void main(void) {
    j=0;
    ETAT = RESET;
    PLUS=0;
    i=0;

    
    GIE=1; //Activation global des interrupt
    PEIE=1; //Activation des interrupt des peripherique ?
    TXIE=0;//Activation de l'interrupt TX liée a TXIF -----> ecriture
    RCIE=0;//Activation de l'interrupt RC liée a RCIF---> lecture
    TMR1IE=1;
    
    SYNC=0; // asynchrone mode
    BRGH=1;// high speed a verifier la difference
    BRG16=0;
    SPBRG=25;
    
    TX9=0; // mode 8 bits
    SPEN=1; // port RX/TX activer
            
    RX9=0;// 8 bits
    WUE=0;// normal
    
    CREN=1;// active le reception
    TXEN=1;// active l'emmission
    
    TMR1CS=0;
    TMR1GE=0;
    TMR1L=(-1000);
    TMR1H=(-1000)>>8;
    TMR1ON=1;
    
    TRISC0=0;//portA.1 en sortie diode rouge
    TRISC1=0;//portA.1 en sortie diodde verte
    TRISC2=0;//portA.1 en sortie  diode jaune
    
    TRISC5=0;// LCD : RS
    TRISC4=0;// LCD : R/W
    TRISB7=0; // LCD : E
    
    TRISB0=1;//port B.0 en entrée
    
    TRISA=0;
    ANSEL=0;
    
    ANS12=0;
    ANS10=0;
    
    RC0=0;
    RC1=0;
    RC2=0;
    E=1;
          tempo1ms(500);

      inilcd2();
      tempo1ms(500);
      crlcd2();
      putstring(texte,6);
      crlcd1();
while(1){
    RC2^=1;
    tempo1ms(200);
    putchar('o');
      /*
               switch(PLUS){
            case ADMIN:
                if(ETAT==TEST && (data[0]&0x02)){
                    if(!octet){
                    for(j=0;j<7;j++){
                        id[j]=data[j+1];
                    }
                    id[j]=RC3;
                    newcard(id);
                }
                    else{
                        eeprom_write(octet+7,RC3);
                    }
                    PLUS=0;

                break;
        }
               }*/
		
		switch(ECRAN){
			case HORLOGE:
                            clrlcd();
			ECRAN=0;
                        putnb(heure[0]);
                        putchar(':');
                        putnb(heure[1]);
                        putchar(':');
                        putnb(heure[2]);

			break;
		}
        
        
    /*
        
        
         //Sur RB0 se trouve le signal CTS du lecteur de carte
          switch(ETAT){
             case FD :
			 //d'apres le chronogramme de lecture de carte il faut envoyer une commande au lorsque CTS est a l'etat bas donc on attent un front descendant
                 i=0;
                 if(!RB0){

                     ETAT=ENVOIE;

                 }

                 break;
             case ENVOIE :
                 if(TXIF){
				 //lorsque l'obn peut envoyer, on envoie 'U' qui correspond a la demande de numero de carte
                    TXREG='U';
                    TXIF=0;
                    ETAT=FM;
                 }


                 break;
             case FM: //il faut attendre l'etat haut du CTS pour recevoir les octets
                 if(RB0){
                     ETAT=RECEP;

                 }
                 
                 break;



            case RECEP:
                 if(RCIF){
				 //si on a recu quelque chose on place l'octet dans la variable data
                    if(i<=7){
                       data[i]=RCREG;
                       i++;
                     }
                     
                         }
                   ETAT=TFD;

                 break;
             case TFD :
                 // on test si CTS est toujours a l'etat haut
                 if(!RB0){
						// si CTS est a l'etat bas on va lancer les test de numero de carte
                     ETAT=RECHERCHE;

                 }
                 else{
					//sinon on recommence a recevoir 
                     ETAT=RECEP;
                 }
                 break;
            case RECHERCHE:
                if(!(data[0]&0x02)){
                    ETAT=RESET;
                }
                else{
                octet=recherche();
                ETAT=TEST;
                }
               break;
             case TEST:
                 led(validation());
                 ETAT=RESET;
                 break;
                 
             case RESET:
                clear();
                ETAT=FD;
                break;
              
            
         }  */
               continue;

}
    }
    
void interrupt it(void){
    static unsigned short cpt;
        static unsigned short M;
    if(TMR1IF){
        TMR1ON=0;
        TMR1L=(-1000+TMR1L+D);
        TMR1H=(-1000+TMR1H+D)>>8;
        TMR1ON=1;
        TMR1IF=0;
        cpt++;
        cpt1ms++;
        if(cpt==1000){
            if(PLUS==ADMIN){
                RC2=~RC2;
            }
            if(!ECRAN){
			ECRAN=HORLOGE;
            }
            horloge();
            cpt=0;
            cpt1s++;
        }
    }
}







void clear(){
    i=0;
    for(j=0;j<8;j++){
        data[j]=0;
    }
    octet=0;

    RC0=0;
    RC1=0;
    if(PLUS!=ADMIN){
    RC2=0;
    }

}
unsigned char  validation (){
    unsigned char ok=1;
    if(octet==0){
	//ok=2 signifie que la carte est pas connu
        ok=2;
    }
    else if(eeprom_read(octet+7)==0){//apres les 7 octet d'adresse de carte se trouve un octet de droit
//ok=0 signifie que la carte est connue mais nest pas autoriser
        ok=0;
    }
    else if(eeprom_read(octet+7)==3){
        PLUS=ADMIN;
    }

    return ok;
}
void led(unsigned char ok){
    RC2=0;
    RC1=0;

    if(ok==1){

        RC1=1;//svert
    }
    if(ok==2){
        RC2=1;
        RC0=1;//rouge+orange
    }
    if(!ok){

        RC0=1;//rouge
    }
    tempo1s(5);
}


void write_tab_eeprom(unsigned char * tab,unsigned char longeur,unsigned char adresse){
    unsigned char p=0;
    for(p=0;p<longeur;p++){
        eeprom_write(adresse+p,tab[p]);
        cpt1ms=0;
        while(cpt1ms!=5);
    }
}
void read_eeprom_tab(unsigned char * tab,unsigned char longeur,unsigned char adresse){
    unsigned char p=0;
    for(p=0;p<longeur;p++){
        tab[p]=eeprom_read(adresse+p);
        tempo1ms(5);
}
}

unsigned char recherche(void){

    unsigned char o=1;
    unsigned retour=0;
	
    unsigned char nbcarteid=eeprom_read(0); // dans le premier octet de l'eeprom se trouve le nombre de carte enregistrer
	
    while(!retour){
     if(data[1]!=eeprom_read(o)){
	 //on test si le premier octet du message recu correspond au primer octet d'une des carte de l'eeprom
        o+=8;
        nbcarteid--;
    }
    else if(data[1]==eeprom_read(o)){
	// si c'est le cas on lance test_recherche qui test les autres octets
        if(test_recherche(o)){
		
            retour=1;
        }
        else{
            o+=8;
            nbcarteid--;
        }
    }
     if((o>=240)||nbcarteid==0){
         retour=1;
         o=0;
     }
    }

    
    
    return o;

}
unsigned char test_recherche(unsigned char o){
    unsigned char ok=1;
    for(j=0;j<7;j++){
        if(data[j+1]!= eeprom_read(o+j)){
            ok=0;
        }
    }
    return ok;
}
void newcard(unsigned char * tab){
    unsigned char nb;
    nb=eeprom_read(0)*8+1;
    write_tab_eeprom(tab,8,nb);
    nb=eeprom_read(0)+1;
    eeprom_write(0,nb);
}
void reset_eeprom(void){
    unsigned char f;
   for(f=1;f<255;f++){
        eeprom_write(f,0xFF);
    }
    eeprom_write(0,0x00);
     
}

void horloge(void){
    heure[2]++;
    if(heure[2]==60){
        heure[2]=0;
        heure[1]++;
    }
    if(heure[1]==60){
        heure[1]=0;
        heure[0]++;
    }
    if(heure[0]==24){
        heure[0]=0;
    }
    
}

void AttLCD(void){
   static unsigned char a=0 ;
    while(LCD_inst_rd() & 0x80){
        a++;
    }
}

void LCD_inst_wr(unsigned char inst){
    RS=0;
    RW=0;  
    PORTA=inst;	
    E=1;
    E=0;
}

unsigned char LCD_inst_rd(void){
    unsigned char cmd;
    PORTA=0;
    TRISA=1;
	E=1;
    RS=0;
    RW=1;
    E=0;
    E=1;
    cmd=PORTA;
	TRISA=0;
    return cmd;
}
void LCD_data_wr(unsigned char inst){
    TRISA=0;
    PORTA=0;
    RS=1;
    RW=0;
    PORTA=inst;
    E=1;  
    E=0;
    RS=0;
}
unsigned char  LCD_data_rd(void){
    TRISA=1;
    RC5=1;
    RC4=1;
    RB1=1;
    RB1=0;
    return PORTA;
}

void inilcd2(void){
    PORTA=0;
    tempo1ms(15);
    LCD_inst_wr(0x38);
    tempo1ms(15);
    LCD_inst_wr(0x38);
    tempo1ms(15);
    LCD_inst_wr(0x38);
    tempo1ms(15);
    LCD_inst_wr(0x38);
    tempo1ms(15);
    LCD_inst_wr(0x08);
tempo1ms(15);
LCD_inst_wr(0x01);
tempo1ms(15);
LCD_inst_wr(0x06);
tempo1ms(15);
LCD_inst_wr(0x0F);
tempo1ms(15);
}

void crlcd1(void){
AttLCD();
LCD_inst_wr(0x02);
    AttLCD();
    LCD_inst_wr(0x06);
}

void crlcd2(void){
   AttLCD();
    LCD_inst_wr(0x02);
    AttLCD();
    LCD_inst_wr(0xC0);
   AttLCD();
    LCD_inst_wr(0x06);
}

void clrlcd(void){
    AttLCD();
    LCD_inst_wr(0x00);
    AttLCD();
    LCD_inst_wr(0x01);
    AttLCD();
    LCD_inst_wr(0x06);
}


unsigned char putchar(unsigned char c){
    unsigned char Statut;
    do{
        Statut=LCD_inst_rd();
    }while(Statut & 0x80);
    
    if((Statut<0x10) || (0x40<=Statut) && (Statut<0x50));
    else{
        LCD_inst_wr(0x07);
        tempo1ms(250);
    }
    if(c!=0x10){
        LCD_data_wr(c);
    }
    else{
        LCD_data_wr(' ');
    }
}

void putnb (unsigned short Nb)
{
    unsigned char m;
    unsigned char dizaine=0;
 if(Nb>=100)
 {
     m=Nb/100;
     putchar(m+'0');
     Nb=Nb-(m*100);
     dizaine++;
 }
 if((Nb>=10)||dizaine)
 {
     m=Nb/10;
     putchar(m+'0');
     Nb=Nb-(m*10);
  }
   putchar(Nb+'0');
}

void putstring (unsigned char *TB, unsigned char Nb_TB)
{
    unsigned short i=0;
    for(i=0;i<Nb_TB;i++ )
    {
        putchar(TB[i]);
        AttLCD();
    }
}

void tempo1ms(unsigned char Nb){
    cpt1ms=0;
    while(cpt1ms<Nb);
}
void tempo1s(unsigned char Nb){
    cpt1s=0;
    while(cpt1s<Nb);
}
