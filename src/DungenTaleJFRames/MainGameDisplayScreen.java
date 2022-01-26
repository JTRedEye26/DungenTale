/*
 * January 22, 2018
 * This GUI is where the user spends most of thier time and is where most of the code for the game is
 */
package DungenTaleJFRames;

import javax.swing.ImageIcon;// thse set up some commands used
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import DungenTaleClasses.EnemiesClass;
import DungenTaleClasses.CharacterClass;
import javax.swing.JOptionPane;
import java.io.PrintWriter;

/**
 *
 * @author Asus
 */
public class MainGameDisplayScreen extends javax.swing.JFrame {

    private ShopScreen shopScreen;// these are the variables used
    private GuideScreen guideScreen;
    private GameOverScreen gameOverScreen;
    CharacterChooser characterChooser;
    EnemiesClass enemy;
    EnemiesClass[] enemys = new EnemiesClass[17];
    String name, placeHolder, enemyName;
    CharacterClass player;
    double time = 6;
    int playerLocationX = 1, playerLocationY = 1, health, armer, attack, playerAttack, playerBattleAttack, enemyAttack, enemyDefense, coins, numHealthPot, numStrengthPot;
    int numSpeedPot, numRepelPot, useStrengthPot, useSpeedPot, useRepelPot, playerCurrentHealth, enemyCurrentHealth, playerMaxHealth, enemyMaxHealth;
    boolean battle = false, beach = true, forest = false, mountians = false, cave = false;

