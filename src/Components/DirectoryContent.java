package Components;

import CRUD.Directory;
import CRUD.strFile;
import Components.FileItem;
import Components.FileProperties;
import java.awt.Dimension;

public class DirectoryContent extends javax.swing.JPanel {

    Directory dir;

    public DirectoryContent(Directory dir) {
        initComponents();
        this.pnlFileContainer.setSize(new Dimension(600, 400));

        this.dir = dir;
        
        loadFiles(this.dir);

        setLayoutResponsive(pnlFileContainer.getComponentCount());

//        pnlDirContent.add(new FileProperties());
    }

    public void loadFiles(Directory dir) {
        dir.loadFiles();
        for (strFile file : dir.getList()) {
            pnlFileContainer.add(new FileItem(file));
//            setTimeout(() -> System.out.println("test"), 100);
        }
        
        txtDir.setText(dir.getPath().toString());
        
        totalFiles.setText(dir.getList().size() + " elementos");
    }

    private void setLayoutResponsive(int length) {
        FileItem item = new FileItem(new strFile(this.dir.getPath().toFile()));
        int containerWidth = this.pnlFileContainer.getWidth(),
                itemWidth = item.getWidth() + 30,
                itemHeight = item.getHeight() + 30,
                spaces = (containerWidth / itemWidth),
                height = itemHeight * ((length - 1) / spaces) + itemHeight + 30;

        if (height > 0) {
            this.pnlFileContainer.setPreferredSize(new Dimension(0, height));
        }
    }

    
    public static void setTimeout(Runnable runnable, int delay){
        try {
            Thread.sleep(delay);
            runnable.run();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        txtDir = new javax.swing.JTextField();
        lblDirIcon = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnShowHidden = new javax.swing.JButton();
        btnNewFolder = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnShowMenu = new javax.swing.JButton();
        pnlDirContent = new javax.swing.JPanel();
        scrollFileContainer = new javax.swing.JScrollPane();
        pnlFileContainer = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        totalFiles = new javax.swing.JLabel();

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

        txtDir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtDir.setText("Documentos");
        txtDir.setBorder(null);
        txtDir.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblDirIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/folder.png"))); // NOI18N

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/refresh.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.setFocusable(false);
        btnRefresh.setMaximumSize(new java.awt.Dimension(24, 24));
        btnRefresh.setPreferredSize(new java.awt.Dimension(24, 24));

        btnShowHidden.setBackground(new java.awt.Color(255, 255, 255));
        btnShowHidden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/eye-invisible.png"))); // NOI18N
        btnShowHidden.setBorder(null);
        btnShowHidden.setBorderPainted(false);
        btnShowHidden.setContentAreaFilled(false);
        btnShowHidden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowHidden.setFocusable(false);
        btnShowHidden.setMaximumSize(new java.awt.Dimension(24, 24));
        btnShowHidden.setPreferredSize(new java.awt.Dimension(24, 24));

        btnNewFolder.setBackground(new java.awt.Color(255, 255, 255));
        btnNewFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/folder-plus.png"))); // NOI18N
        btnNewFolder.setBorder(null);
        btnNewFolder.setBorderPainted(false);
        btnNewFolder.setContentAreaFilled(false);
        btnNewFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewFolder.setFocusable(false);
        btnNewFolder.setMaximumSize(new java.awt.Dimension(24, 24));
        btnNewFolder.setPreferredSize(new java.awt.Dimension(24, 24));

        btnAll.setBackground(new java.awt.Color(255, 255, 255));
        btnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/check-list.png"))); // NOI18N
        btnAll.setBorder(null);
        btnAll.setBorderPainted(false);
        btnAll.setContentAreaFilled(false);
        btnAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAll.setFocusable(false);
        btnAll.setMaximumSize(new java.awt.Dimension(24, 24));
        btnAll.setPreferredSize(new java.awt.Dimension(24, 24));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/search.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusable(false);
        btnSearch.setMaximumSize(new java.awt.Dimension(24, 24));
        btnSearch.setPreferredSize(new java.awt.Dimension(24, 24));

        btnShowMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnShowMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/menu.png"))); // NOI18N
        btnShowMenu.setBorder(null);
        btnShowMenu.setBorderPainted(false);
        btnShowMenu.setContentAreaFilled(false);
        btnShowMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowMenu.setFocusable(false);
        btnShowMenu.setMaximumSize(new java.awt.Dimension(24, 24));
        btnShowMenu.setPreferredSize(new java.awt.Dimension(24, 24));

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
                .addGap(18, 18, 18)
                .addComponent(lblDirIcon)
                .addGap(16, 16, 16)
                .addComponent(txtDir, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnShowHidden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDirIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pnlDirContent.setBackground(new java.awt.Color(244, 244, 244));
        pnlDirContent.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlDirContent.setLayout(new javax.swing.BoxLayout(pnlDirContent, javax.swing.BoxLayout.LINE_AXIS));

        scrollFileContainer.setBackground(new java.awt.Color(255, 255, 255));
        scrollFileContainer.setBorder(null);

        pnlFileContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlFileContainer.setCursor(null);
        pnlFileContainer.setMinimumSize(new java.awt.Dimension(84, 98));
        pnlFileContainer.setPreferredSize(new java.awt.Dimension(600, 400));
        pnlFileContainer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnlFileContainerComponentResized(evt);
            }
        });
        pnlFileContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 30));
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
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDirContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlDirContent, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 924, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlFileContainerComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlFileContainerComponentResized
        setLayoutResponsive(pnlFileContainer.getComponentCount());
    }//GEN-LAST:event_pnlFileContainerComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewFolder;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowHidden;
    private javax.swing.JButton btnShowMenu;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel lblDirIcon;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDirContent;
    private javax.swing.JPanel pnlFileContainer;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrollFileContainer;
    private javax.swing.JLabel totalFiles;
    private javax.swing.JTextField txtDir;
    // End of variables declaration//GEN-END:variables
}
