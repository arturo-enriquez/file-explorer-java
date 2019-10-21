package Components;

import CRUD.strFile;
import java.awt.Dimension;

public class FileProperties extends javax.swing.JPanel {

    public FileProperties(strFile file) {
        initComponents();
        pnlImageIcon.setSize(260,154);
        
        ImageIcon.setIcon(file.getIcon(pnlImageIcon.getSize()));
        lblFileTitle.setText(file.getSimpleName());
        lblFileType.setText(file.getType());
        
        pnlProperties.add(new FileProperty());
        pnlProperties.add(new FileProperty());
        pnlProperties.add(new FileProperty());
        pnlProperties.add(new FileProperty());
        pnlProperties.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlImageIcon = new javax.swing.JPanel();
        ImageIcon = new javax.swing.JLabel();
        lblFileTitle = new javax.swing.JLabel();
        lblFileType = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        pnlProperties = new javax.swing.JPanel();

        setBackground(new java.awt.Color(248, 250, 252));
        setMaximumSize(new java.awt.Dimension(260, 10000000));

        pnlImageIcon.setBackground(new java.awt.Color(227, 233, 238));
        pnlImageIcon.setOpaque(false);

        ImageIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlImageIconLayout = new javax.swing.GroupLayout(pnlImageIcon);
        pnlImageIcon.setLayout(pnlImageIconLayout);
        pnlImageIconLayout.setHorizontalGroup(
            pnlImageIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlImageIconLayout.setVerticalGroup(
            pnlImageIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        lblFileTitle.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblFileTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFileTitle.setText("File Name");

        lblFileType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFileType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFileType.setText("Type");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/close.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);
        scroll.setForeground(new java.awt.Color(255, 255, 255));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerifyInputWhenFocusTarget(false);

        pnlProperties.setBackground(new java.awt.Color(248, 250, 252));
        pnlProperties.setMaximumSize(new java.awt.Dimension(260, 241));
        pnlProperties.setMinimumSize(new java.awt.Dimension(260, 0));
        pnlProperties.setPreferredSize(new java.awt.Dimension(259, 30));
        pnlProperties.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        scroll.setViewportView(pnlProperties);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFileTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFileType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(pnlImageIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlImageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblFileTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFileType)
                .addGap(29, 29, 29)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        
        this.setVisible(false);
        
        
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageIcon;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblFileTitle;
    private javax.swing.JLabel lblFileType;
    private javax.swing.JPanel pnlImageIcon;
    private javax.swing.JPanel pnlProperties;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
