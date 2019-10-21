package Frames;

import Components.DirectoryContent;
import Components.DirectoryFixed;
import Components.DirectoryTab;
import CRUD.Directory;
import CRUD.Explorer;
import CRUD.strFile;
import Components.FileItem;
import Components.FileProperties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Frame extends javax.swing.JFrame {
    
    Explorer explorer = new Explorer();
    public File selectedFile;
    public String selectedType;
    
    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        pnlQuickAccess.add(new DirectoryFixed());
        pnlQuickAccess.add(new DirectoryFixed());
        
        addNewTab();
        pnlTabs.add(btnNewTab);
    }
    
    public void loadFiles(DirectoryContent dirContent) {
        dirContent.getDir().loadFiles();
        
        for (strFile file : dirContent.getDir().getList()) {
            FileItem fileItem = new FileItem(file);
            dirContent.getPnlFileContainer().add(fileItem);
            
            Path path = file.getPath();
            MouseListener m1 = new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        if (Files.isReadable(path)) {
                            if (file.getFile().isDirectory()) {
                                File file = new File(path.toString());
                                dirContent.getPnlFileContainer().removeAll();
                                dirContent.setDir(new Directory((Path) path));
                                loadFiles(dirContent);
                            } else {
                                try {
                                    Desktop.getDesktop().open(file.getFile());
                                } catch (IOException ex) {
                                    Logger.getLogger(DirectoryContent.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Acceso denegado");
                        }
                    }
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        popupMenuFile.show(fileItem,evt.getX(),evt.getY());
                        if (file.getFile().isDirectory()) {
                            menuChangeName.setEnabled(false);
                            menuCopy.setEnabled(false);
                            menuCut.setEnabled(false);
                            menuDelete.setEnabled(false);
                        } else {
                            menuChangeName.setEnabled(true);
                            menuCopy.setEnabled(true);
                            menuCut.setEnabled(true);
                            menuDelete.setEnabled(true);
                        }
                        menuProperties.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (dirContent.getPnlDirContent().getComponentCount()> 1) {
                                    for (int i = 1; i < dirContent.getPnlDirContent().getComponentCount(); i++) {
                                        dirContent.getPnlDirContent().remove(i);
                                    }
                                }
                                dirContent.getPnlDirContent().add(new FileProperties(file));
                                dirContent.getPnlDirContent().revalidate();
                                dirContent.setLayoutResponsive();
                            }
                        });
                        for (ActionListener actionListener : menuCut.getActionListeners()) {
                            menuCut.removeActionListener(actionListener);
                        }
                        if (menuCut.getActionListeners().length <= 1) {
                            menuCut.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    selectedFile = fileItem.getFile();
                                    selectedType= "cut";
                                }
                            });
                        }
                        menuCopy.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                selectedFile = file.getFile();
                                selectedType= "copy";
                                System.out.println(selectedFile);
                            }
                        });
                        menuOpen.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (Files.isReadable(path)) {
                                    if (file.getFile().isDirectory()) {
                                        File file = new File(path.toString());
                                        dirContent.getPnlFileContainer().removeAll();
                                        dirContent.setDir(new Directory((Path) path));
                                        loadFiles(dirContent);
                                    } else {
                                        try {
                                            Desktop.getDesktop().open(file.getFile());
                                        } catch (IOException ex) {
                                            Logger.getLogger(DirectoryContent.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Acceso denegado");
                                }
                            }
                        });
                        popupMenuFile.add(menuProperties);
                    }
                }
            };
            fileItem.addMouseListener(m1);
        }
        
        
        dirContent.getPnlFileContainer().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    popupMenuFile.show(dirContent.getPnlFileContainer(),evt.getX(),evt.getY());
                    popupMenuInDirectory.show(dirContent.getPnlFileContainer(),evt.getX(),evt.getY());
                    if (selectedFile==null) menuPaste.setEnabled(false);
                    else  menuPaste.setEnabled(true);
                    menuPaste.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            if (selectedFile!=null) {
                                File filex = selectedFile;
                                if (selectedType=="cut") {
                                    // renaming the file and moving it to a new location 
                                    if(filex.renameTo(new File(dirContent.getDir().getPath()+ File.separator +filex.getName()))) { 
                                        // if file copied successfully then delete the original file 
                                        filex.delete();
                                        dirContent.getPnlFileContainer().removeAll();
                                        dirContent.setDir(new Directory(dirContent.getDir().getPath()));
                                        loadFiles(dirContent);
                                    } else { 
                                        JOptionPane.showMessageDialog(null, "El archivo no se pudo mover");
                                    } 
                                } else {

                                }
                                selectedFile=null;
                            } else {
                                
                            }
                        }
                    });
                    menuDirectoryProperties.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                if (dirContent.getPnlDirContent().getComponentCount()> 1) {
                                    for (int i = 1; i < dirContent.getPnlDirContent().getComponentCount(); i++) {
                                        dirContent.getPnlDirContent().remove(i);
                                    }
                                }
                                dirContent.getPnlDirContent().add(new FileProperties(new strFile(dirContent.getDir().getFile())));
                                dirContent.getPnlDirContent().revalidate();
                                dirContent.setLayoutResponsive();
                        }
                    });
                }
            }
        });
        
        dirContent.repaintFiles();
        dirContent.setLayoutResponsive();
        
        dirContent.getTxtDir().setText(dirContent.getDir().getName());
        
        dirContent.getTotalFiles().setText(dirContent.getDir().getList().size() + " elements");
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
        
        loadFiles(content);
        
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
        popupMenuFile = new javax.swing.JPopupMenu();
        menuOpen = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuCut = new javax.swing.JMenuItem();
        menuCopy = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuDelete = new javax.swing.JMenuItem();
        menuChangeName = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuProperties = new javax.swing.JMenuItem();
        popupMenuInDirectory = new javax.swing.JPopupMenu();
        menuPaste = new javax.swing.JMenuItem();
        hr = new javax.swing.JPopupMenu.Separator();
        menuDirectoryProperties = new javax.swing.JMenuItem();
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

        menuOpen.setText("Abrir");
        popupMenuFile.add(menuOpen);
        popupMenuFile.add(jSeparator3);

        menuCut.setText("Cortar");
        menuCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCutActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuCut);

        menuCopy.setText("Copiar");
        menuCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCopyActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuCopy);
        popupMenuFile.add(jSeparator2);

        menuDelete.setText("Eliminar");
        popupMenuFile.add(menuDelete);

        menuChangeName.setText("Cambiar nombre");
        popupMenuFile.add(menuChangeName);
        popupMenuFile.add(jSeparator1);

        menuProperties.setText("Propiedades");
        popupMenuFile.add(menuProperties);

        menuPaste.setText("Pegar");
        popupMenuInDirectory.add(menuPaste);
        popupMenuInDirectory.add(hr);

        menuDirectoryProperties.setText("Propiedades");
        popupMenuInDirectory.add(menuDirectoryProperties);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Explorer");

        body.setBackground(new java.awt.Color(239, 241, 248));

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

    private void menuCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCopyActionPerformed

    private void menuCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCutActionPerformed

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
    private javax.swing.JPopupMenu.Separator hr;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menuChangeName;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuDirectoryProperties;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuProperties;
    private javax.swing.JPanel pnlAside;
    private javax.swing.JPanel pnlQuickAccess;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JPopupMenu popupMenuFile;
    private javax.swing.JPopupMenu popupMenuInDirectory;
    private javax.swing.JTabbedPane tabContent;
    // End of variables declaration//GEN-END:variables

}