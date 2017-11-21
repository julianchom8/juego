 public class ListaSimple {

    Nodo lista;  //tengo un valor de  tipo lista  

    public Nodo getLista() { //obtiene  la  lista    
        return lista;
    }

    public void setLista(Nodo lista) {  //pone  la lista 
        this.lista = lista;
    }

    void agregarFinal(Nodo n) {  //agrega al  fina  
        Nodo aux = lista;
        if (lista != null) {
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = n;
        } else {
            n.sig = lista;
            lista = n;
        }
    }

    int obtenerCodigo() {
        int c = 0;
        Nodo aux = lista;
        if (lista == null) {
        } else {
            while (aux != null) {
                c++;
                aux = aux.sig;
            }
        }
        return c + 1;
    }
}
