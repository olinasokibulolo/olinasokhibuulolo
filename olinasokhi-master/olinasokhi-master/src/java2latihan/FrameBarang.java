package java2latihan;
import java.sql.Connection;
import java.sql.ResultSet ;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Asus
 */
public class FrameBarang extends javax.swing.JFrame {
private Statement stat;
private ResultSet rs;
DefaultTableModel model;
private String judulKolom[]={"No.","Kode Barang","Nama Barang","Kategori","Satuan","Harga","Jumlah"};
private String[][] dataBarang;
String objKategori[]={"atk","seragam","alat sport","makanan"}; 
private void setModeltabel(){
    model = new DefaultTableModel(dataBarang,judulKolom);
    tblBarang.setModel(model);
}

private void view_data(){
    model.getDataVector().removeAllElements();
    try{
        int no=1;
        String sql="select*from barang";
        koneksi objkoneksi=new koneksi();
        Connection con=objkoneksi.bukakoneksi();
        stat=con.createStatement();
        rs=stat.executeQuery(sql);
        while(rs.next()){
            model.addRow(new Object[]{no++,rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6)});
        }
    }catch (Exception e){
    }
}
    /**
     * Creates new form FrameBarang
     */
    public FrameBarang() {
       initComponents();
        setModeltabel();
        view_data();
        
    tblBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent e){
        int row=tblBarang.getSelectedRow();
        if(row!=-1){
            String tKode =(tblBarang.getModel().getValueAt(row, 1).toString());
                    String tNama =(tblBarang.getModel().getValueAt(row, 2).toString());
                    String tKategori =(tblBarang.getModel().getValueAt(row, 3).toString());
                    String tSatuan =(tblBarang.getModel().getValueAt(row, 4).toString());
                    String tHarga =(tblBarang.getModel().getValueAt(row, 5).toString());
                    String tJumlah =(tblBarang.getModel().getValueAt(row, 6).toString());
            
            txtkode.setText(tKode);
            txtnamabarang.setText(tNama);
            txtjumlah.setText(tJumlah);
            btnubah.setEnabled(true);
            btnhapus.setEnabled(true);
            btnsimpan.setEnabled(false);
            
            cbkategori.setSelectedItem(tKategori);
            if (tSatuan.equals("pcs")){
                rbpcs.setSelected(true);
            }else if(tSatuan.equals("box")){
                rbbox.setSelected(true);
            }else{
                rbrim.setSelected(true);
            }
        }
     }
    });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        cbkategori = new javax.swing.JComboBox();
        rbpcs = new javax.swing.JRadioButton();
        rbbox = new javax.swing.JRadioButton();
        rbrim = new javax.swing.JRadioButton();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FORM BARANG");

        jLabel2.setText("Kode Barang :");

        jLabel3.setText("Nama Barang :");

        jLabel4.setText("Kategori :");

        jLabel5.setText("Satuan :");

        jLabel6.setText("Harga :");

        jLabel7.setText("Jumlah :");

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--pilih kategori--" }));
        cbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkategoriActionPerformed(evt);
            }
        });

        btnGroupSatuan.add(rbpcs);
        rbpcs.setText("pcs");

        rbbox.setText("box");

        rbrim.setText("rim");

        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthargaKeyTyped(evt);
            }
        });

        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });

        btnsimpan.setText("simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setText("batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnubah.setText("ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(275, 275, 275))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnbatal)
                        .addGap(18, 18, 18)
                        .addComponent(btnubah)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(rbbox)
                        .addGap(18, 18, 18)
                        .addComponent(rbrim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbpcs)
                                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbpcs)
                                .addComponent(rbbox)
                                .addComponent(rbrim))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6))
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnbatal)
                    .addComponent(btnubah)
                    .addComponent(btnhapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkategoriActionPerformed

    private void txthargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyTyped
        // TODO add your handling code here:
        char cDigit = evt.getKeyChar();
        if(txtharga.getText().length()<10){
            if(!Character.isDigit(cDigit)) {
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }                                 
//GEN-LAST:event_txthargaKeyTyped
    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
        // TODO add your handling code here:
        char cDigit = evt.getKeyChar();
        if(txtjumlah.getText().length()<5) {
            if(!Character.isDigit(cDigit)){
                evt.consume();
            }
        }else{
            evt.consume();
            }
    }//GEN-LAST:event_txtjumlahKeyTyped

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String satuan;
 if(rbpcs.isSelected()){  
 satuan = "pcs";
 }else if(rbbox.isSelected()){
 satuan = "box";
 }else{
 satuan = "rim";
 }
 try{
 koneksi objkoneksi=new koneksi();
 Connection con=objkoneksi.bukakoneksi();
 String sql="INSERT INTO barang VALUES('"+txtkode.getText()+"','"+txtnamabarang.getText()+"','"+cbkategori.getSelectedItem()
 +"','"+satuan+"','"+txtharga.getText()+"','"+txtjumlah.getText()+"')";
 stat = con.createStatement();
 stat.execute(sql);

 JOptionPane.showMessageDialog(null, "Data Berhasil di Input");

 txtkode.setText("");
 txtnamabarang.setText("");
 txtharga.setText("");
 txtjumlah.setText("");
 cbkategori.setSelectedIndex(0);
 rbpcs.setSelected(false);
 rbbox.setSelected(false);
 rbrim.setSelected(false);
 txtkode.requestFocus();
 
 }
 catch (Exception e)
 {
 System.out.println("gagal="+e.getMessage());
 }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        awal();
    }
        private void awal(){
        txtkode.setText("");
 txtnamabarang.setText("");
 txtharga.setText("");
 txtjumlah.setText("");
 cbkategori.setSelectedIndex(0);
 rbpcs.setSelected(false);
 rbbox.setSelected(false);
 rbrim.setSelected(false);
 txtkode.requestFocus();
        }

    private static class tblBarang {

        private static int getSelectedRow() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static Object getModel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setModel(DefaultTableModel model) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static Object getSelectionModel() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public tblBarang() {
        }
    }
    }//GEN-LAST:event_btnbatalActionPerformed
    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        
