/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3;

import com.mycompany.sem6lab3.reactors.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author User
 */
public class Gui extends JFrame {
    private final JTree jtree;
    private final DefaultMutableTreeNode reactors;
    private DefaultTreeModel treeModel;
    private final JScrollPane scrollpane;
    private final JButton importButton;
    private final JButton closeButton;
    
    public Gui (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(700, 500); 
        this.setLayout(new BorderLayout());
        this.reactors = new DefaultMutableTreeNode("Реакторы");
        this.treeModel = new DefaultTreeModel(reactors);
        this.jtree = new JTree(this.treeModel);      
        this.scrollpane = new JScrollPane(this.jtree);
        this.add(this.scrollpane, BorderLayout.CENTER);
        this.closeButton = new JButton("Exit");
        this.importButton = new JButton("Import");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(this.closeButton);
        panel.add(this.importButton);
        this.add(panel, BorderLayout.SOUTH);

        this.closeButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        this.importButton.addActionListener((var e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getPath();
                try {
                    ReactorHandler yamlHandler = new YamlReactorHandler();
                    ReactorHandler jsonHandler = new JsonReactorHandler();
                    ReactorHandler xmlHandler = new XmlReactorHandler();
                    
                    yamlHandler.setNext(jsonHandler);
                    jsonHandler.setNext(xmlHandler);
                    
                    ArrayList<Reactor> reactorsList = yamlHandler.handleFile(filePath);
                    for (Reactor reactor: reactorsList){
                        DefaultMutableTreeNode reactorNode=new DefaultMutableTreeNode(reactor.getReactorClass());
                        DefaultMutableTreeNode burnupNode=new DefaultMutableTreeNode(reactor.getBurnup());
                        DefaultMutableTreeNode kpdNode=new DefaultMutableTreeNode(reactor.getKpd());
                        DefaultMutableTreeNode enrichmentNode=new DefaultMutableTreeNode(reactor.getEnrichment());
                        DefaultMutableTreeNode termalCapacityNode=new DefaultMutableTreeNode(reactor.getTermalCapacity());
                        DefaultMutableTreeNode electricalCapacityNode=new DefaultMutableTreeNode(reactor.getElectricalCapacity());
                        DefaultMutableTreeNode lifeTimeNode=new DefaultMutableTreeNode(reactor.getLifeTime());
                        DefaultMutableTreeNode firstLoadNode=new DefaultMutableTreeNode(reactor.getFirstLoad());
                        DefaultMutableTreeNode fileTypeNode=new DefaultMutableTreeNode(reactor.getFileType());
                        reactors.add(reactorNode);
                        reactorNode.add(burnupNode);
                        reactorNode.add(kpdNode);
                        reactorNode.add(enrichmentNode);
                        reactorNode.add(termalCapacityNode);
                        reactorNode.add(electricalCapacityNode);
                        reactorNode.add(lifeTimeNode);
                        reactorNode.add(firstLoadNode);
                        reactorNode.add(fileTypeNode);                        
                    }
                     treeModel.reload(reactors);
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            "Error reading the file",
                            "File Error", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });
    }
}
