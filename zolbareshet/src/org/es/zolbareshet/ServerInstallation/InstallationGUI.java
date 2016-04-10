package org.es.zolbareshet.ServerInstallation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class InstallationGUI {
    public static Color regularColor = new Color(10, 92, 255);
    public static Color errorColor = new Color(255, 48, 83);
    public static Font regularFont = new Font("Serif", Font.BOLD, 20);
    public static Font errorFont = new Font("Serif", Font.ITALIC, 10);


    public static void main(String[] args) {
        JFrame f = new MainScreen();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1100, 600);
        f.setVisible(true);
        f.setResizable(false);
    }

    static class MainScreen extends JFrame {
        private JPanel mainPanel;
        private JPanel secondPanel;
        private ZolPanel1 zolPanel1;
        private ZolPanel2 zolPanel2;
        private JButton nextButton = new JButton("Next");
        private JButton cancelButton;
        private JPanel buttonsPanel;

        public MainScreen() {
            super("ZolBareshet Web Site Installation");
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            zolPanel1 = new ZolPanel1();
            mainPanel.add(zolPanel1);
            //   nextButton.setFont(regularFont);
            nextButton.setForeground(InstallationGUI.regularColor);
            buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(5, 5));
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 3 && j == 3) {
                        buttonsPanel.add(nextButton);
                    } else {
                        buttonsPanel.add(new JLabel(""));
                    }
                }
            }
            mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    remove(mainPanel);
                    add(secondPanel);
                    revalidate();
                    repaint();
                }
            });
            secondPanel = new JPanel();
            zolPanel2 = new ZolPanel2();
            secondPanel.add(zolPanel2);
            // mainPanel.add(zolPanel2,BorderLayout.SOUTH);
            add(mainPanel);


            //  add(zolPanel2);
            // zolPanel2.setVisible(false);
        }


    }

    static class ZolPanel1 extends JPanel {
        public ZolPanel1() {
        }

        public void paintComponent(Graphics g) {

            g.setFont(new Font("Serif", Font.BOLD, 35));
            g.setColor(regularColor);
            g.drawString("Welcome To The Installation Process of Zol Bareshet Web Site", 50, 80);
            g.setFont(regularFont);
            g.drawString("Before you continue, please make sure that you have a postgresql database version 1.20 installed", 55, 120);
            g.drawString("and the connection's credentials for it.", 55, 150);
            g.drawString("Note that this process should be taken after the application was deployed to the tomcat server.", 55, 180);
            g.drawString("Press Next to continue", 120, 330);
        }
    }

        static class ZolPanel2 extends JPanel {

            JLabel titleLabel;
            JLabel configfileLabel;
            JTextField configfileTextField;
            JLabel configFileMessage;
            JTextField urlTextField;
            JLabel urlLabel;
            JLabel userLabel;
            JTextField userField;
            JLabel passLabel;
            JTextField passField;
            JLabel passMessage;
            JLabel portLabel;
            JTextField portField;
            JButton finishButton;

            public ZolPanel2() {
                titleLabel = new javax.swing.JLabel();
                configfileLabel = new javax.swing.JLabel();
                configfileTextField = new javax.swing.JTextField();
                configFileMessage = new javax.swing.JLabel();
                urlTextField = new javax.swing.JTextField();
                urlLabel = new javax.swing.JLabel();
                userLabel = new javax.swing.JLabel();
                userField = new javax.swing.JTextField();
                passLabel = new javax.swing.JLabel();
                passField = new javax.swing.JTextField();
                passMessage = new javax.swing.JLabel();
                portLabel = new javax.swing.JLabel();
                portField = new javax.swing.JTextField();
                finishButton = new javax.swing.JButton();

                titleLabel.setFont(new java.awt.Font("Serif", 1, 35));
                titleLabel.setText("Please fill all the fields below:");
                titleLabel.setForeground(regularColor);
                configfileLabel.setFont(new java.awt.Font("Serif", 1, 20));
                configfileLabel.setText("Full path to the configuration file:");
                configfileLabel.setForeground(regularColor);
                configFileMessage.setFont(new java.awt.Font("Serif", 1, 12));
                configFileMessage.setText("(This file is found in the tomcat server under the WEB-INF folder in zolbareshet application)");
                configFileMessage.setForeground(regularColor);
                urlLabel.setFont(new java.awt.Font("Serif", 1, 20));
                urlLabel.setText("URL to the postgres DataBase:");
                urlLabel.setForeground(regularColor);
                userLabel.setFont(new java.awt.Font("Serif", 1, 20));
                userLabel.setText("DataBase user name:");
                userLabel.setForeground(regularColor);
                passLabel.setFont(new java.awt.Font("Serif", 1, 20));
                passLabel.setText("DataBase Password:");
                passLabel.setForeground(regularColor);
                passMessage.setForeground(regularColor);
                passMessage.setFont(new java.awt.Font("Serif", 1, 12));
                passMessage.setText("The password will be stored encrypted in the configuration file");
                portLabel.setForeground(regularColor);

                portLabel.setFont(new java.awt.Font("Serif", 1, 20));
                portLabel.setText("DataBase port:");

                finishButton.setText("Finish Installation");
                finishButton.setForeground(regularColor);
                finishButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!urlTextField.getText().equals("")&&!portField.getText().equals("")&&!userField.getText().equals("")&&!passField.getText().equals("")&&!configfileTextField.getText().equals("")){
                            try {
                                InstallationHelper.updateConfigFile(configfileTextField.getText(), userField.getText(), passField.getText(), portField.getText());
                                InstallationHelper.buildTables(urlTextField.getText(), userField.getText(), passField.getText(), portField.getText());
                                JOptionPane.showMessageDialog(ZolPanel2.this,"The Installation Process was Successfully finished","Success",JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                            }catch (IOException e3){
                                JOptionPane.showMessageDialog(ZolPanel2.this,"There was an Error accessing the configuration file\n" + e3.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                            }catch(SQLException e2){
                                JOptionPane.showMessageDialog(ZolPanel2.this,"There was an Error while trying configuring the DataBase\n" + e2.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                            } catch (Exception e1) {
                                JOptionPane.showMessageDialog(ZolPanel2.this,"There was an unexpected error\n"+e1.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                                e1.printStackTrace();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(ZolPanel2.this,"One or more fields was not set","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
                setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().
                                addContainerGap(25, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().
                                        addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(configFileMessage).
                                                addGroup(jPanel1Layout.createSequentialGroup().addComponent(configfileLabel).addGap(26, 26, 26).
                                                        addComponent(configfileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)).
                                                addGroup(jPanel1Layout.createSequentialGroup().addComponent(urlLabel).addGap(30, 30, 30).
                                                        addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)).
                                                addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE).
                                                addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        ).addGroup(jPanel1Layout.createSequentialGroup().addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18).addComponent(portField))).addGap(43, 43, 43).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18).addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)).
                                                                addComponent(passMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))).addGap(20, 20, 20)).
                                        addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(167, 167, 167))))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).
                                addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).
                                addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(configfileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(configfileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).
                                addGap(5, 5, 5).addComponent(configFileMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(urlLabel)
                                        .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).
                                        addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(userLabel)
                                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).
                                                addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                ).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().
                                        addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(passMessage)).addGroup(jPanel1Layout.createSequentialGroup().
                                        addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(portLabel).
                                        addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(124, 124, 124).addComponent(finishButton).addContainerGap(179, Short.MAX_VALUE)));
            }
        }

    }