try{
koneksi objkoneksi=new koneksi();
Connection con=objkoneksi.bukakoneksi();
String sql="DELETE from barang where kodebarang='"+txtkode.getText()+"' ";
stat = con.createStatement();
stat.executeUpdate(sql);
JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
awal();
view_data();
}
catch (Exception e)
{
System.out.println("gagal="+e.getMessage());
}
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        if(cbkategori.getSelectedIndex()!=0){
    String satuan;
    if(rbpcs.isSelected()){
        satuan="pcs";
    }else if(rbbox.isSelected()){
        satuan="box";
    }else if(rbrim.isSelected()){
        satuan="rim";
    }else{
        satuan=null;
    }
        try{
            koneksi objkoneksi=new koneksi();
Connection con=objkoneksi.bukakoneksi();
String sql="UPDATE barang SET namabarang='"+txtnamabarang.getText()+"',
kategori='"+cbkategori.getSelectedItem()+"',"
+ " satuan='"+satuan+"', harga='"+txtharga.getText()+"',
jumlah='"+txtjumlah.getText()+"' where kodebarang='"+txtkode.getText()+"' ";
stat = con.createStatement();
stat.executeUpdate(sql);
javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
awal();
view_data();
}
catch (Exception e)
{
System.out.println("gagal="+e.getMessage());
}
}else{
JOptionPane.showMessageDialog(null, "Pilih kategori barang","notifikasi",2);
    }//GEN-LAST:event_btnubahActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameBarang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox cbkategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbbox;
    private javax.swing.JRadioButton rbpcs;
    private javax.swing.JRadioButton rbrim;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnamabarang;
    // End of variables declaration//GEN-END:variables
}
