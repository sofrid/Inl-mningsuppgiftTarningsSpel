package com.example.tarningsspelvg;
//Tärningsspel, välj antal spelare och kast, få tillbaka resultat, vinnare och highscore.

import java.util.Scanner;

public class TarningsspelVG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  //Scanner så att spela-/arna kan mata in värden
        int vinnare=0;                          //Variabel för att kunna göra highscore
        int nyttSpel;                           //Variabel för att kunna spela igen utan att starta om (while do-loopen)
        int highScore[]= new int [3];           //Array för att spara (och sortera) vinnarens värden till highscore

        do {                                    //Loopen som startar spelet
            String outputText ="";              //Variabel för att mata ut text till spelarna
            int antalKast;                      //Variabel för hur många kast varje spelare ska göra
            int antalSidor = 6;                 //Variabel för att definiera att tärningen har sex sidor
            int antalSpelare;                   //Variabel för antalet spelare

            System.out.println("Välkommen till Tärningsspelet!");       //Spelet hälsar välkommen
            System.out.println("Här spelar ni emot varandra.");
            System.out.print("Välj antal spelare (1-5): ");             //Spelaren får mata in antal spelare och kast
            antalSpelare = scan.nextInt();
            System.out.print("Välj hur många kast som varje spelare ska göra: ");
            antalKast = scan.nextInt();

            int kastTotalt = 0;                         //Variabel för varje kasts värde
            int summaSpelare[] = new int[6];            //Array för varje spelares resultat efter alla dennes kast

            for (int i=1; i<=antalSpelare; i++){                            //Yttre-loop körs en gång för varje spelare
                System.out.println("Spelare: " + i);
                for(int j=1; j<= antalKast; j++){                           //Innre loop körs för varje kast
                    kastTotalt = (int) (1 + antalSidor * Math.random());
                    summaSpelare[i]+=kastTotalt;
                    System.out.println("Spelare " + i + " Kast: " + j + " är " + kastTotalt);
                }
                System.out.println("Totalsumman för Spelare " + i + " är " + summaSpelare[i] );//Spelet visar resultatet
            }

            /*If-satser för att jämföra resultat mellan varje spelare så en vinnare kan utses och vinnarens resultat
            sparas till Arrayen highScore för att kunna visas efter spelet.*/
            if (summaSpelare[1] > summaSpelare[2] && summaSpelare[1] > summaSpelare[3] &&
                    summaSpelare[1] > summaSpelare[4] && summaSpelare[1] > summaSpelare[5]) {
                outputText += "Spelare 1 vann!";
                vinnare = summaSpelare[1];
            }
            else if (summaSpelare[1] < summaSpelare[2] && summaSpelare[2] > summaSpelare[3] &&
                    summaSpelare[2] > summaSpelare[4] && summaSpelare[2] > summaSpelare[5]) {
                outputText += "Spelare 2 vann!";
                vinnare = summaSpelare[2];
            }
            else if (summaSpelare[3] > summaSpelare[1] && summaSpelare[3] > summaSpelare[2] &&
                    summaSpelare[3] > summaSpelare[4] && summaSpelare[3] > summaSpelare[5]) {
                outputText += "Spelare 3 vann!";
                vinnare = summaSpelare[3];
            }
            else if (summaSpelare[4] > summaSpelare[1] && summaSpelare[4] > summaSpelare[2] &&
                    summaSpelare[4] > summaSpelare[3] && summaSpelare[4] > summaSpelare[5]) {
                outputText += "Spelare 4 vann!";
                vinnare = summaSpelare[4];
            }
            else if (summaSpelare[5] > summaSpelare[1] && summaSpelare[5] > summaSpelare[2] &&
                    summaSpelare[5] > summaSpelare[3] && summaSpelare[5] > summaSpelare[4]) {
                outputText += "Spelare 5 vann!";
                vinnare = summaSpelare[5];
            }
            else {
                outputText += "Det blev lika mellan minst två spelare. Försök igen.";
                vinnare = 0;
            }
            if(vinnare > highScore[0]){  //Is-sats för att testa om vinnarens resultat kvalificerar för highscorelistan
                highScore[0] = vinnare;
            }
            sortera(highScore);         //Skickar efter metoden SortBubble för att sortera highscorelistan


            String textOutput="";       //Variabel för textutmatning senare i spelet

            for(int a = 0; a < highScore.length; a++){                  //For-loop som visar Arrayen highscore
                textOutput += "Highscore: " + highScore[a] + "\n";
            }

            System.out.println(textOutput);       //Texten som spelet matar ut från for-loopen för Arrayen highscore

            System.out.println(outputText);                             //Spelet matar ut slutresultatet av spelet
            System.out.println("Vill du spela igen? För JA svara 1");   //Ska spelet börja om måste man välja det
            nyttSpel = scan.nextInt();

        }while (nyttSpel==1);    //Om loopen är klar och spelarna inte vill fortsätta avslutas spelet annars körs det om

        System.out.println("Du har valt att avsluta spelet. Välkommen tillbaka!"); //Bekräftelse på att spelet avslutas
    }

    //Metod för att definiera variabler för och köra SortBubble så att Arrayen highscore sorteras och ordnas rätt
    static void sortera(int[] highScore){
        int m = highScore.length;
        for(int n = 1; n < m; n++){
        for(int a = m-1; a >= n; a--){
            if (highScore[a-1]>highScore[a]){
                    int intTemp = highScore[a-1];
                    highScore[a-1] = highScore[a];
                    highScore[a] = intTemp;
                }
            }
        }
    }
}