
import java.awt.Color;  
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Panel extends JPanel implements KeyListener{

    int n = 80, m = 24; 
    JButton[][] btn = new JButton[n][m];
    JTextField t = new JTextField();
    JLabel label = new JLabel("Puntaje = 0");
 
     int CabezaX = 0;
    int CabezaY = 0;
    int manzanaX;
    int manzanaY;
    Mover mov = new Mover();  //se pone  instancia  de mover 
    ListaSimple lista = new ListaSimple(); // se crea una  lista  simple para EL incremento
    int puntos = 0;  
    String marcha = "derecha";

    Panel() {
      
        label.setBounds(110, 255, 210, 60);  //es  el que  dice puntos 
        this.add(label);
        mov.start();
        this.setLayout(null);
        t.requestFocus();
        t.addKeyListener(this);
        this.add(t);
        for (int x = 0; x < n; x++) {  //llenar de  cuadritos   todo el panel  
            for (int y = 0; y < m; y++) {
                btn[x][y] = new JButton("");
                btn[x][y].setBounds(x * 10, y * 10, 10, 10);
                this.add(btn[x][y]);
                btn[x][y].setBackground(Color.BLACK);
                btn[x][y].setBorder(null);
            }
        }   
        CabezaX = n / 2;
        CabezaY = m / 2;
        Nodo cabeza;
        for (int i = 0; i < 3; i++) {
            cabeza = new Nodo();
            cabeza.setX(CabezaX - i);
            cabeza.setY(CabezaY);
            lista.agregarFinal(cabeza);
            btn[cabeza.getX()][cabeza.getY()].setBackground(Color.MAGENTA);
        }
  
        generarManzana();
    }

    void generarManzana() {
        manzanaX = aleatorioX();  //crea  una  posicion  aleatoria  en  x  
        manzanaY = aleatorioY();   //crea  una funcion aleatoria  en  y  
        dibujarManzana();   //dibujar   manzana  
    }

    void dibujarManzana() {
        if (btn[manzanaX][manzanaY].getBackground() == Color.WHITE || btn[manzanaX][manzanaY].getBackground() == Color.BLUE) { 
            generarManzana();
        } else {
            btn[manzanaX][manzanaY].setBackground(Color.RED);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {          //COntroles manuales
        switch (e.getKeyCode()) {
            case 37:

                if (!marcha.equals("derecha")) {
                    mov.Opcion(37);
                }
                break;
            case 38:
                if (!marcha.equals("abajo")) {
                    mov.Opcion(38);
                }
                break;
            case 39:
                if (!marcha.equals("izquierda")) {
                    mov.Opcion(39);
                }
                break;
            case 40:
                if (!marcha.equals("arriba")) {
                    mov.Opcion(40);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    void crecer() throws InterruptedException {
        puntos++;
        label.setText("Puntaje = " + puntos);
        if (puntos == 5) {   
            JOptionPane.showMessageDialog(null, "nivel 2");
           // mov.detenElHilo();
          
        }
        Nodo n = new Nodo();   //para  irle  agregando  longitud  a mi codigo  
        n.setCodigo(lista.obtenerCodigo());
        lista.agregarFinal(n);   
        generarManzana();
    }

    void obtenerLogitudCuerpo() {
        Nodo aux = lista.getLista();
    }

    void validar() {
        if (btn[CabezaX][CabezaY].getBackground() == Color.BLACK) {
        } else if (btn[CabezaX][CabezaY].getBackground() == Color.MAGENTA) {
            JOptionPane.showMessageDialog(null, "PERDIO");
            mov.detenElHilo();
        } else if (btn[CabezaX][CabezaY].getBackground() == Color.RED) {
            try {
                crecer();
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiar();
    }

    void derecha() {
        CabezaX++;
        validar();
    }

    void izquierda() {
        CabezaX--;
        validar();
    }

    void abajo() {
        CabezaY++;
        validar();
    }

    void arriba() {
        CabezaY--;
        validar();
    }

    void limpiar() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                btn[x][y].setBackground(Color.BLACK);              
            }
        }
        dibujarManzana();
        if (lista.getLista() != null) {     //si  esta  vacio el pixel  donde queremos  dibujar la manzana
            Nodo aux = lista.getLista();   //aux  toma  un  valor  de  tipo  nodo  de  la  funcion  getlista  
          while (aux.sig != null) {       //aux  en  su  punto  sig checa  que no  este  vacio  despues de el  
                aux.setX(aux.sig.getX());
                aux.setY(aux.sig.getY());
                btn[aux.getX()][aux.getY()].setBackground(Color.MAGENTA);
              /*  if (aux.getX() == 0 && aux.getY() == 0) {
                    btn[aux.getX()][aux.getY()].setBackground(Color.WHITE);
                }*/
                aux = aux.sig;
            }
            aux.setX(CabezaX);
            aux.setY(CabezaY);
            btn[CabezaX][CabezaY].setBackground(Color.MAGENTA);
        }
    }

    int aleatorioX() {
        return (int) (Math.random() * n);
    }

    int aleatorioY() {
        return (int) (Math.random() * m);
    }

    class Mover extends Thread {

        private boolean continuar = true;
        private int tecla = 0;

        public void detenElHilo() {
            continuar = false;
        }

        public void Opcion(int x) {
            tecla = x;
        }

        public void run() {
            while (continuar) {
                try {
                    Thread.currentThread().sleep(100);
                    switch (tecla) {
                        case 37:
                            if (CabezaX >= 1) {
                                izquierda();
                                marcha = "izquierda";
                            } else {
                                JOptionPane.showMessageDialog(null, "PERDIO");
                                this.stop();
                            }
                            break;
                        case 38:
                            if (CabezaY >= 1) {
                                arriba();
                                marcha = "arriba";
                            } else {
                                JOptionPane.showMessageDialog(null, "PERDIO");
                                this.stop();
                            }
                            break;
                        case 39:
                            if (CabezaX <= 78) {
                                derecha();
                                marcha = "derecha";
                            } else {
                                JOptionPane.showMessageDialog(null, "PERDIO");
                                this.stop();
                            }
                            break;
                        case 40:
                            if (CabezaY <= 22) {
                                abajo();
                                marcha = "abajo";
                            } else {
                                JOptionPane.showMessageDialog(null, "PERDIO");
                                this.stop();
                            }
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
