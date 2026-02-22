package org.yourcompany.eltest;

import java.util.ArrayList;

public class Test {
    private ArrayList<Pregunta> llistaPreguntes;
    private int[] respostesUsuari;
    private int preguntaActual;

    public Test(ArrayList<Pregunta> preguntes) {
        this.llistaPreguntes = preguntes;
        
        this.respostesUsuari = new int[preguntes.size()];
        for (int i = 0; i < respostesUsuari.length; i++) {
            respostesUsuari[i] = -1; 
        }
        this.preguntaActual = 0; 
    }


    public boolean anarEndavant() {
        if (preguntaActual < llistaPreguntes.size() - 1) {
            preguntaActual++;
            return true;
        }
        return false;
    }

    public boolean anarEndarrera() {
        if (preguntaActual > 0) {
            preguntaActual--;
            return true;
        }
        return false;
    }

    public void respondre(int resposta) {
        respostesUsuari[preguntaActual] = resposta;
    }

    public String getEnunciatPreguntaActual() {
        Pregunta preguntaQueToca = llistaPreguntes.get(preguntaActual);
        return preguntaQueToca.getEnunciat();
    }

    public String[] getRespostesPreguntaActual() {
        Pregunta preguntaQueToca = llistaPreguntes.get(preguntaActual);
        return preguntaQueToca.getRespostes();
    }

    public int getNumeroPregunta() {
        return preguntaActual;
    }
 
    public double solucionarTest() {
        double notaFinal = 0.0;
        double valorAcierto = 10.0 / llistaPreguntes.size();
        
        for (int i = 0; i < respostesUsuari.length; i++) {
            int respostaUsuari = respostesUsuari[i];
            
            if (respostaUsuari == -1) {
                continue; 
            }
            Pregunta preguntaActual = llistaPreguntes.get(i);
            
            if ((respostaUsuari - 1) == preguntaActual.getCorrecta()) {
                notaFinal = notaFinal + valorAcierto;
            } 
            else {
                int numeroRespostesPossibles = preguntaActual.getRespostes().length;
                double penalitzacio = valorAcierto / numeroRespostesPossibles;
                
                notaFinal = notaFinal - penalitzacio;
            }
        }
        
        return notaFinal;
    }
    
}
