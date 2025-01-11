package org.targetteste;

public class FaturamentoDados {

    private int dia;
    private double valor;

    public FaturamentoDados(int dia, double valor){
        this.dia = dia;
        this.valor = valor;
    }

    public void setDia(int dia){
        this.dia = dia;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getDia(){
        return this.dia;
    }

    public double getValor(){
        return this.valor;
    }
}
