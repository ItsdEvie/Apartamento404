package Investigacao;

import java.util.ArrayList;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices = new ArrayList();

    public void adicionarVertice(TIPO comodo, String pista) {
        Vertice<TIPO> novo = new Vertice(comodo, pista);
        this.vertices.add(novo);
    }

    public void conectarComodos(TIPO d1, TIPO d2, boolean bidirecional) {
        Vertice<TIPO> v1 = this.getVertice(d1);
        Vertice<TIPO> v2 = this.getVertice(d2);

        v1.adicionarArestaSaida(new Aresta(1.0, v1, v2));

        if (bidirecional) {
            v2.adicionarArestaSaida(new Aresta(1.0, v2, v1));
        }
    }

    public Vertice<TIPO> getVertice(TIPO comodo) {
        for(Vertice<TIPO> v : this.vertices) {
            if (v.getComodo().equals(comodo)) {
                return v;
            }
        }

        return null;
    }
}
