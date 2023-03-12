import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Search extends javax.swing.JFrame {

    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
        Connect();
        table_User();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst2;
    ResultSet rs2;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Policlinici","root","1234");
         // jdbc:mysql://localhost:3306/Policlinici?zeroDateTimeBehavior=CONVERT_TO_NULL
        //jdbc:mysql://localhost:3306/Policlinici?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
        con =DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinici","root","1234");
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
     public void table_User()
    {
     
        
     
         try {
            pst=con.prepareStatement("{call select_orars()}");
            rs=pst.executeQuery();
        ResultSetMetaData Rsm=rs.getMetaData();
        int c;   
c=Rsm.getColumnCount(); 
DefaultTableModel df= (DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        
        while(rs.next())
        {
            
        Vector v2=new Vector();
        
        for(int i=1;i<=c;i++)
        {
       
        v2.add(rs.getString("id"));
      
        v2.add(rs.getString("utype"));
        v2.add(rs.getString("tip_zi"));
        v2.add(rs.getString("ora_start"));
        v2.add(rs.getString("minut_start"));
        v2.add(rs.getString("ora_sfarsit"));
        v2.add(rs.getString("minut_sfarsit"));
        v2.add(rs.getString("locatie"));
      
        }
        df.addRow(v2);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Pacient.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
     void table_User2(String nume , String prenume , String functie)
     { try {
    
     
    	 
            if(functie.equals("") && prenume.equals(""))
            {    pst=con.prepareStatement("{call select_search1(?)} ");
                pst.setString(1,nume);
            }    
            else
                if(functie.equals("") && nume.equals(""))
                { pst=con.prepareStatement("{call select_search2(?)} ");
                    pst.setString(1,prenume);
               
                }     
                else
                    if(prenume.equals("") && nume.equals(""))
                    {  pst=con.prepareStatement("{call select_search3(?)}");
                        pst.setString(1,functie);    
     }
                    else           
            if(functie.equals("") )
       	 { pst=con.prepareStatement("{call select_search4(?,?)} ");
               pst.setString(1,nume);
               pst.setString(2,prenume);
              
               
       	 } 
            else 	 
       	 if(nume.equals("") )
       	 { pst=con.prepareStatement("{call select_search5(?,?)} ");
               pst.setString(1,functie);
               pst.setString(2,prenume);
             
       	 } 
       	 else
       	 if(prenume.equals("") )
       	 { pst=con.prepareStatement("{call select_search6(?,?)} ");
               pst.setString(1,functie);
               pst.setString(2,nume);
             
       	 } 
       	 else  
         { pst=con.prepareStatement("{call select_search7(?,?,?)}");
             pst.setString(1,nume);
             pst.setString(2,prenume);
             pst.setString(3,functie);  
             
         }
           
    	
            
            
            
              
         rs=pst.executeQuery();
        ResultSetMetaData Rsm=rs.getMetaData();
        int c;   
c=Rsm.getColumnCount(); 
DefaultTableModel df= (DefaultTableModel)jTable2.getModel();
        df.setRowCount(0);
        
        while(rs.next())
        {
            
        Vector v2=new Vector();
        
        for(int i=1;i<=c;i++)
        {
        v2.add(rs.getString("id"));
        v2.add(rs.getString("utype"));
        v2.add(rs.getString("tip_zi"));
        v2.add(rs.getString("ora_start"));
        v2.add(rs.getString("minut_start"));
        v2.add(rs.getString("ora_sfarsit"));
        v2.add(rs.getString("minut_sfarsit"));
        v2.add(rs.getString("locatie"));
        }
        df.addRow(v2);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Pacient.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Search_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnume = new javax.swing.JTextField();
        txtprenume = new javax.swing.JTextField();
        txtfunctie = new javax.swing.JTextField();
        Exit_Button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Functie", "Tip zi", "ora_start", "minut_start", "Ora sfarsit", "Minut sfarsit", "Locatie"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Search_Button.setText("Search");
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Nume");

        jLabel2.setText("Prenume");

        jLabel3.setText("Functie");

        Exit_Button.setText("Exit");
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Functie", "Tip zi", "Ora start", "Minu start", "Ora sfarsit", "Minut sfarsit", "Locatie"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtfunctie, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtprenume, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(txtnume, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Exit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfunctie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        this.setVisible(false);
    }                                           

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
         String nume=txtnume.getText();
        String prenume=txtprenume.getText();
        String functie=txtfunctie.getText();
        table_User2(nume,prenume,functie);
      
    }                                             

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Exit_Button;
    private javax.swing.JButton Search_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtfunctie;
    private javax.swing.JTextField txtnume;
    private javax.swing.JTextField txtprenume;
    // End of variables declaration                   
}
