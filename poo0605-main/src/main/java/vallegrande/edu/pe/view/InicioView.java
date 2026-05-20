package vallegrande.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class InicioView extends JFrame {

    public InicioView() {

        setTitle("Sistema Agrícola");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("SISTEMA AGRÍCOLA");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(120,30,300,30);

        JLabel descripcion = new JLabel("Bienvenido al sistema MVC");
        descripcion.setBounds(150,80,250,30);

        JButton btnUsuarios = new JButton("USUARIOS");
        btnUsuarios.setBounds(150,150,180,40);

        panel.add(titulo);
        panel.add(descripcion);
        panel.add(btnUsuarios);

        add(panel);

        // NAVEGACIÓN
        btnUsuarios.addActionListener(e -> {

            UsuarioView vista = new UsuarioView();

            vista.setVisible(true);

        });
    }
}