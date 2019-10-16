package Components;

import CRUD.strFile;
import com.sun.glass.ui.Size;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import javax.swing.ImageIcon;

public class FileItem extends javax.swing.JPanel {

    File file;
    
    public FileItem(strFile file) {
        initComponents();
        this.setSize(108,110);
        this.setPreferredSize(new Dimension(this.getSize()));
        this.file = file.getFile();
        
        fileIcon.setSize(96,62);
        fileIcon.setIcon(file.getIcon(fileIcon.getSize()));
        fileName.setText(file.getSimpleName());
        this.setToolTipText(file.getFile().getName());
    }
    public FileItem() {
        initComponents();
        this.setSize(108,110);
        this.setPreferredSize(new Dimension(this.getSize()));
    }

    public File getFile() {
        return file;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pnlFile = new javax.swing.JPanel();
        fileIcon = new javax.swing.JLabel();
        fileName = new javax.swing.JLabel();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(69, 72, 88)));

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItem2);

        setBackground(new java.awt.Color(229, 243, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(108, 110));
        setMinimumSize(new java.awt.Dimension(108, 110));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        pnlFile.setOpaque(false);

        fileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileIcon.setMaximumSize(new java.awt.Dimension(96, 62));
        fileIcon.setMinimumSize(new java.awt.Dimension(96, 62));
        fileIcon.setPreferredSize(new java.awt.Dimension(96, 62));

        fileName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileName.setText("file name");
        fileName.setMaximumSize(new java.awt.Dimension(96, 30));
        fileName.setMinimumSize(new java.awt.Dimension(96, 30));
        fileName.setPreferredSize(new java.awt.Dimension(96, 30));

        javax.swing.GroupLayout pnlFileLayout = new javax.swing.GroupLayout(pnlFile);
        pnlFile.setLayout(pnlFileLayout);
        pnlFileLayout.setHorizontalGroup(
            pnlFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFileLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        pnlFileLayout.setVerticalGroup(
            pnlFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFileLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(fileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setOpaque(true);
        this.repaint();
//        checkFile.setVisible(true);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setOpaque(false);
        this.repaint();
    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
         if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fileIcon;
    private javax.swing.JLabel fileName;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel pnlFile;
    // End of variables declaration//GEN-END:variables
}
