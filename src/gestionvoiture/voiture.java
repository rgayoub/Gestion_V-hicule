/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionvoiture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ayoub
 */


public class voiture extends javax.swing.JFrame {
  ArrayList<Voitureclass> Voitureclass;
    DefaultTableModel modelVoiture;
  
    
    
         
    /**
     * Creates new form voiture
     */
   private void sauvegarderVoitures() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("fichier.txt"))) {
        for (Voitureclass voiture : Voitureclass) {
            writer.write(voiture.getId() + " " +
                         voiture.getMarque() + " " +
                         voiture.getModele() + " " +
                         voiture.getAnnee() + " " +
                         voiture.getCouleur() + " " +
                         voiture.getImmatriculation() + " " +
                         voiture.getProprietaire_id());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public voiture() {
    initComponents();
        
    Voitureclass = new ArrayList<>();
    modelVoiture = (DefaultTableModel) TabVoiture.getModel();
    modelVoiture.setRowCount(0);
   
    initListeners();
    
    // Ajouter BtnModifier et configurer son ActionListener
    BtnMetterajour.setText("Modifier");
    BtnMetterajour.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnMetterajourActionPerformed(evt);
        }
    });
}

 private void remplirTabVoiture() {
    try {
        File fichier = new File("fichier.txt");
        Scanner scan = new Scanner(fichier);
        boolean tabVoiture = true;
        int id = 0;
        String marque = "", modele = "", annee = "", couleur = "", immatriculation = "";
        int proprietaireId = 0;

        while (scan.hasNext()) {
            if (tabVoiture) {
                if (scan.hasNextInt()) {
                    id = scan.nextInt();
                    tabVoiture = false;
                } else {
                    scan.next(); // Skip the invalid input
                }
            } else {
                marque = scan.next();
                modele = scan.next();
                annee = scan.next();
                couleur = scan.next();
                immatriculation = scan.next();
                if (scan.hasNextInt()) {
                    proprietaireId = scan.nextInt();
                    tabVoiture = true;
                    Voitureclass voiture = new Voitureclass(id, marque, modele, annee, couleur, immatriculation, proprietaireId);
                    Voitureclass.add(voiture);
                } else {
                    scan.next(); // Skip the invalid input
                }
            }
        }

        for (Voitureclass v : Voitureclass) {
            modelVoiture.addRow(new Object[]{v.getId(), v.getMarque(), v.getModele(), v.getAnnee(), v.getCouleur(), v.getImmatriculation(), v.getProprietaire_id()});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


 
 private void initListeners() {
     
        // Ajout d'un écouteur de sélection de ligne au tableau TabVoiture
        TabVoiture.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Vérifier si la sélection a été ajustée
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TabVoiture.getSelectedRow();
                    if (selectedRow != -1) {
                        // Récupérer les données de la ligne sélectionnée dans le tableau
                           int id = Integer.parseInt(modelVoiture.getValueAt(selectedRow, 0).toString());
                    String marque = modelVoiture.getValueAt(selectedRow, 1).toString();
                   String modele = modelVoiture.getValueAt(selectedRow, 2).toString();
                   String annee = modelVoiture.getValueAt(selectedRow, 3).toString();
                   String couleur = modelVoiture.getValueAt(selectedRow, 4).toString();
                   String immatriculation = modelVoiture.getValueAt(selectedRow, 5).toString();
                   int proprietaire_id = Integer.parseInt(modelVoiture.getValueAt(selectedRow, 6).toString());
                        // Afficher les données dans les champs de texte
                        txtId.setText(String.valueOf(id));
                    txtMarque.setText(marque);
                    txtModele.setText(modele);
                    txtAnnee.setText(annee);
                    txtCouleur.setText(couleur);
                    txtImmatriculation.setText(immatriculation);
                    txtProprietaireId.setText(String.valueOf(proprietaire_id));
                        // Vous pouvez afficher les autres données de la ligne sélectionnée dans d'autres champs de texte de la même manière
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtCouleur = new javax.swing.JTextField();
        txtAnnee = new javax.swing.JTextField();
        txtModele = new javax.swing.JTextField();
        txtProprietaireId = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtMarque = new javax.swing.JTextField();
        txtImmatriculation = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabVoiture = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        BtnAjouter = new javax.swing.JButton();
        BtnLire = new javax.swing.JButton();
        BtnMetterajour = new javax.swing.JButton();
        BtnSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Marque");

        jLabel2.setText("ID");

        jLabel4.setText("Modele");

        jLabel5.setText("Année");

        jLabel6.setText("Couleur");

        jLabel7.setText("Immatriculation");

        jLabel8.setText("Propriétaire");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(212, 212, 212))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCouleur, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
            .addComponent(txtProprietaireId)
            .addComponent(txtId)
            .addComponent(txtMarque)
            .addComponent(txtModele)
            .addComponent(txtAnnee)
            .addComponent(txtImmatriculation)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProprietaireId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        TabVoiture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Marque", "Modele", "Année", "Couleur", "Immatriculation", "PropritaireID"
            }
        ));
        jScrollPane1.setViewportView(TabVoiture);

        BtnAjouter.setText("Ajouter");
        BtnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterActionPerformed(evt);
            }
        });

        BtnLire.setText("Lire");
        BtnLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLireActionPerformed(evt);
            }
        });

        BtnMetterajour.setText("Mettre à jour");
        BtnMetterajour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMetterajourActionPerformed(evt);
            }
        });

        BtnSupprimer.setText("Supprimer");
        BtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(BtnAjouter)
                .addGap(18, 18, 18)
                .addComponent(BtnLire)
                .addGap(30, 30, 30)
                .addComponent(BtnMetterajour)
                .addGap(18, 18, 18)
                .addComponent(BtnSupprimer)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAjouter)
                    .addComponent(BtnSupprimer)
                    .addComponent(BtnMetterajour)
                    .addComponent(BtnLire))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouterActionPerformed
       try {
           
    int id = Integer.parseInt(txtId.getText().trim());
    String marque = txtMarque.getText().trim();
    String modele = txtModele.getText().trim();
    String annee = txtAnnee.getText().trim();
    String couleur = txtCouleur.getText().trim();
    String immatriculation = txtImmatriculation.getText().trim();
    int proprietaireId = Integer.parseInt(txtProprietaireId.getText().trim());

    // Validation des champs
    if (!marque.isEmpty() && !modele.isEmpty() && !annee.isEmpty() && !couleur.isEmpty() && !immatriculation.isEmpty()) {
        Voitureclass voiture = new Voitureclass(id, marque, modele, annee, couleur, immatriculation, proprietaireId);
        Voitureclass.add(voiture);
        sauvegarderVoitures(); // Sauvegarder les données dans le fichier
        JOptionPane.showMessageDialog(this, "Les données ont été enregistrées avec succès dans le fichier.", "Succès", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "L'ID et l'ID du propriétaire doivent être des nombres entiers.", "Erreur", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_BtnAjouterActionPerformed

    private void BtnLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLireActionPerformed
 Voitureclass.clear(); // Nettoyer la liste existante avant de lire à nouveau les données
    modelVoiture.setRowCount(0); // Effacer le contenu du tableau
    remplirTabVoiture(); // Remplir le tableau avec les nouvelles données
    }//GEN-LAST:event_BtnLireActionPerformed

    private void BtnMetterajourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMetterajourActionPerformed
int selectedRow = TabVoiture.getSelectedRow();
if (selectedRow != -1) {
    int id = Integer.parseInt(txtId.getText().trim());
    String marque = txtMarque.getText().trim();
    String modele = txtModele.getText().trim();
    String annee = txtAnnee.getText().trim();
    String couleur = txtCouleur.getText().trim();
    String immatriculation = txtImmatriculation.getText().trim();
    int proprietaire_id = Integer.parseInt(txtProprietaireId.getText().trim());

    // Mise à jour des valeurs dans le tableau et la liste
    Voitureclass voiture = Voitureclass.get(selectedRow);
    voiture.setId(id);
    voiture.setMarque(marque);
    voiture.setModele(modele);
    voiture.setAnnee(annee);
    voiture.setCouleur(couleur);
    voiture.setImmatriculation(immatriculation);
    voiture.setProprietaire_id(proprietaire_id);

    modelVoiture.setValueAt(id, selectedRow, 0);
    modelVoiture.setValueAt(marque, selectedRow, 1);
    modelVoiture.setValueAt(modele, selectedRow, 2);
    modelVoiture.setValueAt(annee, selectedRow, 3);
    modelVoiture.setValueAt(couleur, selectedRow, 4);
    modelVoiture.setValueAt(immatriculation, selectedRow, 5);
    modelVoiture.setValueAt(proprietaire_id, selectedRow, 6);

    // Enregistrer les modifications dans le fichier
    sauvegarderVoitures();

   // Afficher un message informatif
JOptionPane.showMessageDialog(this, "Voiture modifiée avec succès !", "Information", JOptionPane.INFORMATION_MESSAGE);

} else {
    JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_BtnMetterajourActionPerformed

    private void BtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupprimerActionPerformed
   int indice = TabVoiture.getSelectedRow();
if (indice != -1) {
    int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer cette voiture ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        Voitureclass voiture = Voitureclass.get(indice);
        Voitureclass.remove(indice);
        modelVoiture.removeRow(indice);

        // Réécrire le fichier avec les données mises à jour
        try {
            FileWriter writer = new FileWriter("fichier.txt");
            for (Voitureclass v : Voitureclass) {
                writer.write(v.getId() + " " + v.getMarque() + " " + v.getModele() + " " + v.getAnnee() + " " + v.getCouleur() + " " + v.getImmatriculation() + " " + v.getProprietaire_id() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



    }//GEN-LAST:event_BtnSupprimerActionPerformed

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
            java.util.logging.Logger.getLogger(voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(voiture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new voiture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjouter;
    private javax.swing.JButton BtnLire;
    private javax.swing.JButton BtnMetterajour;
    private javax.swing.JButton BtnSupprimer;
    private javax.swing.JTable TabVoiture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnnee;
    private javax.swing.JTextField txtCouleur;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImmatriculation;
    private javax.swing.JTextField txtMarque;
    private javax.swing.JTextField txtModele;
    private javax.swing.JTextField txtProprietaireId;
    // End of variables declaration//GEN-END:variables
}
