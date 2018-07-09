package cg;

/**
 * Created by kreisso on 09.07.2018.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.*;

public class Frame extends JFrame
        implements Operations{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel sourceLebel;
    private JLabel destinyLabel;
    private JLabel howManyLabel;
    private JButton doneButton;
    private Chooser chooserSource;
    private Chooser chooserDestiny;
    private JFormattedTextField howManyTextField;
    private NumberFormat amountFormat;

    public Frame() {

        super("Copying guy by Maciej Polak");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 10, 5, 5);

        grid.gridx = 0;
        grid.gridy = 0;

        sourceLebel = new JLabel("Source path: ");

        this.add(sourceLebel, grid);

        grid.gridx = 1;



        chooserSource = new Chooser(0);

        this.add(chooserSource, grid);

        grid.gridx = 0;
        grid.gridy = 1;

        destinyLabel = new JLabel("Destiny path: ");

        this.add(destinyLabel, grid);

        grid.gridx = 1;

        chooserDestiny = new Chooser(1);

        this.add(chooserDestiny, grid);

        grid.gridx = 0;
        grid.gridy = 2;

        howManyLabel = new JLabel("How many copies: ");

        this.add(howManyLabel, grid);

        grid.gridx = 1;

        howManyTextField = new JFormattedTextField(amountFormat);
        howManyTextField.setColumns(5);
        this.add(howManyTextField, grid);

        grid.gridx = 2;

        doneButton = new JButton("Ok");
        doneButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource();
                if(source == doneButton)
                {
                    try {
                        makeCopies(chooserSource.textField.getText(), chooserDestiny.textField.getText(), Integer.parseInt((String) howManyTextField.getValue()));
                        System.out.println("cos");
                    } catch (IOException e1) {
                        System.out.println("cos2");
                        e1.printStackTrace();
                    }
                }
            }
        });

        this.add(doneButton, grid);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        this.setVisible(true);
        this.setBounds((size.width/2)-400, (size.height/2)-300, 800, 600);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        pack();
    }


}

