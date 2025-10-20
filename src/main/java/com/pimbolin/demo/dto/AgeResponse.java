package com.pimbolin.demo.dto;

public class AgeResponse {
    private String nomeCompleto;
    private int anos;
    private int meses;
    private int dias;

    public AgeResponse(String nomeCompleto, int anos, int meses, int dias) {
        this.nomeCompleto = nomeCompleto;
        this.anos = anos;
        this.meses = meses;
        this.dias = dias;
    }

    public String getNomeCompleto() { return nomeCompleto; }
    public int getAnos() { return anos; }
    public int getMeses() { return meses; }
    public int getDias() { return dias; }
}
