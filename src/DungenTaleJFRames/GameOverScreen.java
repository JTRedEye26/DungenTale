/*
 * January 22, 2018
 * This is the ending screen that players will see if they win the game or if they died trying
 */
package DungenTaleJFRames;

import java.io.BufferedReader;// this allows some cammands to be used
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import DungenTaleClasses.CharacterClass;

/**
 *
 * @author Asus
 */
public class GameOverScreen extends javax.swing.JFrame {

    private IntroductionScreen introductionScreen;
    MainGameDisplayScreen mainGameDisplayScreen;
    CharacterClass player;

    /**
     * Creates new form GameOverScreen
     */
    public GameOverScreen(MainGameDisplayScreen m) {
        initComponents();
        mainGameDisplayScreen = m;
        player = mainGameDisplayScreen.getPlayer();// displays the high scoore
        ArrayList<Integer> highScores = new ArrayList();

        try (FileReader fr = new FileReader("src//DataTextFiles//HighScores")) {// saves and prints high scores

            try (BufferedReader br = new BufferedReader(fr)) {
                boolean endFile = false;
                String text = "";

                while (endFile == false) {
                    text = br.readLine();
                }

                if (text.equals("")) {
                    endFile = true;
                } else {
                    highScores.add(Integer.parseInt(text));
                }

            }
        } catch (IOException e) {
            System.out.print(e);
        }
        
        highScores.add(player.getCoins());

        try (FileWriter fr = new FileWriter("src//DataTextFiles//HighScores")) {
            try (PrintWriter pw = new PrintWriter(fr)) {

                for (int i = highScores.size(); i > 0; i--) {
                    pw.println(highScores.indexOf(i)); 
                }
                pw.close();
            }
        } catch (IOException e) {
            System.out.print(e);
        }

        for(int x = 0; x < highScores.size(); x++){
            highScoreDisplay.append(highScores.indexOf(x) + "\n");
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

        jPanel1 = new javax.swing.JPanel();
        closeGame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        credits = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        highScoreDisplay = new javax.swing.JTextArea();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeGame.setText("Close Game");
        closeGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeGameActionPerformed(evt);
            }
        });
        jPanel1.add(closeGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, -1, -1));

        credits.setEditable(false);
        credits.setColumns(20);
        credits.setRows(5);
        credits.setText("Jacob Thomas......Gaphic Designer\nChase Hart.....Programer & Editer\nNick Hamel.........Head Programer");
        jScrollPane1.setViewportView(credits);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 270, 100));

        highScoreDisplay.setEditable(false);
        highScoreDisplay.setColumns(20);
        highScoreDisplay.setRows(5);
        jScrollPane2.setViewportView(highScoreDisplay);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 350, 130));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgrounds/End screen.png"))); // NOI18N
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

    private void closeGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeGameActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton closeGame;
    private javax.swing.JTextArea credits;
    private javax.swing.JTextArea highScoreDisplay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
