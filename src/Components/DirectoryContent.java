package Components;

import CRUD.Directory;
import CRUD.strFile;
import Components.FileItem;
import Components.FileProperties;
import com.sun.glass.ui.Clipboard;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DirectoryContent extends javax.swing.JPanel {

    private Directory dir;
    private strFile selectedFile;

    public DirectoryContent(Directory dir) {
        initComponents();
        this.pnlFileContainer.setSize(new Dimension(600, 400));
        this.dir = dir;
        
        loadFiles(this.dir);
    }
    
    private void setDir(Directory dir){
        this.dir = dir;
    }
    public Directory getDir() {
        return dir;
    }
    
    public void loadFiles(Directory dir) {
        dir.loadFiles();
        
        for (strFile file : dir.getList()) {
            FileItem fileItem = new FileItem(file);
            pnlFileContainer.add(fileItem);
            
            Path path = file.getPath();
            
            fileItem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        if (Files.isReadable(path)) {
                            if (file.getFile().isDirectory()) {
                                File file = new File(path.toString());
                                pnlFileContainer.removeAll();
                                setDir(new Directory((Path) path));
                                loadFiles(getDir());
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
                        selectedFile = (strFile) file;
                        popupFile.show(fileItem,evt.getX(),evt.getY());
                    }
                }
            });
        }
        
        repaintFiles();
        setLayoutResponsive(pnlFileContainer.getComponentCount());
        
        txtDir.setText(dir.getName());
        
        totalFiles.setText(dir.getList().size() + " elements");
    }
    
    public void repaintFiles(){
        pnlFileContainer.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupFile = new javax.swing.JPopupMenu();
        menuCut = new javax.swing.JMenuItem();
        menuCopy = new javax.swing.JMenuItem();
        menuPaste = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuShowProperties = new javax.swing.JMenuItem();
        popupFolder = new javax.swing.JPopupMenu();
        pnlContent = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        pnlDir = new javax.swing.JPanel();
        lblDirIcon = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        lblDirIcon1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        pnlDirContent = new javax.swing.JPanel();
        scrollFileContainer = new javax.swing.JScrollPane();
        pnlFileContainer = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        totalFiles = new javax.swing.JLabel();

        menuCut.setText("Cortar");
        menuCut.setIconTextGap(0);
        popupFile.add(menuCut);

        menuCopy.setText("Copiar");
        menuCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCopyActionPerformed(evt);
            }
        });
        popupFile.add(menuCopy);

        menuPaste.setText("Pegar");
        popupFile.add(menuPaste);
        popupFile.add(jSeparator1);

        menuShowProperties.setText("Propiedades");
        menuShowProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuShowPropertiesActionPerformed(evt);
            }
        });
        popupFile.add(menuShowProperties);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setMaximumSize(new java.awt.Dimension(904, 94));
        pnlHeader.setMinimumSize(new java.awt.Dimension(0, 0));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/left.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusable(false);
        btnBack.setMaximumSize(new java.awt.Dimension(24, 24));
        btnBack.setPreferredSize(new java.awt.Dimension(24, 24));

        btnReturn.setBackground(new java.awt.Color(255, 255, 255));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/right.png"))); // NOI18N
        btnReturn.setBorder(null);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.setFocusable(false);
        btnReturn.setMaximumSize(new java.awt.Dimension(24, 24));
        btnReturn.setPreferredSize(new java.awt.Dimension(24, 24));

        btnUp.setBackground(new java.awt.Color(255, 255, 255));
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/up.png"))); // NOI18N
        btnUp.setBorder(null);
        btnUp.setBorderPainted(false);
        btnUp.setContentAreaFilled(false);
        btnUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUp.setFocusable(false);
        btnUp.setMaximumSize(new java.awt.Dimension(24, 24));
        btnUp.setPreferredSize(new java.awt.Dimension(24, 24));
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        pnlDir.setBackground(new java.awt.Color(255, 255, 255));
        pnlDir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 236, 242)));

        lblDirIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/folder.png"))); // NOI18N

        txtDir.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txtDir.setText("Documentos");
        txtDir.setBorder(null);
        txtDir.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDir.setMinimumSize(new java.awt.Dimension(100, 18));
        txtDir.setOpaque(false);
        txtDir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirFocusLost(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/refresh.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.setFocusable(false);
        btnRefresh.setMaximumSize(new java.awt.Dimension(24, 24));
        btnRefresh.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout pnlDirLayout = new javax.swing.GroupLayout(pnlDir);
        pnlDir.setLayout(pnlDirLayout);
        pnlDirLayout.setHorizontalGroup(
            pnlDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDirLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblDirIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDir, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        pnlDirLayout.setVerticalGroup(
            pnlDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDirIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnlSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 236, 242)));

        lblDirIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/search.png"))); // NOI18N

        txtSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSearch.setText("Search");
        txtSearch.setBorder(null);
        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearch.setMinimumSize(new java.awt.Dimension(100, 18));
        txtSearch.setOpaque(false);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblDirIcon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDirIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        pnlDirContent.setBackground(new java.awt.Color(244, 244, 244));
        pnlDirContent.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlDirContent.setLayout(new javax.swing.BoxLayout(pnlDirContent, javax.swing.BoxLayout.LINE_AXIS));

        scrollFileContainer.setBackground(new java.awt.Color(255, 255, 255));
        scrollFileContainer.setBorder(null);
        scrollFileContainer.getVerticalScrollBar().setUnitIncrement(16);

        pnlFileContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlFileContainer.setCursor(null);
        pnlFileContainer.setMinimumSize(new java.awt.Dimension(200, 98));
        pnlFileContainer.setPreferredSize(new java.awt.Dimension(600, 400));
        pnlFileContainer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnlFileContainerComponentResized(evt);
            }
        });
        pnlFileContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 12));
        scrollFileContainer.setViewportView(pnlFileContainer);

        pnlDirContent.add(scrollFileContainer);

        pnlFooter.setBackground(new java.awt.Color(255, 255, 255));

        totalFiles.setText("7 elementos     |     1 Seleccionado :v");

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalFiles)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalFiles)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(pnlDirContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDirContent, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setLayoutResponsive(int length) {
        FileItem item = new FileItem();
        int containerWidth = this.pnlFileContainer.getWidth(),
                itemWidth = item.getWidth() + 20,
                itemHeight = item.getHeight() + 12,
                spaces = (containerWidth / itemWidth),
                height = itemHeight * ((length - 1) / spaces) + itemHeight + 30;

        if (height > 0) {
            this.pnlFileContainer.setPreferredSize(new Dimension(0, height));
        }
    }
    private void pnlFileContainerComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlFileContainerComponentResized
        setLayoutResponsive(pnlFileContainer.getComponentCount());
    }//GEN-LAST:event_pnlFileContainerComponentResized

    // input focus
    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        String search = txtSearch.getText();
        search.replace(" ", "");
        if (search.equals("")) {
            txtSearch.setText("Search");
        }
    }//GEN-LAST:event_txtSearchFocusLost
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Search")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained
    private void txtDirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirFocusGained
        txtDir.setText(dir.getPath().toString());
    }//GEN-LAST:event_txtDirFocusGained
    private void txtDirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirFocusLost
        txtDir.setText(dir.getName());
    }//GEN-LAST:event_txtDirFocusLost

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        pnlFileContainer.removeAll();
        setDir(new Directory(this.dir.getPath().getParent()));
        loadFiles(getDir());
    }//GEN-LAST:event_btnUpActionPerformed

    private void menuCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCopyActionPerformed
        
    }//GEN-LAST:event_menuCopyActionPerformed

    private void menuShowPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuShowPropertiesActionPerformed
        pnlDirContent.add(new FileProperties(this.selectedFile));
        pnlDirContent.repaint();
    }//GEN-LAST:event_menuShowPropertiesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUp;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblDirIcon;
    private javax.swing.JLabel lblDirIcon1;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuShowProperties;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDir;
    private javax.swing.JPanel pnlDirContent;
    private javax.swing.JPanel pnlFileContainer;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPopupMenu popupFile;
    private javax.swing.JPopupMenu popupFolder;
    private javax.swing.JScrollPane scrollFileContainer;
    private javax.swing.JLabel totalFiles;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
