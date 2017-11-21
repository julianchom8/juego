import javax.swing.*;

public class Frame extends JFrame {

    // Metodo constructor
    Frame(JPanel panel) {
     //   super("Snake");    //llama  al   mommbre  de la  superclase  
        setTitle("VENOMSNAKE");
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0, 0, 810, 350);
        this.setVisible(true);
    }
}
