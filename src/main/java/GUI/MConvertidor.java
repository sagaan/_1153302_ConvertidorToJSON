package GUI;

import Convertidor.ControladorGSON;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MConvertidor{

    public MConvertidor(){
        frame = new JFrame();
        frame.setBounds(10,10,780,475);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Convertidor de XML a JSON");

        iniciar();
    }

    JFrame frame;
    JButton btnConvertir;
    JTextArea txtFuente;
    JTextArea txtGSON;
    JComboBox cbxTipo;
    ControladorGSON GSON = new ControladorGSON();

    public void iniciar(){
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(325,150,100,25);
        btnConvertir.setVisible(true);
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtGSON.setText("");
                if(cbxTipo.getSelectedIndex() == 0){
                    txtGSON.setText(GSON.XMLtoJSON(txtFuente.getText()));
                }else{
                    txtGSON.setText(GSON.JavaToJSON(txtFuente.getText()));
                }
                txtFuente.setText("");
            }
        });

        txtFuente = new JTextArea();
        txtFuente.setLineWrap(true);
        txtFuente.setWrapStyleWord(true);
        JScrollPane jspFuente = new JScrollPane(txtFuente);
        jspFuente.setBounds(10,10,300,340);
        jspFuente.setVisible(true);

        txtGSON = new JTextArea();
        JScrollPane jspGSON = new JScrollPane(txtGSON);
        jspGSON.setBounds(450,10,300,340);
        jspGSON.setVisible(true);

        cbxTipo = new JComboBox();
        cbxTipo.setBounds(240,360,60,20);
        cbxTipo.setVisible(true);
        cbxTipo.addItem("XML");
        cbxTipo.addItem("Java");
        cbxTipo.setBackground(Color.WHITE);
        cbxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtGSON.setText("");
                txtFuente.setText("");
                if(cbxTipo.getSelectedIndex()==0) {
                    JOptionPane.showMessageDialog(frame, "Ingresa un codigo XML en el TextArea izquierdo");
                    frame.setTitle("Convertidor de XML a JSON");
                }else {
                    JOptionPane.showMessageDialog(frame, "Ingresa tres lineas de texto, que correspondan a Color, Marca y Dueño respectivamente");
                    frame.setTitle("Convertidor de Java a JSON");
                }
            }
        });

        frame.add(btnConvertir);
        frame.add(jspFuente);
        frame.add(jspGSON);
        frame.add(cbxTipo);

        frame.repaint();
        frame.setSize(781,475);
    }

    public static void main(String[] args) {
        MConvertidor obj = new MConvertidor();
    }
}
