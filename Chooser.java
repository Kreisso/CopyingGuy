package cg;

/**
 * Created by kreisso on 09.07.2018.
 */
import java.awt.event.*;
import javax.swing.*;

public class Chooser extends JPanel
        implements ActionListener {
    JButton go;
    JTextField textField;
    JFileChooser chooser;
    String choosertitle;
    int option;

    public Chooser(int option) {
        go = new JButton("...");
        go.addActionListener(this);
        textField = new JTextField(30);
        this.option = option;
        add(textField);
        add(go);
    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(option);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            textField.setText(chooser.getSelectedFile().toString());
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }
}

