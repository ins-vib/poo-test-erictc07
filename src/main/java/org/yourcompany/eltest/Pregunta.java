package org.yourcompany.eltest;

public class Pregunta {
    private String enunciat;
    private String[] respostes;
    private int correcta;

    public Pregunta(String enunciat, String[] respostes, int correcta) {
        this.enunciat = enunciat;
        this.respostes = respostes;
        this.correcta = correcta;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public String[] getRespostes() {
        return respostes;
    }

    public int getCorrecta() {
        return correcta;
    }

}
