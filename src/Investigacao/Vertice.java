package Investigacao;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO comodo;
    private String descricaoPista;
    //Lista de caminhos
    private ArrayList<Aresta<TIPO>> arestasSaida;

    public Vertice(TIPO valor, String descricaoPista) {
        this.comodo = valor;
        this.descricaoPista = descricaoPista;
        this.arestasSaida = new ArrayList();
    }

    public TIPO getComodo() {
        return this.comodo;
    }

    public String getDescricaoPista() {
        return this.descricaoPista;
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return this.arestasSaida;
    }
}