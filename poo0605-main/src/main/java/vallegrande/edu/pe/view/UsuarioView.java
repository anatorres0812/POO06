package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.UsuarioController;
import vallegrande.edu.pe.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UsuarioView extends JFrame {

    JTextField txtNombre;
    JTextField txtCorreo;
    JTextField txtTelefono;
    JTextField txtAsunto;

    JTable tabla;

    UsuarioController controller = new UsuarioController();

    public UsuarioView() {

        setTitle("Módulo Usuarios");
        setSize(700,500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("CRUD USUARIOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(250,20,300,30);

        panel.add(titulo);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50,80,100,25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150,80,200,25);
        panel.add(txtNombre);

        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(50,120,100,25);
        panel.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(150,120,200,25);
        panel.add(txtCorreo);

        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(50,160,100,25);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150,160,200,25);
        panel.add(txtTelefono);

        JLabel lblAsunto = new JLabel("Asunto");
        lblAsunto.setBounds(50,200,100,25);
        panel.add(lblAsunto);

        txtAsunto = new JTextField();
        txtAsunto.setBounds(150,200,200,25);
        panel.add(txtAsunto);

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(150,250,150,40);
        panel.add(btnGuardar);

        // TABLA
        tabla = new JTable();

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBounds(380,80,260,250);

        panel.add(scroll);

        add(panel);

        listarUsuarios();

        // BOTÓN GUARDAR
        btnGuardar.addActionListener(e -> {

            Usuario u = new Usuario();

            u.setNombre(txtNombre.getText());
            u.setCorreo(txtCorreo.getText());
            u.setTelefono(txtTelefono.getText());
            u.setAsunto(txtAsunto.getText());

            controller.insertarUsuario(u);

            JOptionPane.showMessageDialog(null,
                    "Usuario guardado");

            listarUsuarios();

            limpiar();
        });

    }

    // LISTAR
    public void listarUsuarios() {

        List<Usuario> lista = controller.obtenerUsuarios();

        DefaultTableModel modelo =
                new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("ASUNTO");

        for (Usuario u : lista) {

            Object[] fila = {

                    u.getId(),
                    u.getNombre(),
                    u.getCorreo(),
                    u.getTelefono(),
                    u.getAsunto()

            };

            modelo.addRow(fila);
        }

        tabla.setModel(modelo);
    }

    // LIMPIAR
    public void limpiar() {

        txtNombre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtAsunto.setText("");
    }
}