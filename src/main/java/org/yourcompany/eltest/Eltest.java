package org.yourcompany.eltest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author erict
 */
public class Eltest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pregunta> preguntes = inicialitzarPreguntes();
        Test test = new Test(preguntes);
        boolean acabar = false;

        while (!acabar) {
            int numAparenca = test.getNumeroPregunta() + 1; 
            String enunciat = test.getEnunciatPreguntaActual();
            String[] respostes = test.getRespostesPreguntaActual();

            System.out.print("pregunta " + numAparenca + "." + enunciat + " ");
            
            for (int i = 0; i < respostes.length; i++) {
                System.out.print((i + 1) + "." + respostes[i] + " ");
            }
            System.out.println();            
            System.out.println("Tria una opció: (1)Endarrera - (2) Respondre - (3) Endavant - (4) Finalitzar ");
            int opcioMenu = scanner.nextInt();

            if (opcioMenu == 1) {
                test.anarEndarrera();
                
            } else if (opcioMenu == 2) {
                int respostaUsuari = scanner.nextInt();
                System.out.println("La teva resposta és: " + respostaUsuari);
                
                test.respondre(respostaUsuari);
                test.anarEndavant();
                
            } else if (opcioMenu == 3) {
                test.anarEndavant();
                
            } else if (opcioMenu == 4) {
                acabar = true;
                
            } else {
                System.out.println("Opció no vàlida.");
            }
        }
        System.out.println("Has aconseguit un " + test.solucionarTest());    
    }
    
    public static ArrayList<Pregunta> inicialitzarPreguntes() {
        ArrayList<Pregunta> preguntes = new ArrayList<>();
        
        preguntes.add(new Pregunta("Qui va pintar el Guernica",
                new String[]{"Velàzquez", "Goya", "Picasso"}, 2));
        preguntes.add(new Pregunta("Qui va escriure Alicia al país de les meravelles",
                new String[]{"Grimm", "Stevenson", "Carrol"}, 2));
        preguntes.add(new Pregunta("Quina és la magnitud que relaciona espai i temps",
                new String[]{"velocitat", "temperatura", "pes"}, 0));
        preguntes.add(new Pregunta("Si el radi d'una circumferència és 4, el seu diàmetre és",
                new String[]{"4", "8", "12", "14"}, 1));
        preguntes.add(new Pregunta("Quants segons té 1 hora",
                new String[]{"420", "760", "3600"}, 2));
        preguntes.add(new Pregunta("Quin no és un llenguatge de programació",
                new String[]{"java", "php", "samsung"}, 2));
        preguntes.add(new Pregunta("Dins un termòmetre hi trobem",
                new String[]{"aigua", "aigua amb gas", "mercuri"}, 2));
        preguntes.add(new Pregunta("L'Acropolis es troba a",
                new String[]{"Atenes", "Roma", "París"}, 0));
        preguntes.add(new Pregunta("L'element químic amb símbol Fe és ",
                new String[]{"Estronci", "Ferro", "Feril·li"}, 1));
        preguntes.add(new Pregunta("La capital d'Estats Units és",
                new String[]{"Georgetown", "New York", "Washington"}, 2));
        return preguntes;
    }
}