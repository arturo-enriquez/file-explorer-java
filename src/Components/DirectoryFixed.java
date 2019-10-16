package Components;

public class DirectoryFixed extends javax.swing.JPanel {

    public DirectoryFixed() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dirIcon = new javax.swing.JLabel();
        dirName = new javax.swing.JLabel();

        setBackground(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(186, 31));
        setMinimumSize(new java.awt.Dimension(186, 31));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(186, 31));

        dirIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/folder.png"))); // NOI18N

        dirName.setText("Directory Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dirIcon)
                .addGap(12, 12, 12)
                .addComponent(dirName, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dirIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(dirName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dirIcon;
    private javax.swing.JLabel dirName;
    // End of variables declaration//GEN-END:variables
}
