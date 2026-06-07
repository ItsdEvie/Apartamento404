package Investigacao;

public class Aresta<TIPO> {
    //peso da conexão
    private Double peso;
    //origem
    private Vertice<TIPO> inicio;
    //destino
    private Vertice<TIPO> fim;

    public Aresta(Double peso, Vertice<TIPO> inicio, Vertice<TIPO> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    //Retorna para qual caminho leva
    public Vertice<TIPO> getFim() {
        return this.fim;
    }
}