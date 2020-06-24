/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Autori;
import BLL.KategoriaLibrit;
import BLL.Libri;
import DAL.AutoriRepository;
import DAL.CrudFormException;
import DAL.KategoriaLibritRepository;
import DAL.LibraryException;
import DAL.LibriRepository;
import GUI.Model.AuthorComboBoxModel;
import GUI.Model.BookTableModel;
import GUI.Model.CategoryComboBoxModel;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static java.time.Clock.system;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lenovo
 */
public class RegisterBookGUI extends javax.swing.JFrame {

    KategoriaLibritRepository klrepo = new KategoriaLibritRepository();
    CategoryComboBoxModel ccbox = new CategoryComboBoxModel();
    
    AutoriRepository arepo = new AutoriRepository();
    AuthorComboBoxModel acbox = new AuthorComboBoxModel();
    
    LibriRepository lrepo = new LibriRepository();
    BookTableModel btm = new BookTableModel();
    /**
     * Creates new form RegisterBookGUI
     */
    public RegisterBookGUI() {
        initComponents();
         loadCategoryComboBox();
         this.tableSelectedIndexChange();
         loadAuthorComboBox();
         loadBookTable();
    }
    

    
    public void tableSelectedIndexChange(){
         final ListSelectionModel rowSM = table.getSelectionModel();
         rowSM.addListSelectionListener(new ListSelectionListener(){
             
             @Override
             public void valueChanged(ListSelectionEvent e) {
                    if(e.getValueIsAdjusting()){
                    return;             }
                    
                    ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                    int selectedIndex = rowSM.getAnchorSelectionIndex();
                    if(selectedIndex > -1){
                    Libri l = btm.getLibri(selectedIndex);
                    TitleTextField.setText(l.getLTitulli().toString());
                    PublisherTextField.setText(l.getLShtepiaBotuese().toString());
                    PublishigYearDate.setYear(l.getLVitiBotimit());
                    
                    
                    CategoryComboBox.setSelectedItem(l.getLKategoriaId());
                    
                    
                     
                    
                    QuantityTextField.setText(Integer.toString(l.getLSasia()));
                    PriceTextField.setText(Double.toString(l.getLCmimiMujor()));
                    //AuthorComboBox.setSelectedItem(l.getAutoriName(0));
                    //AuthorComboBox2.setSelectedItem(l.getAutoriName(1));
                    //System.out.println(l.getIsbn());
                    IsbnTextField.setText(l.getIsbn());
                    
                    
                }
            }
         });

    }
    
    public void clear(){
        this.TitleTextField.setText("");
        this.PublisherTextField.setText("");
        this.PublishigYearDate.setYear(2020);
        this.QuantityTextField.setText("");
        this.CategoryComboBox.setSelectedItem(0);
        this.AuthorComboBox.setSelectedIndex(0);
        this.AuthorComboBox2.setSelectedIndex(1);
        this.IsbnTextField.setText("");
        this.PriceTextField.setText("");
    }
    
