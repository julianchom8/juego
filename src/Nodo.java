
public class Nodo {

    private int x;
    private int y;
    private int codigo;
    Nodo sig;

    public int getX() {
        return x;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setX(int x) {  //pongo el valor de  mi x  
        this.x = x;
    }

    public int getY() {  //returno el  valor  que tengo de  mi  y 
        return y;
    }

    public void setY(int y) { //le pasa  los  valores  que  recibo  como argumento  para  ponerlo en el this
        this.y = y;
    }
}
