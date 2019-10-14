package Frames;

import Components.DirectoryContent;
import Components.DirectoryFixed;
import Components.DirectoryTab;
import CRUD.Directory;
import CRUD.Explorer;
import java.awt.Color;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Frame extends javax.swing.JFrame {
    
    Explorer explorer = new Explorer();
    
    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        pnlQuickAccess.add(new DirectoryFixed());
        
        addNewTab();
    }
    
    
    public void addNewTab(Directory dir) {
        explorer.add(dir);
        pnlTabs.add(new DirectoryTab(dir));
        tabContent.revalidate();
        pnlTabs.repaint();

        tabContent.add(new DirectoryContent(dir));
        tabContent.revalidate();
        tabContent.repaint();
    }
    public void addNewTab() {
        Directory dir = new Directory(explorer.getHome());
        explorer.add(dir);
        pnlTabs.add(new DirectoryTab(dir));
        tabContent.revalidate();
        pnlTabs.repaint();

        tabContent.add(new DirectoryContent(dir));
        tabContent.revalidate();
        tabContent.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        pnlAside = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scrollQuickAccess = new javax.swing.JScrollPane();
        pnlQuickAccess = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlTabs = new javax.swing.JPanel();
        btnWindow = new javax.swing.JPanel();
        btnCloseWindow = new javax.swing.JButton();
        btnMinimizeWindow = new javax.swing.JButton();
        btnMaximizeWindow = new javax.swing.JButton();
        btnNewTab = new javax.swing.JButton();
        tabContent = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Explorer");

        body.setBackground(new java.awt.Color(238, 242, 247));

        pnlAside.setBackground(null);
        pnlAside.setMaximumSize(new java.awt.Dimension(230, 714));
        pnlAside.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlAside.setOpaque(false);
        pnlAside.setPreferredSize(new java.awt.Dimension(230, 714));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Acceso Rapido");

        scrollQuickAccess.setBackground(new java.awt.Color(238, 242, 247));
        scrollQuickAccess.setBorder(null);
        scrollQuickAccess.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollQuickAccess.setOpaque(false);

        pnlQuickAccess.setBackground(new java.awt.Color(238, 242, 247));
        pnlQuickAccess.setMinimumSize(new java.awt.Dimension(94, 100));
        pnlQuickAccess.setPreferredSize(new java.awt.Dimension(204, 196));
        pnlQuickAccess.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        scrollQuickAccess.setViewportView(pnlQuickAccess);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Disco ( C: )");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("50.4 GB de 1 TB");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(114, 231, 167));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAsideLayout = new javax.swing.GroupLayout(pnlAside);
        pnlAside.setLayout(pnlAsideLayout);
        pnlAsideLayout.setHorizontalGroup(
            pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsideLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAsideLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlAsideLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAsideLayout.createSequentialGroup()
                        .addGroup(pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollQuickAccess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAsideLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 82, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))))
        );
        pnlAsideLayout.setVerticalGroup(
            pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsideLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollQuickAccess, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addGap(168, 168, 168)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pnlTabs.setBackground(null);
        pnlTabs.setMaximumSize(new java.awt.Dimension(687, 32));
        pnlTabs.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlTabs.setOpaque(false);
        pnlTabs.setPreferredSize(new java.awt.Dimension(687, 32));
        pnlTabs.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTabsMouseDragged(evt);
            }
        });
        pnlTabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTabsMousePressed(evt);
            }
        });
        pnlTabs.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        btnWindow.setBackground(null
        );
        btnWindow.setMaximumSize(new java.awt.Dimension(190, 32));
        btnWindow.setMinimumSize(new java.awt.Dimension(190, 32));
        btnWindow.setOpaque(false);
        btnWindow.setPreferredSize(new java.awt.Dimension(190, 32));

        btnCloseWindow.setBackground(new java.awt.Color(255, 0, 51));
        btnCloseWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/close.png"))); // NOI18N
        btnCloseWindow.setBorder(null);
        btnCloseWindow.setBorderPainted(false);
        btnCloseWindow.setContentAreaFilled(false);
        btnCloseWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCloseWindow.setFocusPainted(false);
        btnCloseWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseWindowActionPerformed(evt);
            }
        });

        btnMinimizeWindow.setBackground(null);
        btnMinimizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/minimize.png"))); // NOI18N
        btnMinimizeWindow.setBorder(null);
        btnMinimizeWindow.setBorderPainted(false);
        btnMinimizeWindow.setContentAreaFilled(false);
        btnMinimizeWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizeWindow.setFocusPainted(false);
        btnMinimizeWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeWindowActionPerformed(evt);
            }
        });

        btnMaximizeWindow.setBackground(null);
        btnMaximizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/maximize.png"))); // NOI18N
        btnMaximizeWindow.setBorder(null);
        btnMaximizeWindow.setBorderPainted(false);
        btnMaximizeWindow.setContentAreaFilled(false);
        btnMaximizeWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaximizeWindow.setFocusPainted(false);
        btnMaximizeWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizeWindowActionPerformed(evt);
            }
        });

        btnNewTab.setBackground(null);
        btnNewTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/plus.png"))); // NOI18N
        btnNewTab.setBorder(null);
        btnNewTab.setBorderPainted(false);
        btnNewTab.setContentAreaFilled(false);
        btnNewTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewTab.setFocusPainted(false);
        btnNewTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnWindowLayout = new javax.swing.GroupLayout(btnWindow);
        btnWindow.setLayout(btnWindowLayout);
        btnWindowLayout.setHorizontalGroup(
            btnWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnWindowLayout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(btnNewTab, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnMinimizeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnMaximizeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnCloseWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        btnWindowLayout.setVerticalGroup(
            btnWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCloseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(btnMinimizeWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMaximizeWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNewTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabContent.setBackground(new java.awt.Color(255, 255, 255));
        tabContent.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabContent.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabContent.setCursor(null
        );
        tabContent.setEnabled(false);
        tabContent.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabContent.setMinimumSize(new java.awt.Dimension(40, 60));
        tabContent.setRequestFocusEnabled(false);
        tabContent.setVerifyInputWhenFocusTarget(false);
        tabContent.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                if (false) {
                    return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
                } else {
                    return 0;
                }
            }
        });

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(pnlAside, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(pnlTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAside, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(tabContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseWindowActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseWindowActionPerformed

    
    int xx,xy;
    private void pnlTabsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTabsMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTabsMousePressed
    private void pnlTabsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTabsMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xx-230,y-xy);
    }//GEN-LAST:event_pnlTabsMouseDragged

    private void btnMaximizeWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizeWindowActionPerformed
        if (this.getExtendedState() != 0)
            this.setExtendedState(0);
        else
            this.setExtendedState(6);
    }//GEN-LAST:event_btnMaximizeWindowActionPerformed

    private void btnMinimizeWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeWindowActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeWindowActionPerformed

    private void btnNewTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTabActionPerformed
       
    }//GEN-LAST:event_btnNewTabActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnCloseWindow;
    private javax.swing.JButton btnMaximizeWindow;
    private javax.swing.JButton btnMinimizeWindow;
    private javax.swing.JButton btnNewTab;
    private javax.swing.JPanel btnWindow;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlAside;
    private javax.swing.JPanel pnlQuickAccess;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JScrollPane scrollQuickAccess;
    private javax.swing.JTabbedPane tabContent;
    // End of variables declaration//GEN-END:variables

}
