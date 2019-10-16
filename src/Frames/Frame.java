package Frames;

import Components.DirectoryContent;
import Components.DirectoryFixed;
import Components.DirectoryTab;
import CRUD.Directory;
import CRUD.Explorer;
import java.awt.Color;
import java.awt.Component;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Frame extends javax.swing.JFrame {
    
    Explorer explorer = new Explorer();
    public static String fileCopy;
    
    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        pnlQuickAccess.add(new DirectoryFixed());
        pnlQuickAccess.add(new DirectoryFixed());
        
        addNewTab();
        pnlTabs.add(btnNewTab);
    }
    
    public void addNewTab(Directory dir) {
        explorer.add(dir);
        int id = explorer.getNextId();
        
        DirectoryTab tab = new DirectoryTab(dir);
        DirectoryContent content = new DirectoryContent(dir);
        
        unfocusTabs();
        pnlTabs.add(tab);
        tabContent.add(content);
        
        tab.setOpaque(true);
        tabContent.setSelectedComponent(content);
        
        tab.getPnlTitle().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unfocusTabs();
                tab.setOpaque(true);
                tabContent.setSelectedComponent(content);
                repaintTabs();
            }
        });
        tab.getButtonClose().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                explorer.delete(id);
                pnlTabs.remove(tab);
                tabContent.remove(content);
                repaintTabs();
                
            }
        });
        
        repaintTabs();
        
    }
    public void addNewTab() {
        Directory dir = new Directory(explorer.getHome());
        addNewTab(dir);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewTab = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        pnlAside = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlQuickAccess = new javax.swing.JPanel();
        pnlTabs = new javax.swing.JPanel();
        tabContent = new javax.swing.JTabbedPane();

        btnNewTab.setBackground(null);
        btnNewTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/plus.png"))); // NOI18N
        btnNewTab.setBorder(null);
        btnNewTab.setBorderPainted(false);
        btnNewTab.setContentAreaFilled(false);
        btnNewTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewTab.setFocusPainted(false);
        btnNewTab.setPreferredSize(new java.awt.Dimension(42, 32));
        btnNewTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTabActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Explorer");

        body.setBackground(new java.awt.Color(237, 239, 240));

        pnlAside.setBackground(null);
        pnlAside.setMaximumSize(new java.awt.Dimension(230, 714));
        pnlAside.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlAside.setOpaque(false);
        pnlAside.setPreferredSize(new java.awt.Dimension(230, 714));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Favorites");

        pnlQuickAccess.setBackground(new java.awt.Color(102, 102, 255));
        pnlQuickAccess.setMinimumSize(new java.awt.Dimension(94, 100));
        pnlQuickAccess.setOpaque(false);
        pnlQuickAccess.setPreferredSize(new java.awt.Dimension(204, 196));
        pnlQuickAccess.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        javax.swing.GroupLayout pnlAsideLayout = new javax.swing.GroupLayout(pnlAside);
        pnlAside.setLayout(pnlAsideLayout);
        pnlAsideLayout.setHorizontalGroup(
            pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsideLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlQuickAccess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnlAsideLayout.setVerticalGroup(
            pnlAsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsideLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlQuickAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        pnlTabs.setBackground(new java.awt.Color(51, 153, 255));
        pnlTabs.setMaximumSize(new java.awt.Dimension(787, 32));
        pnlTabs.setMinimumSize(new java.awt.Dimension(50, 32));
        pnlTabs.setOpaque(false);
        pnlTabs.setPreferredSize(new java.awt.Dimension(787, 32));
        pnlTabs.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

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
                    .addComponent(tabContent, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(pnlTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAside, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(pnlTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private void btnNewTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTabActionPerformed
        addNewTab();
        pnlTabs.remove(btnNewTab);
        pnlTabs.add(btnNewTab);
    }//GEN-LAST:event_btnNewTabActionPerformed

    public void unfocusTabs() {
        for (int i = 0; i < pnlTabs.getComponentCount()-1; i++) {
            DirectoryTab tab = (DirectoryTab) (pnlTabs.getComponents()[i]);
            tab.setOpaque(false);
        }
    }
    
    public void repaintTabs(){
        pnlTabs.repaint();
        tabContent.repaint();
    }
    
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
    private javax.swing.JButton btnNewTab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlAside;
    private javax.swing.JPanel pnlQuickAccess;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JTabbedPane tabContent;
    // End of variables declaration//GEN-END:variables

}
