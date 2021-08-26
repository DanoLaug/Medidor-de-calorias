package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Scanner;

class IntroPanel extends JPanel{
    public IntroPanel(){
        setBackground(Color.ORANGE);

        JLabel I1 = new JLabel("Welcome, this is your personal trainer --->");
        JLabel I2 = new JLabel("Select the panel that you wish");
        add(I1);
        add(I2);

    }
}

class PersonalDataSelectionPanel extends JPanel {
    int repeat;
    String output, name, output2;
    double p,e,imc;
    private JRadioButton top1, top2, top3, top4, top5, top6;
    Scanner teclado=new Scanner(System.in);

    public PersonalDataSelectionPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        JLabel I1 = new JLabel("Fill the next information");
        add(I1);

        top1 = new JRadioButton("Name : ");
        top2 = new JRadioButton("Age : ");
        top3 = new JRadioButton("Sex : ");
        top4 = new JRadioButton("Contact information : ");
        top5 = new JRadioButton("Height and Weight: ");

        ButtonGroup group = new ButtonGroup();
        group.add(top1);
        group.add(top2);
        group.add(top3);
        group.add(top4);
        group.add(top5);

        PersonalDataSelectionPanel.ButtonListener listener = new PersonalDataSelectionPanel.ButtonListener();
        top1.addActionListener(listener);
        top2.addActionListener(listener);
        top3.addActionListener(listener);
        top4.addActionListener(listener);
        top5.addActionListener(listener);

        add(top1);
        add(top2);
        add(top3);
        add(top4);
        add(top5);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            do{
                String info;
                double p,e,imc;

                if(top1.isSelected())
                    info = name;
                else if (top2.isSelected())
                    info = name;
                else if (top3.isSelected())
                    info = name;
                else if (top4.isSelected())
                    info = name;
                name = (JOptionPane.showInputDialog("Enter your data : "));
                output = " "+(name);
                JOptionPane.showMessageDialog(null, output);

                if (top5.isSelected()) {
                    e = Integer.parseInt(JOptionPane.showInputDialog("Enter your Heigt : "));
                    p = Integer.parseInt(JOptionPane.showInputDialog("Enter your Weight : "));
                    imc = p / (e * e);
                    if (imc < 0.0017) {
                        output2 = "BAJO PESO -> " + (imc);
                    }
                    else if (imc >= 0.0018 && imc <= 0.0027) {
                        output2 = "NORMAL -> " + (imc);
                    }
                    else if (imc >= 0.0028 && imc <= 0.0033) {
                        output2 = "SOBRE PESO -> " + (imc);
                    }
                    else {
                        output2 = "OBESIDAD -> " + (imc);
                    }
                }
                JOptionPane.showMessageDialog(null, output2);
            }
            while (repeat == JOptionPane.NO_OPTION);
        }
    }
}

class CaloriesPanel extends JPanel{
    int num, repeat;
    String output;
    private JRadioButton soda, Cereal, Chocolatebar, PacketCrisps, BlueBerryMuffin, Sandwich;

    public CaloriesPanel(){
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        soda = new JRadioButton("Soda");
        Cereal = new JRadioButton("Cereal");
        Chocolatebar = new JRadioButton("Chocolate bar");
        PacketCrisps = new JRadioButton("Packet Crisps");
        BlueBerryMuffin = new JRadioButton("Blue Berry Muffin");
        Sandwich = new JRadioButton("Sandwich");
        ButtonGroup group = new ButtonGroup();
        group.add(soda);
        group.add(Cereal);
        group.add(Chocolatebar);
        group.add(PacketCrisps);
        group.add(BlueBerryMuffin);
        group.add(Sandwich);

        ButtonListener listener = new ButtonListener();
        soda.addActionListener(listener);
        Cereal.addActionListener(listener);
        Chocolatebar.addActionListener(listener);
        PacketCrisps.addActionListener(listener);
        BlueBerryMuffin.addActionListener(listener);
        Sandwich.addActionListener(listener);

        add(soda);
        add(Cereal);
        add(Chocolatebar);
        add(PacketCrisps);
        add(BlueBerryMuffin);
        add(Sandwich);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
            do{
                int size=0;
                if(soda.isSelected())
                    size=138;
                else if (Cereal.isSelected())
                    size=172;
                else if (Chocolatebar.isSelected())
                    size=229;
                else if (PacketCrisps.isSelected())
                    size=171;
                else if (BlueBerryMuffin.isSelected())
                    size=265;
                else if (Sandwich.isSelected())
                    size=445;
                else
                    size=15;

                num = Integer.parseInt(JOptionPane.showInputDialog("Enter a quantity : "));
                output = "The amount of calories is "+(num*size);
                JOptionPane.showMessageDialog(null, output);
            }
            while (repeat == JOptionPane.NO_OPTION);
        }
    }
}

class ExerciseSelectionPanel extends JPanel{
    private JRadioButton B1;
    int num, repeat;
    String output;

    public ExerciseSelectionPanel(){

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        B1 = new JRadioButton("How to burn calories");

        ButtonGroup group = new ButtonGroup();
        group.add (B1);

        ButtonListener listener = new ButtonListener();
        B1.addActionListener(listener);

        add(B1);

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            do{
                int size=0;
                if(B1.isSelected())

                    num = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity of calories that you eat : "));

                if (num>= 0 && num <= 50) {
                    output = "Caminata -> 13 min\" o \"Correr -> 10 min";
                }
                else if (num >= 51 && num <= 150) {
                    output = "Caminata -> 26 min\" o \"Correr -> 13 min" ;
                }
                else if (num >= 151 && num <= 250) {
                    output = "Caminata -> 31 min\" o \"Correr -> 16 min";
                }
                else if (num >= 251 && num <= 350) {
                    output = "Caminata -> 46 min\" o \"Correr -> 26 min";
                }
                else if (num >= 351 && num <= 450) {
                    output = "Caminata -> 1 hr \" o \"Correr -> 35 min";
                }
                else{
                    output = "Caminata -> 2 hr min\" o \"Correr -> 1 hr 15 min";
                }
                output = " "+(output);
                JOptionPane.showMessageDialog(null, output);
                repeat = JOptionPane.showConfirmDialog(null, "Is correct?");
            }
            while (repeat == JOptionPane.NO_OPTION);
        }
    }
}

public class Main{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Personal Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabpane = new JTabbedPane();

        tabpane.addTab("Intro", new IntroPanel());
        tabpane.addTab("Personal Data", new PersonalDataSelectionPanel());
        tabpane.addTab("Calories Calculator", new CaloriesPanel());
        tabpane.addTab("Exercise recomendation", new ExerciseSelectionPanel());

        frame.getContentPane().add(tabpane);
        frame.pack();
        frame.setVisible(true);
        //frame.getContentPane().add(primary);
    }
}

