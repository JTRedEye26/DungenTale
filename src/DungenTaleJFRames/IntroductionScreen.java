/*
 * January 22, 2018
 * This is the introduction screen that bring players to the game
 */
package DungenTaleJFRames;

import java.io.BufferedReader;// allows the use of some commands
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Asus
 */
public class IntroductionScreen extends javax.swing.JFrame {

    private CharacterChooser characterChooser;
    private MainGameDisplayScreen mainGameDisplayScreen;
    GameOverScreen gameOverScreen;

    /**
     * Creates new form IntroductionScreen
     */
    public IntroductionScreen() {
        initComponents();
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
        newGame = new javax.swing.JButton();
        Save1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jPanel1.add(newGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, 140, 60));

        Save1.setText("Load Game");
        Save1.setActionCommand("");
        Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save1ActionPerformed(evt);
            }
        });
        jPanel1.add(Save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, 140, 60));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgrounds/Title Screen.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        if (characterChooser == null) {//Begins a new game and sends the player to the character selection
            characterChooser = new CharacterChooser(this);
        }
        characterChooser.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newGameActionPerformed

    private void Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save1ActionPerformed

        String name;// these are the variables used 
        int health, armour, attack, coins, healthPots, speedPots, strengthPots, replPots, cycles = 12;
        boolean archer, knight, mage;

        try {//Reads a document for the first save game progress
            FileReader fr = new FileReader("src//datatextfiles//save.txt");
            BufferedReader br = new BufferedReader(fr);

            name = br.readLine();

            health = Integer.parseInt(br.readLine());

            armour = Integer.parseInt(br.readLine());

            attack = Integer.parseInt(br.readLine());

            coins = Integer.parseInt(br.readLine());

            healthPots = Integer.parseInt(br.readLine());

            speedPots = Integer.parseInt(br.readLine());

            strengthPots = Integer.parseInt(br.readLine());

            replPots = Integer.parseInt(br.readLine());

            archer = Boolean.parseBoolean(br.readLine());

            knight = Boolean.parseBoolean(br.readLine());

            mage = Boolean.parseBoolean(br.readLine());

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
        mainGameDisplayScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Save1ActionPerformed

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
            java.util.logging.Logger.getLogger(IntroductionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroductionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroductionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroductionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IntroductionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save1;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables
}