        public void loadBookTable(){
        
        try{
            List<Libri> lista = lrepo.findAll();
            btm.addList(lista);
            table.setModel(btm);
            btm.fireTableDataChanged();
        }catch(LibraryException ex){
           
           java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE,null,ex);

        }
            
        }
                

        public void loadCategoryComboBox(){
            try{
            List<KategoriaLibrit> lista = klrepo.findAll();
            ccbox.add(lista);
            CategoryComboBox.setModel(ccbox);
            CategoryComboBox.repaint();
            } catch (LibraryException ex) {
            Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void loadAuthorComboBox(){
            try{
            List<Autori> lista = arepo.findAll();
            
            
            
            acbox.add(lista);
            AuthorComboBox.setModel(acbox);
            AuthorComboBox.repaint();
            AuthorComboBox2.setModel(acbox);
            AuthorComboBox2.repaint();
            }catch(LibraryException ex){
                Logger.getLogger(RegisterBookGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitelPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AddClientPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        TitleTextField = new javax.swing.JTextField();
        PublisherLabel = new javax.swing.JLabel();
        PublisherTextField = new javax.swing.JTextField();
        PublishingYearLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        QuantityTextField = new javax.swing.JTextField();
        CategoryLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();
        AddClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        PriceTextField = new javax.swing.JTextField();
        AuthorLabel = new javax.swing.JLabel();
        AuthorComboBox = new javax.swing.JComboBox<>();
        CategoryComboBox = new javax.swing.JComboBox<>();
        IsbnTextField = new javax.swing.JTextField();
        IsbnLabel = new javax.swing.JLabel();
        PublishigYearDate = new com.toedter.calendar.JYearChooser();
        AuthorLabel2 = new javax.swing.JLabel();
        AuthorComboBox2 = new javax.swing.JComboBox<>();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitelPanel.setBackground(new java.awt.Color(153, 153, 153));
        TitelPanel.setMaximumSize(new java.awt.Dimension(800, 100));
        TitelPanel.setMinimumSize(new java.awt.Dimension(800, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register Book");

        javax.swing.GroupLayout TitelPanelLayout = new javax.swing.GroupLayout(TitelPanel);
        TitelPanel.setLayout(TitelPanelLayout);
        TitelPanelLayout.setHorizontalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        AddClientPanel.setBackground(new java.awt.Color(204, 204, 204));
        AddClientPanel.setMaximumSize(new java.awt.Dimension(800, 500));
        AddClientPanel.setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitleLabel.setText("Title");

        TitleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleTextFieldActionPerformed(evt);
            }
        });

        PublisherLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublisherLabel.setText("Publisher");

        PublisherTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublisherTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        PublisherTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        PublisherTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        PublisherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherTextFieldActionPerformed(evt);
            }
        });

        PublishingYearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PublishingYearLabel.setText("Publishing year");

        PriceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PriceLabel.setText("Price");

        QuantityTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityTextFieldActionPerformed(evt);
            }
        });

        CategoryLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CategoryLabel.setText("Category");

        QuantityLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuantityLabel.setText("Quantity");

        AddClientButton.setBackground(new java.awt.Color(51, 255, 51));
        AddClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddClientButton.setText("Save");
        AddClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setBackground(new java.awt.Color(255, 51, 102));
        DeleteClientButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteClientButton.setText("Delete");
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        PriceTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PriceTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        PriceTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        PriceTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        PriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTextFieldActionPerformed(evt);
            }
        });

        AuthorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel.setText("Author 1");

        AuthorComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        CategoryComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CategoryComboBox.setMaximumSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.setMinimumSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.setPreferredSize(new java.awt.Dimension(150, 28));
        CategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryComboBoxActionPerformed(evt);
            }
        });

        IsbnTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IsbnTextField.setMaximumSize(new java.awt.Dimension(150, 28));
        IsbnTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        IsbnTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        IsbnTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsbnTextFieldActionPerformed(evt);
            }
        });

        IsbnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IsbnLabel.setText("Isbn");

        AuthorLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AuthorLabel2.setText("Author 2");

        AuthorComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitleLabel)
                            .addComponent(PublishingYearLabel)
                            .addComponent(QuantityLabel)
                            .addComponent(AuthorLabel)
                            .addComponent(AuthorLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AuthorComboBox2, 0, 150, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(QuantityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(TitleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(AuthorComboBox, 0, 150, Short.MAX_VALUE)
                                .addComponent(PublishigYearDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PublisherLabel)
                    .addComponent(CategoryLabel)
                    .addComponent(PriceLabel)
                    .addComponent(IsbnLabel))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteClientButton)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PublisherTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IsbnTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel)
                    .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublisherLabel)
                    .addComponent(PublisherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PublishingYearLabel)
                        .addComponent(CategoryLabel)
                        .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PublishigYearDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(QuantityLabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AuthorLabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AuthorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IsbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IsbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AuthorLabel2)
                    .addComponent(AuthorComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddClientButton)
                    .addComponent(DeleteClientButton)))
        );

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout AddClientPanelLayout = new javax.swing.GroupLayout(AddClientPanel);
        AddClientPanel.setLayout(AddClientPanelLayout);
        AddClientPanelLayout.setHorizontalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );
        AddClientPanelLayout.setVerticalGroup(
            AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddClientPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AddClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AddClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleTextFieldActionPerformed

    private void PublisherTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublisherTextFieldActionPerformed

    private void QuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityTextFieldActionPerformed

    private void AddClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientButtonActionPerformed
     try{
            int row = table.getSelectedRow();
            if(row == -1){
              Libri l = new Libri();
              l.setLTitulli(TitleTextField.getText());
              
             
              Autori a1 = (Autori) AuthorComboBox.getSelectedItem();
              Autori a2 = (Autori) AuthorComboBox2.getSelectedItem();
              
              System.out.println(a1);
              System.out.println(a2);
              l.getAutoriCollection().add(a1) ;
                        // l.getAutoriCollection().add((Autori) AuthorComboBox.getSelectedItem());
                        // l.getAutoriCollection().add((Autori) AuthorComboBox2.getSelectedItem()); 
;

              
              
              
              
              l.setLShtepiaBotuese(PublisherTextField.getText());
              l.setLVitiBotimit(PublishigYearDate.getValue());            
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              l.setIsbn(IsbnTextField.getText());
              
              lrepo.create(l);
            }else{
                
                Libri l = btm.getLibri(row);
                
                
               l.setLTitulli(TitleTextField.getText());
              l.setLShtepiaBotuese(PublisherTextField.getText());
              l.setLVitiBotimit(PublishigYearDate.getValue());            
              l.setLKategoriaId((KategoriaLibrit) CategoryComboBox.getSelectedItem());
              l.setLSasia(Integer.parseInt(QuantityTextField.getText()));
              l.setLCmimiMujor(Double.parseDouble(PriceTextField.getText()));
              
              lrepo.edit(l);
                
                
            }
            //E krijojm ni metode per me i clear fieldat mbasi ti shtojme
            clear();
            this.loadBookTable();
     }catch(LibraryException ex){
            JOptionPane.showMessageDialog(this, "E dhena ekziston!");
        }
     
     
    }//GEN-LAST:event_AddClientButtonActionPerformed

    private void PriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTextFieldActionPerformed

    private void CategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryComboBoxActionPerformed

    private void IsbnTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsbnTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsbnTextFieldActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
                try{
                    int row = table.getSelectedRow();
                    if(row != -1){
                        Libri l = btm.getLibri(row);
                        lrepo.delete(l);
                    
                    }
            this.clear();
            this.loadBookTable();
        }   
        catch (Exception ex){
                   
          
        }
    }//GEN-LAST:event_DeleteClientButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterBookGUI().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientButton;
    private javax.swing.JPanel AddClientPanel;
    private javax.swing.JComboBox<Autori> AuthorComboBox;
    private javax.swing.JComboBox<Autori> AuthorComboBox2;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JLabel AuthorLabel2;
    private javax.swing.JComboBox<KategoriaLibrit> CategoryComboBox;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JLabel IsbnLabel;
    private javax.swing.JTextField IsbnTextField;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JLabel PublisherLabel;
    private javax.swing.JTextField PublisherTextField;
    private com.toedter.calendar.JYearChooser PublishigYearDate;
    private javax.swing.JLabel PublishingYearLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JPanel TitelPanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}