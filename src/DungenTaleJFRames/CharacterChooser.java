/*
 * January 22, 2018
 * this is the GUI where the player picks what character they want to play as
 */
package DungenTaleJFRames;

import java.io.FileReader;// these imports allow some commands used to be used
import java.io.IOException;
import java.io.BufferedReader;
import DungenTaleClasses.CharacterClass;

/**
 *
 * @author Asus
 */
public class CharacterChooser extends javax.swing.JFrame {

    private MainGameDisplayScreen mainGameDisplayScreen;// this sets up the switching of screens
    IntroductionScreen introductionScreen;

    /**
     * Creates new form CharacterChooser
     */
    public CharacterChooser(IntroductionScreen i) {
        initComponents();
        introductionScreen = i;
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
        mage = new javax.swing.JButton();
        knight = new javax.swing.JButton();
        archer = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mage.setText("Mage");
        mage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mageActionPerformed(evt);
            }
        });
        jPanel1.add(mage, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 580, 200, 50));

        knight.setText("Knight");
        knight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knightActionPerformed(evt);
            }
        });
        jPanel1.add(knight, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, 200, 50));

        archer.setText("Archer");
        archer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archerActionPerformed(evt);
            }
        });
        jPanel1.add(archer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 583, 200, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgrounds/Character Select Screen.png"))); // NOI18N
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

    String name, placeHolder;
    int health, cycles, armer, attack, coins, healthPots = 0, speedPots = 0, strengthPots = 0, repelPots = 0;// these are the variables used
    CharacterClass player;

    private void fileReader() {// this method reads the selected file and sets variables to the text read
        try {
            FileReader fr = new FileReader("src//DataTextFiles//CharacterStats.txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                for (int i = 0; i < cycles; i++) {//Reads from a document with the character stats

                    name = (placeHolder = br.readLine());
                    health = Integer.parseInt((placeHolder = br.readLine()));
                    armer = Integer.parseInt((placeHolder = br.readLine()));
                    attack = Integer.parseInt((placeHolder = br.readLine()));
                    coins = Integer.parseInt((placeHolder = br.readLine()));

                }
                br.close();
            }
        } catch (IOException e) {

            System.out.print("Error: " + e);
        }
    }

    public CharacterClass getCharacter() {
        return player;
    }


    private void archerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archerActionPerformed
        cycles = 3;//Reads the document for the archer stats
        fileReader();

        player = new CharacterClass(name, health, armer, attack, coins, healthPots, speedPots, strengthPots, repelPots, true, false, false);// creats a new charater
        if (mainGameDisplayScreen == null) {// these commands switch the screen to the main game
            mainGameDisplayScreen = new MainGameDisplayScreen(this);
        }
        mainGameDisplayScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_archerActionPerformed

    private void knightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knightActionPerformed
        cycles = 1;//Reads the document for the knight stats
        fileReader();

        player = new CharacterClass(name, health, armer, attack, coins, healthPots, speedPots, strengthPots, repelPots, false, true, false);
        if (mainGameDisplayScreen == null) {
            mainGameDisplayScreen = new MainGameDisplayScreen(this);
        }
        mainGameDisplayScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_knightActionPerformed

    private void mageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mageActionPerformed
        cycles = 2;//Reads the document for the mage stats
        fileReader();

        player = new CharacterClass(name, health, armer, attack, coins, healthPots, speedPots, strengthPots, repelPots, false, false, true);
        if (mainGameDisplayScreen == null) {
            mainGameDisplayScreen = new MainGameDisplayScreen(this);
        }
        mainGameDisplayScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archer;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton knight;
    private javax.swing.JButton mage;
    // End of variables declaration//GEN-END:variables
}
