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
        respostesUsuari[preguntaActual] = (resposta - 1); 
    }

    public String getEnunciatPreguntaActual() {
        return llistaPreguntes.get(preguntaActual).getEnunciat();
    }

    public String[] getRespostesPreguntaActual() {
        return llistaPreguntes.get(preguntaActual).getRespostes();
    }

    public int getNumeroPregunta() {
        return preguntaActual;
    }
 
    public double solucionarTest() {
        double notaFinal = 0.0;
        double valorAcierto = 10.0 / llistaPreguntes.size(); 
        
        for (int i = 0; i < llistaPreguntes.size(); i++) {
            int respostaUsuari = respostesUsuari[i];
            Pregunta pregunta = llistaPreguntes.get(i);
            
            if (respostaUsuari != -1) {
                if (respostaUsuari == pregunta.getCorrecta()) {
                    notaFinal += valorAcierto;
                } 
                else {
                    double penalitzacio = valorAcierto / pregunta.getRespostes().length;
                    notaFinal -= penalitzacio;
                }
            }
        }
        
        if (notaFinal < 0) {
            notaFinal = 0;
        }
        
        return notaFinal;
    }
}