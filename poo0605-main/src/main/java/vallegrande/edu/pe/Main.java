package vallegrande.edu.pe;

import vallegrande.edu.pe.view.InicioView;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            InicioView inicio = new InicioView();

            inicio.setVisible(true);

        });

    }
}