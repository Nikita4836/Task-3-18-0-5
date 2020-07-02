package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import lib.ArrayUtils;
import lib.JTableUtils;


public class Window extends JFrame {

    private JPanel panelMain;
    private JTable tableOutput;
    private JButton buttonRun;
    private JButton buttonLoadInputFromFile;
    private JButton buttonSaveOutputIntoFile;
    private JTable tableInput;
    private JScrollPane scrollPaneTableInput;
    private JScrollPane scrollPaneTableOutput;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Window() {
        this.setTitle("Сортировка");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLocationRelativeTo(null); //запуск окна в центре

        JTableUtils.initJTableForArray(tableInput, 100, true, true, true, true);
        JTableUtils.initJTableForArray(tableOutput, 100, true, true, true, true);
        //tableOutput.setEnabled(false);
        scrollPaneTableInput.setPreferredSize(new Dimension(700, 100));
        scrollPaneTableOutput.setPreferredSize(new Dimension(700, 100));
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JTableUtils.writeArrayToJTable(tableInput, new String[]{"пец", "Липа", "Липецкая", "Липцк", "Липецк", "ая"});

        this.pack();

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String[] matrix = JTableUtils.readStringArrayFromJTable(tableInput);
                    String[] arr = Main.process(matrix);
                    String[] arrOut = List.coupList();
//                    String[] arrOut = Cast.queueToStringArray(Main.priorityQueue);
                    JTableUtils.writeArrayToJTable(tableOutput, arrOut);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            }
        });

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[] arr = ArrayUtils.readLinesFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            }
        });

    }
}