    /**
     * Creates new form MainGameDisplayScreen
     */
    public MainGameDisplayScreen(CharacterChooser c) {
        initComponents();
        JOptionPane.showMessageDialog(null, "You have a woken on a strange island. All you remember was looking up to a fire breathing beast shooting a fire ball at you.\nAll you could do was jump overbored and now you are on this beach. You see a village up a head and decide to go check it out.\nThey inform you that as long as the dragon is alive there is no escape from the island.");
        JOptionPane.showMessageDialog(null, "Go to the village's shop to armour up to start your quest");
        characterChooser = c;
        fleeButton.setEnabled(false);
        attackButton.setEnabled(false);
        sleepButton.setEnabled(false);
        shopButton.setEnabled(false);
        healButton.setEnabled(false);
        playerHealthBar.setValue(100);
        player = characterChooser.getCharacter();
        playerMaxHealth = player.getHealth();
        playerCurrentHealth = player.getHealth();
        playerAttack = player.getAttack();
        playerHealthStat.setText("HP:  " + playerCurrentHealth + "/" + playerMaxHealth);
        playerDefenseStat.setText("Defence: " + player.getArmour());
        playerAttackStat.setText("Attack: " + playerAttack);
        if (player.getArcher()) {
            playerPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/ArcherLogo.png")));
        } else if (player.getKnight()) {
            playerPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/KnightLogo.png")));
        } else if (player.getMage()) {
            playerPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/WizardLogo.png")));
        }
        boolean endOfFile = false;
        int i = 0;
        try {
            FileReader fr = new FileReader("src//DataTextFiles//EnemyStats.txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                while (!endOfFile) {
                    name = (placeHolder = br.readLine());
                    if (name == null) {
                        endOfFile = true;//At the end of the file.
                    } else {
                        health = Integer.parseInt((placeHolder = br.readLine()));
                        armer = Integer.parseInt((placeHolder = br.readLine()));
                        attack = Integer.parseInt((placeHolder = br.readLine()));
                        coins = Integer.parseInt((placeHolder = br.readLine()));
                        enemy = new EnemiesClass(name, health, armer, attack, coins);
                        enemys[i] = enemy;
                        i++;
                    }
                }
                br.close();
            }
        } catch (IOException e) {

            System.out.print("Error: " + e);
        }
    }

    public CharacterClass getPlayer() {// this gets the player
        return player;
    }

    private void move() {
        if ((playerLocationY == 1) && (playerLocationX == 1)) {//Displays the character as it moves around the screen
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach11.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest11.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians11.png")));
            }
        } else if ((playerLocationY == 1) && (playerLocationX == 2)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach12.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest12.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians12.png")));
            }
        } else if ((playerLocationY == 1) && (playerLocationX == 3)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach13.png")));
                sleepButton.setEnabled(true);
                shopButton.setEnabled(true);
                healButton.setEnabled(true);
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest13.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians13.png")));
                sleepButton.setEnabled(true);
                shopButton.setEnabled(true);
                healButton.setEnabled(true);
            }
        } else if ((playerLocationY == 1) && (playerLocationX == 4)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach14.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest14.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians14.png")));
            }
        } else if ((playerLocationY == 1) && (playerLocationX == 5)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach15.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest15.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians15.png")));
            }
        } else if ((playerLocationY == 1) && (playerLocationX == 6)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach16.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest16.png")));
                playerLocationX = 1;
                playerLocationY = 5;
                enemy = enemys[7];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/TheHowlingDeath.png")));
                enemyHealthBar.setValue(100);
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattleBoss();
                mountians = true;
                forest = false;
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians16.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 1)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach21.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest21.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians21.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 2)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach22.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest22.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians22.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 3)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach23.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest23.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians23.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave23.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 4)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach24.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest24.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians24.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave24.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 5)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach25.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest25.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians25.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave25.png")));
            }
        } else if ((playerLocationY == 2) && (playerLocationX == 6)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach26.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest26.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians26.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 1)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach31.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest31.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians31.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave31.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 2)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach32.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest32.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians32.png")));
            }
            if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave32.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 3)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach33.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest33.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians33.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave33.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 4)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach34.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest34.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians34.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave34.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 5)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach35.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest35.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians35.png")));
            }
        } else if ((playerLocationY == 3) && (playerLocationX == 6)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach36.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest36.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians36.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave36.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 1)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach41.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest41.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians41.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave41.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 2)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach42.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest42.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians42.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 3)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach43.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest43.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians43.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 4)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach44.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest44.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians44.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 5)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach45.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest45.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians45.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave45.png")));
            }
        } else if ((playerLocationY == 4) && (playerLocationX == 6)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach46.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest46.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians46.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave46.png")));
            }
        } else if ((playerLocationY == 5) && (playerLocationX == 1)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach51.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest51.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians51.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave51.png")));
            }
        } else if ((playerLocationY == 5) && (playerLocationX == 2)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach52.png")));
                playerLocationX = 1;
                playerLocationY = 1;
                enemy = enemys[3];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/MonkeyBoss.png")));
                enemyHealthBar.setValue(100);
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattleBoss();
                forest = true;
                beach = false;
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest52.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians52.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave52.png")));
            }
        } else if ((playerLocationY == 5) && (playerLocationX == 3)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach53.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest53.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians53.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave53.png")));
                enemy = enemys[11];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/canibles.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattleBoss();
            }
        } else if ((playerLocationY == 5) && (playerLocationX == 4)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach54.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest54.png")));
                sleepButton.setEnabled(true);
                shopButton.setEnabled(true);
                healButton.setEnabled(true);
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians54.png")));
                playerLocationX = 6;
                playerLocationY = 5;
                enemy = enemys[11];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/ManOfStone.png")));
                enemyHealthBar.setValue(100);
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattleBoss();
                cave = true;
                mountians = false;
            }

        } else if ((playerLocationY == 5) && (playerLocationX == 5)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach55.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest55.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians55.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave55.png")));
            }
        } else if ((playerLocationY == 5) && (playerLocationX == 6)) {
            if (beach) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/beach56.png")));
            } else if (forest) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest56.png")));
            } else if (mountians) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians56.png")));
            } else if (cave) {
                miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave56.png")));
            }
        }
    }

    private void nightTime() {
        if (time < 6 || time > 21) {
            enemyMaxHealth = enemy.getHealth() * 2;
            enemyCurrentHealth = enemy.getHealth() * 2;
            enemyAttack = enemy.getAttack() * 2;
            enemyDefense = enemy.getArmour() * 2;
        }
    }

    private void spawn() {// this dicides the spawn rates and if something spawns and the loot draps
        int generator;
        generator = (int) (Math.random() * 100 + 1);
        if (generator > 30 && generator <= 50) {
            if (beach) {
                enemy = enemys[0];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/SandBeetle.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (forest) {
                enemy = enemys[4];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/Mosquito.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (mountians) {
                enemy = enemys[8];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/SouringTerrier.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (cave) {
                enemy = enemys[12];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/BloodSuckers.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            }
        } else if (generator > 50 && generator <= 60) {
            if (beach) {
                enemy = enemys[1];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/CrabbyCrab.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (forest) {
                enemy = enemys[5];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/QuillPigs.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (mountians) {
                enemy = enemys[9];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/SpiderSheep.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (cave) {
                enemy = enemys[13];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/Vipers.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            }
        } else if (generator > 60 && generator <= 70) {
            if (beach) {
                enemy = enemys[2];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/StoneFish.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (forest) {
                enemy = enemys[6];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/Razerback.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (mountians) {
                enemy = enemys[10];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/Lurker.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            } else if (cave) {
                enemy = enemys[14];
                enemyMaxHealth = enemy.getHealth();
                enemyCurrentHealth = enemy.getHealth();
                enemyAttack = enemy.getAttack();
                enemyDefense = enemy.getArmour();
                nightTime();
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                enemyDefenseStat.setText("Defense: " + enemyDefense);
                enemyAttackStat.setText("Attack: " + enemyAttack);
                enemyHealthBar.setValue(100);
                enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/ScolopendraGigantea.png")));
                gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                inBattle();
            }
        } else if (generator > 70 && generator <= 78) {
            numStrengthPot = numStrengthPot = 1;
            gameLogOutput.append("You found a Strength Potion!\n");
        } else if (generator > 78 && generator <= 86) {
            numSpeedPot = numSpeedPot + 1;
            gameLogOutput.append("You found a Speed Potion!\n");
        } else if (generator > 86 && generator <= 94) {
            numRepelPot = numRepelPot + 1;
            gameLogOutput.append("You found a Repel Potion!\n");
        } else if (generator > 94 && generator <= 100) {
            player.setHealthPots(player.getHealthPots() + 1);
            gameLogOutput.append("You found a Health Potion!\n");
        }
    }

    private void inBattle() {// these set the buttons to either true or false when in battle
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        strengthPotion.setEnabled(false);
        repelPotion.setEnabled(false);
        speedPotion.setEnabled(false);
        shopButton.setEnabled(false);
        healButton.setEnabled(false);
        sleepButton.setEnabled(false);
        fleeButton.setEnabled(true);
        attackButton.setEnabled(true);
    }

    private void inBattleBoss() {// these set the buttons to either true or false when in boss battle
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        strengthPotion.setEnabled(false);
        repelPotion.setEnabled(false);
        speedPotion.setEnabled(false);
        shopButton.setEnabled(false);
        healButton.setEnabled(false);
        sleepButton.setEnabled(false);
        fleeButton.setEnabled(false);
        attackButton.setEnabled(true);
    }

    @SuppressWarnings("empty-statement")
    private void potionCheck() {// this lest players use potions and times how long their effects are
        if (useSpeedPot > 0) {
            useSpeedPot = useSpeedPot - 1;
            time = time + 0.5;
            if (useSpeedPot > 0) {
                gameLogOutput.append("Speed Potion will wear off in " + useSpeedPot + " moves.\n");
            } else if (useSpeedPot == 0) {
                gameLogOutput.append("Speed Potion has worn off.\n");
            }
        } else if (useSpeedPot == 0) {
            time = time + 1;
        }
        if (time == 6) {
            gameLogOutput.append("It's morning! (6am)\n");;
        } else if (time == 21) {
            gameLogOutput.append("It's nighttime! (9pm)\n");;
        } else if (time > 24) {
            time = 1;
        }
        timeLabel.setText("Time: " + time);
        if (useRepelPot > 0) {
            useRepelPot = useRepelPot - 1;
            if (useRepelPot > 0) {
                gameLogOutput.append("Repel Potion will wear off in " + useRepelPot + " moves.\n");
            } else if (useRepelPot == 0) {
                gameLogOutput.append("Repel Potion has worn off.\n");
            }
        }
        if (useStrengthPot > 0) {
            useStrengthPot = useStrengthPot - 1;
            if (useStrengthPot > 0) {
                gameLogOutput.append("Strength Potion will wear off in " + useStrengthPot + " moves.\n");
            } else if (useStrengthPot == 0) {
                gameLogOutput.append("Strength Potion has worn off.\n");
            }
        }
        if (useStrengthPot == 0) {
            playerAttack = player.getAttack();
            playerAttackStat.setText("Attack: " + playerAttack);
        }
        playerDefenseStat.setText("Defence: " + player.getArmour());
    }

    private void outBattle() {// these set the buttons used outside of battle
        upButton.setEnabled(true);
        downButton.setEnabled(true);
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        strengthPotion.setEnabled(true);
        repelPotion.setEnabled(true);
        speedPotion.setEnabled(true);
        fleeButton.setEnabled(false);
        attackButton.setEnabled(false);
    }

    private void playerAttack() {// this updates all the players stats
        if (enemy.getArmour() < playerBattleAttack) {
            enemyCurrentHealth = enemyCurrentHealth - (playerBattleAttack - enemy.getArmour());
            if (enemyCurrentHealth > 0) {
                enemyHealthBar.setValue((int) ((double) enemyCurrentHealth / (double) enemyMaxHealth * 100));
                enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
            } else if (enemyCurrentHealth <= 0) {
                enemyHealthAmount.setText("HP:  ");
                enemyDefenseStat.setText("Defense: ");
                enemyAttackStat.setText("Attack: ");
                enemyHealthBar.setValue(0);
                enemyPicture.setIcon(new ImageIcon(" "));
                player.setCoins(player.getCoins() + enemy.getCoins());
                gameLogOutput.append("You got " + enemy.getCoins() + " coins!\n");
                outBattle();
                if (enemy.getHealth() == 100) {
                    miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/forest11.png")));
                } else if (enemy.getHealth() == 150) {
                    miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/mountians51.png")));
                } else if (enemy.getHealth() == 200) {
                    miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave56.png")));
                } else if (enemy.getHealth() == 250) {
                    inBattleBoss();
                    miniMap.setIcon(new ImageIcon(getClass().getResource("/MiniMapIcons/cave53.png")));
                    enemy = enemys[16];
                    enemyMaxHealth = enemy.getHealth();
                    enemyCurrentHealth = enemy.getHealth();
                    enemyAttack = enemy.getAttack();
                    enemyDefense = enemy.getArmour();
                    nightTime();
                    enemyHealthAmount.setText("HP:  " + enemyCurrentHealth + "/" + enemyMaxHealth);
                    enemyDefenseStat.setText("Defense: " + enemyDefense);
                    enemyAttackStat.setText("Attack: " + enemyAttack);
                    enemyHealthBar.setValue(100);
                    enemyPicture.setIcon(new ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/MonstrousNightmare.png")));
                    gameLogOutput.append("A " + enemy.getName() + " appeared!\n");
                } else if (enemy.getHealth() == 400) {
                    JOptionPane.showMessageDialog(null, "You Slayed the dragon, now it is safe to sail home!");
                    gameOverScreen.setVisible(true);
                    this.setVisible(false);
                } else {
                    outBattle();
                }
            }
        }
    }

    private void enemyAttack() {// this calculates how much the enimy will do
        int generator, dodge = 20;
        generator = (int) (Math.random() * 100 + 1);
        if (useSpeedPot > 0) {
            dodge = 40;
        }
        if (generator <= dodge) {
            gameLogOutput.append(enemy.getName() + "'s attack missed!\n");
        } else if (generator > dodge && generator <= 80) {
            gameLogOutput.append(enemy.getName() + "'s attack hit!\n");
            if (player.getArmour() < enemy.getAttack()) {
                playerCurrentHealth = playerCurrentHealth - (enemy.getAttack() - player.getArmour());
                if (playerCurrentHealth > 0) {
                    playerHealthBar.setValue((int) ((double) playerCurrentHealth / (double) playerMaxHealth * 100));
                    playerHealthStat.setText("HP:  " + playerCurrentHealth + "/" + playerMaxHealth);
                } else if (playerCurrentHealth <= 0) {
                    if (gameOverScreen == null) {
                        gameOverScreen = new GameOverScreen(this);
                    }
                    gameOverScreen.setVisible(true);
                    this.setVisible(false);
                }
            }
        } else if (generator > 80) {
            gameLogOutput.append(enemy.getName() + "'s attack was a critical hit!\n");
            enemyAttack = (int) (enemy.getAttack() * 1.5);
            if (player.getArmour() < enemyAttack) {
                playerCurrentHealth = playerCurrentHealth - (enemyAttack - player.getArmour());
                if (playerCurrentHealth > 0) {
                    playerHealthBar.setValue((int) ((double) playerCurrentHealth / (double) playerMaxHealth * 100));
                    playerHealthStat.setText("HP:  " + playerCurrentHealth + "/" + playerMaxHealth);
                } else if (playerCurrentHealth <= 0) {
                    if (gameOverScreen == null) {
                        gameOverScreen = new GameOverScreen(this);
                    }
                    JOptionPane.showMessageDialog(null, "You died!");
                    gameOverScreen.setVisible(true);
                    this.setVisible(false);
                }
            }
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

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        shopButton = new javax.swing.JButton();
        attackButton = new javax.swing.JButton();
        fleeButton = new javax.swing.JButton();
        healthPotion = new javax.swing.JButton();
        speedPotion = new javax.swing.JButton();
        strengthPotion = new javax.swing.JButton();
        tutorialButton = new javax.swing.JButton();
        repelPotion = new javax.swing.JButton();
        healButton = new javax.swing.JButton();
        sleepButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameLogOutput = new javax.swing.JTextArea();
        inventoryButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        playerPicture = new javax.swing.JLabel();
        gameLogLabel = new javax.swing.JLabel();
        miniMap = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        enemyPicture = new javax.swing.JLabel();
        playerHealthBar = new javax.swing.JProgressBar();
        enemyHealthBar = new javax.swing.JProgressBar();
        playerHealthStat = new javax.swing.JLabel();
        enemyHealthAmount = new javax.swing.JLabel();
        playerDefenseStat = new javax.swing.JLabel();
        playerAttackStat = new javax.swing.JLabel();
        enemyDefenseStat = new javax.swing.JLabel();
        enemyAttackStat = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        jPanel2.add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 100, 60));

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        jPanel2.add(leftButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 100, 60));

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        jPanel2.add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 100, 60));

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        jPanel2.add(rightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 100, 60));

        shopButton.setText("Shop");
        shopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopButtonActionPerformed(evt);
            }
        });
        jPanel2.add(shopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 640, 130, 60));

        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        jPanel2.add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 640, 130, 60));

        fleeButton.setText("Flee");
        fleeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fleeButtonActionPerformed(evt);
            }
        });
        jPanel2.add(fleeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, 130, 60));

        healthPotion.setText("Health Potion");
        healthPotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthPotionActionPerformed(evt);
            }
        });
        jPanel2.add(healthPotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 130, 60));

        speedPotion.setText("Speed Potion");
        speedPotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedPotionActionPerformed(evt);
            }
        });
        jPanel2.add(speedPotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 490, 130, 60));

        strengthPotion.setText("Strength Potion");
        strengthPotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strengthPotionActionPerformed(evt);
            }
        });
        jPanel2.add(strengthPotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 560, 130, 60));

        tutorialButton.setText("Tutorial");
        tutorialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialButtonActionPerformed(evt);
            }
        });
        jPanel2.add(tutorialButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 130, 60));

        repelPotion.setText("Repel Potion ");
        repelPotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repelPotionActionPerformed(evt);
            }
        });
        jPanel2.add(repelPotion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 560, 130, 60));

        healButton.setText("Heal ");
        healButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healButtonActionPerformed(evt);
            }
        });
        jPanel2.add(healButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 130, 60));

        sleepButton.setText("Sleep");
        sleepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleepButtonActionPerformed(evt);
            }
        });
        jPanel2.add(sleepButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 130, 60));

        gameLogOutput.setEditable(false);
        gameLogOutput.setColumns(20);
        gameLogOutput.setRows(5);
        jScrollPane1.setViewportView(gameLogOutput);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 250, 410));

        inventoryButton.setText("Inventory");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });
        jPanel2.add(inventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, 130, 60));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 563, 130, 60));

        playerPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CharacterAndEnemyIcons/KnightLogo.png"))); // NOI18N
        jPanel2.add(playerPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 5, 170, 140));

        gameLogLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gameLogLabel.setText("Game Logs");
        jPanel2.add(gameLogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 100, 20));

        miniMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MiniMapIcons/beach11.png"))); // NOI18N
        jPanel2.add(miniMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 460));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, -1, -1));
        jPanel2.add(enemyPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 170, 140));
        jPanel2.add(playerHealthBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, 220, -1));
        jPanel2.add(enemyHealthBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 300, 220, -1));

        playerHealthStat.setText("HP ");
        jPanel2.add(playerHealthStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 90, -1));

        enemyHealthAmount.setText("HP ");
        jPanel2.add(enemyHealthAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, 90, -1));

        playerDefenseStat.setText("Defense:");
        jPanel2.add(playerDefenseStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 110, -1));

        playerAttackStat.setText("Attack:");
        jPanel2.add(playerAttackStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 200, 110, -1));

        enemyDefenseStat.setText("Defense:");
        jPanel2.add(enemyDefenseStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 90, -1));

        enemyAttackStat.setText("Attack:");
        jPanel2.add(enemyAttackStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 100, -1));

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timeLabel.setText("Time: 6");
        jPanel2.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 10, 70, 20));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Backgrounds/background.png"))); // NOI18N
        jPanel2.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed

        if (!cave) {
            if (playerLocationY < 5) {
                playerLocationY = playerLocationY + 1;
                sleepButton.setEnabled(false);
                shopButton.setEnabled(false);
                healButton.setEnabled(false);
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        } else if (cave) {
            if (playerLocationX == 1 && (playerLocationY == 3 || playerLocationY == 4)) {
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 2 && playerLocationY == 3) {
                playerLocationY = playerLocationY + 2;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 3 && playerLocationY == 2) {
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 4 && playerLocationY == 2) {
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 5 && playerLocationY == 2) {
                playerLocationY = playerLocationY + 2;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 5 && playerLocationY == 4) {
                playerLocationY = playerLocationY + 1;
                move();
                potionCheck();
                if (useRepelPot == 0) {
                    spawn();
                }
            } else if (playerLocationX == 6 && (playerLocationY == 3 || playerLocationY == 4)) {
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        }
    }//GEN-LAST:event_upButtonActionPerformed

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        int generator;// this detirmines how much damage you do
        generator = (int) (Math.random() * 100 + 1);
        if (generator <= 20) {
            gameLogOutput.append("Your attack missed!\n");
            enemyAttack();
        } else if (generator > 20 && generator <= 80) {
            playerBattleAttack = playerAttack;
            gameLogOutput.append("Your attack hit!\n");
            playerAttack();
            enemyAttack();
        } else if (generator > 80) {
            gameLogOutput.append("Your attack was a critical hit!\n");
            playerBattleAttack = (int) (player.getAttack() * 1.5);
            playerAttack();
            enemyAttack();
        }
    }//GEN-LAST:event_attackButtonActionPerformed

    private void healButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healButtonActionPerformed
        playerCurrentHealth = playerMaxHealth;// this heals you
        playerHealthStat.setText("HP:  " + playerCurrentHealth + "/" + playerMaxHealth);
        playerHealthBar.setValue((playerCurrentHealth / playerMaxHealth) * 100);
        gameLogOutput.append("You have been fully healed!\n");
    }//GEN-LAST:event_healButtonActionPerformed

    private void strengthPotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strengthPotionActionPerformed
        if (numStrengthPot > 0) {// this lets you use your strength potion 
            numStrengthPot = numStrengthPot - 1;
            useStrengthPot = 11;
            gameLogOutput.append("You used a Strength Potion.\n");
            playerAttack = playerAttack * 2;
            playerAttackStat.setText("Attack: " + playerAttack);
        } else if (numStrengthPot == 0) {
            gameLogOutput.append("You don't have any Strength Potions.\n");
        }
    }//GEN-LAST:event_strengthPotionActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed

        if (!cave) {
            if (playerLocationX < 6) {
                playerLocationX = playerLocationX + 1;
                sleepButton.setEnabled(false);
                shopButton.setEnabled(false);
                healButton.setEnabled(false);
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }

        } else if (cave) {
            if (playerLocationY == 2 && (playerLocationX == 3 || playerLocationX == 4)) {
                playerLocationX = playerLocationX + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                inBattle();
                potionCheck();
            } else if (playerLocationY == 3 && (playerLocationX == 1 || playerLocationX == 2 || playerLocationX == 3)) {
                playerLocationX = playerLocationX + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 3 && playerLocationX == 4) {
                playerLocationX = playerLocationX + 1;
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 4 && playerLocationX == 5) {
                playerLocationX = playerLocationX + 1;
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 5 && (playerLocationX == 1 || playerLocationX == 2 || playerLocationX == 5)) {
                playerLocationX = playerLocationX + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        }
    }//GEN-LAST:event_rightButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        if (!cave) {
            if (playerLocationY > 1) {
                playerLocationY = playerLocationY - 1;
                sleepButton.setEnabled(false);
                shopButton.setEnabled(false);
                healButton.setEnabled(false);
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        } else if (cave) {
            if (playerLocationX == 1 && (playerLocationY == 5 || playerLocationY == 4)) {
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 2 && playerLocationY == 5) {
                playerLocationY = playerLocationY - 2;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 3 && playerLocationY == 3) {
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 4 && playerLocationY == 3) {
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 5 && playerLocationY == 4) {
                playerLocationY = playerLocationY - 2;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 5 && playerLocationY == 5) {
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationX == 6 && (playerLocationY == 5 || playerLocationY == 4)) {
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        if (!cave) {
            if (playerLocationX > 1) {
                playerLocationX = playerLocationX - 1;
                sleepButton.setEnabled(false);
                shopButton.setEnabled(false);
                healButton.setEnabled(false);
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        } else if (cave) {
            if (playerLocationY == 2 && (playerLocationX == 5 || playerLocationX == 4)) {
                playerLocationX = playerLocationX - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 3 && (playerLocationX == 4 || playerLocationX == 3 || playerLocationX == 2)) {
                playerLocationX = playerLocationX - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 4 && playerLocationX == 5) {
                playerLocationX = playerLocationX - 1;
                playerLocationY = playerLocationY - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 3 && playerLocationX == 6) {
                playerLocationX = playerLocationX - 1;
                playerLocationY = playerLocationY + 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            } else if (playerLocationY == 5 && (playerLocationX == 6 || playerLocationX == 3 || playerLocationX == 3)) {
                playerLocationX = playerLocationX - 1;
                if (useRepelPot == 0) {
                    spawn();
                }
                move();
                potionCheck();
            }
        }
    }//GEN-LAST:event_leftButtonActionPerformed

    private void shopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopButtonActionPerformed
        if (shopScreen == null) {// this takes you to the shop screen
            shopScreen = new ShopScreen(this);
        }
        shopScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_shopButtonActionPerformed

    private void tutorialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialButtonActionPerformed
        if (guideScreen == null) {// this takes you to the tutorial screen
            guideScreen = new GuideScreen(this);
        }
        guideScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tutorialButtonActionPerformed

    private void repelPotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repelPotionActionPerformed
        if (numRepelPot > 0) {// lets you use a repel potion
            numRepelPot = numRepelPot - 1;
            useRepelPot = useRepelPot + 11;
            gameLogOutput.append("You used a Repel Potion.\n");
        } else if (numRepelPot == 0) {
            gameLogOutput.append("You don't have any Repel Potions.\n");
        }
    }//GEN-LAST:event_repelPotionActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        gameLogOutput.append("You have " + player.getHealthPots() + " Health Potions!\n"// diplays what you have in the game
                + "You have " + numStrengthPot + " Strength Potions!\n"
                + "You have " + numSpeedPot + " Speed Potions!\n"
                + "You have " + numRepelPot + " Repel Potions!\n"
                + "You have " + player.getCoins() + " Coins!\n");
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void sleepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sleepButtonActionPerformed
        time = 6;
        gameLogOutput.append("It's morning! (6am)\n");// lets you sleep
    }//GEN-LAST:event_sleepButtonActionPerformed

    private void fleeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fleeButtonActionPerformed
        int generator;// calculates you chance of fleeing battle
        generator = (int) (Math.random() * 100 + 1);//Determines whether you succeed at fleeing from a battle
        if (generator <= 30) {
            gameLogOutput.append("You fled the battle!\n");
            enemyDefenseStat.setText("Defense:");
            enemyHealthAmount.setText("Health:");
            enemyAttackStat.setText("Attack:");
            enemyPicture.setIcon(new ImageIcon("/CharacterAndEnemyIcons/Vipers.png"));
            enemyHealthBar.setValue(0);
            outBattle();
        } else if (generator > 30 && generator <= 100) {
            gameLogOutput.append("You failed to flee the battle!\n");
            enemyAttack();
        }
    }//GEN-LAST:event_fleeButtonActionPerformed

    private void speedPotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedPotionActionPerformed
        if (numSpeedPot > 0) {//Uses a speed potion or tells you that you do not have a potiion to use
            numSpeedPot = numSpeedPot - 1;
            useSpeedPot = useSpeedPot + 11;
            gameLogOutput.append("You used a Speed Potion.\n");
        } else if (numSpeedPot == 0) {
            gameLogOutput.append("You don't have any Speed Potions.\n");
        }
    }//GEN-LAST:event_speedPotionActionPerformed

    private void healthPotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthPotionActionPerformed
        if (player.getHealthPots() > 0) {//Uses a health potion or tells you that you do not have a potiion to use
            player.setHealthPots(player.getHealthPots() - 1);
            playerCurrentHealth = playerCurrentHealth + 70;
            playerHealthBar.setValue((int) ((double) playerCurrentHealth / (double) playerMaxHealth * 100));
            if (playerCurrentHealth > playerMaxHealth) {
                playerCurrentHealth = playerMaxHealth;
            }
            playerHealthStat.setText("HP:  " + playerCurrentHealth + "/" + playerMaxHealth);
            gameLogOutput.append("You used a Health Potion.\n");
        } else if (numSpeedPot == 0) {
            gameLogOutput.append("You don't have any Health Potions.\n");
        }
    }//GEN-LAST:event_healthPotionActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        player.setHealthPots(numHealthPot);// this lets you save the game
        player.setSpeedPots(numSpeedPot);
        player.setStrengthPots(numStrengthPot);
        player.setRepelPots(numRepelPot);

        PrintWriter pw = null;
        FileWriter fw = null;

        try {// this try and catch statment attems to write the following into a file
            fw = new FileWriter("src\\DataTextFiles\\Save.txt");
            pw = new PrintWriter(fw);

            pw.println(player.getName() + "");
            pw.println(player.getHealth() + "");
            pw.println(player.getArmour() + "");
            pw.println(player.getAttack() + "");
            pw.println(player.getCoins() + "");
            pw.println(player.getHealthPots() + "");
            pw.println(player.getSpeedPots() + "");
            pw.println(player.getStrengthPots() + "");
            pw.println(player.getRepelPots() + "");
            pw.println(player.getArcher() + "");
            pw.println(player.getKnight() + "");
            pw.println(player.getMage() + "");
            pw.println(numStrengthPot + "");
            pw.println(numSpeedPot + "");
            pw.println(numRepelPot + "");

            pw.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    // there are three labels that I don't know what they are and I don't want to delet them

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel background;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel enemyAttackStat;
    private javax.swing.JLabel enemyDefenseStat;
    private javax.swing.JLabel enemyHealthAmount;
    private javax.swing.JProgressBar enemyHealthBar;
    private javax.swing.JLabel enemyPicture;
    private javax.swing.JButton fleeButton;
    private javax.swing.JLabel gameLogLabel;
    private javax.swing.JTextArea gameLogOutput;
    private javax.swing.JButton healButton;
    private javax.swing.JButton healthPotion;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel miniMap;
    private javax.swing.JLabel playerAttackStat;
    private javax.swing.JLabel playerDefenseStat;
    private javax.swing.JProgressBar playerHealthBar;
    private javax.swing.JLabel playerHealthStat;
    private javax.swing.JLabel playerPicture;
    private javax.swing.JButton repelPotion;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton shopButton;
    private javax.swing.JButton sleepButton;
    private javax.swing.JButton speedPotion;
    private javax.swing.JButton strengthPotion;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton tutorialButton;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
