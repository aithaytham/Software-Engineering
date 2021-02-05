package fr.isep.ii3510.assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Hangman extends AppCompatActivity {
    private TextView[] ViewsTab = new TextView[11];
    private TextView mText2;
    private TextView mtext;
    private TextView mWord;
    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;
    private Button mButtonD;
    private Button mButtonE;
    private Button mButtonF;
    private Button mButtonG;
    private Button mButtonH;
    private Button mButtonI;
    private Button mButtonJ;
    private Button mButtonK;
    private Button mButtonL;
    private Button mButtonM;
    private Button mButtonN;
    private Button mButtonO;
    private Button mButtonP;
    private Button mButtonQ;
    private Button mButtonR;
    private Button mButtonS;
    private Button mButtonT;
    private Button mButtonU;
    private Button mButtonV;
    private Button mButtonW;
    private Button mButtonX;
    private Button mButtonY;
    private Button mButtonZ;
    private String currentWord ;
    private int numberCharac ;
    private int nblife=10 ;
    private int nbcorrect=0 ;
    private int valueSize ;
    private String[] words;
    private Random rand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        words = res.getStringArray(R.array.words);
        rand = new Random();
        currentWord = "";
        playGame();

    }
    public void playGame (){

        setContentView(R.layout.activity_hangman);
        initialisation();
        String newWord = words[rand.nextInt(words.length)];
        while (newWord.equals(currentWord))  {
            newWord = words[rand.nextInt(words.length)];
        }
        currentWord = newWord;



       for (int c = 0; c <currentWord.length(); c++) {
            if(c==0){
            ViewsTab[c] = (TextView) findViewById(R.id.textView13);
            }
            if(c==1){
            ViewsTab[c] = (TextView) findViewById(R.id.textView12);}
            if(c==2){
            ViewsTab[c] = (TextView) findViewById(R.id.textView11);}
            if(c==3){
            ViewsTab[c] = (TextView) findViewById(R.id.textView10);}
            if(c==4){
            ViewsTab[c] = (TextView) findViewById(R.id.textView9);}
            if(c==5){
            ViewsTab[c] = (TextView) findViewById(R.id.textView8);}
            if(c==6){
            ViewsTab[c] = (TextView) findViewById(R.id.textView7);}
            if(c==7){
            ViewsTab[c] = (TextView) findViewById(R.id.textView5);}
            if(c==8){
            ViewsTab[c] = (TextView) findViewById(R.id.textView4);}
            if(c==9){
            ViewsTab[c] = (TextView) findViewById(R.id.textView3);}
            if(c==10){
            ViewsTab[c] = (TextView) findViewById(R.id.textView2);}
            ViewsTab[c].setBackgroundResource(R.drawable.letter_undli);

            ViewsTab[c].setText(Character.toString(currentWord.charAt(c)));
            ViewsTab[c].setGravity(Gravity.CENTER);
            ViewsTab[c].setTextColor(Color.WHITE);

        }
        numberCharac=currentWord.length();
        alltheOnClick();

    }
    public void initialisation (){
        mText2 =(TextView) findViewById(R.id.textView6);
        mtext = (TextView) findViewById(R.id.textView);
        mButtonA = (Button) findViewById(R.id.button11);
        mButtonB = (Button) findViewById(R.id.button10);
        mButtonC = (Button) findViewById(R.id.button9);
        mButtonD = (Button) findViewById(R.id.button8);
        mButtonE = (Button) findViewById(R.id.button7);
        mButtonF = (Button) findViewById(R.id.button6);
        mButtonG = (Button) findViewById(R.id.button5);
        mButtonH = (Button) findViewById(R.id.button4);
        mButtonI = (Button) findViewById(R.id.button3);
        mButtonJ = (Button) findViewById(R.id.button2);
        mButtonK = (Button) findViewById(R.id.button22);
        mButtonL = (Button) findViewById(R.id.button21);
        mButtonM = (Button) findViewById(R.id.button20);
        mButtonN = (Button) findViewById(R.id.button19);
        mButtonO = (Button) findViewById(R.id.button18);
        mButtonP = (Button) findViewById(R.id.button17);
        mButtonQ = (Button) findViewById(R.id.button16);
        mButtonR = (Button) findViewById(R.id.button15);
        mButtonS = (Button) findViewById(R.id.button14);
        mButtonT = (Button) findViewById(R.id.button13);
        mButtonU = (Button) findViewById(R.id.button12);
        mButtonV = (Button) findViewById(R.id.button28);
        mButtonW = (Button) findViewById(R.id.button27);
        mButtonX = (Button) findViewById(R.id.button26);
        mButtonY = (Button) findViewById(R.id.button25);
        mButtonZ = (Button) findViewById(R.id.button24);

    }
    public void alltheOnClick (){
        final AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
        final AlertDialog.Builder loseBuild = new AlertDialog.Builder(this);

        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='a'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonA.setBackgroundColor(Color.GREEN);
                        mButtonA.setEnabled(false);
                    }
                }
                if(correct){
                if (nbcorrect == numberCharac) {

                    // Display Alert Dialog
                    winBuild.setTitle("Good Job");
                    winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                    winBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    winBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    winBuild.show();
                    correct=false;
                    nbcorrect=0;
                    nblife=10;
                }}
                else if (nblife>0){
                    nblife--;
                    mButtonA.setBackgroundColor(Color.RED);
                    mButtonA.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='b'){
                        correct = true;
 nbcorrect++;
                          ViewsTab[i].setTextColor(Color.BLACK);
                        mButtonB.setBackgroundColor(Color.GREEN);
                        ViewsTab[i].setTextColor(Color.BLACK);
                        mButtonB.setEnabled(false);
                    }
                }
                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonB.setBackgroundColor(Color.RED);
                    mButtonB.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='c'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonC.setBackgroundColor(Color.GREEN);
                        mButtonC.setEnabled(false);
                    }
                }
                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonC.setBackgroundColor(Color.RED);
                    mButtonC.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if (currentWord.charAt(i) == 'd') {
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonD.setBackgroundColor(Color.GREEN);
                        mButtonD.setEnabled(false);
                    }
                }
                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonD.setBackgroundColor(Color.RED);
                    mButtonD.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='e'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonE.setBackgroundColor(Color.GREEN);
                        mButtonE.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonE.setBackgroundColor(Color.RED);
                    mButtonE.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='f'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonF.setBackgroundColor(Color.GREEN);
                        mButtonF.setEnabled(false);
                    }
                }
                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonF.setBackgroundColor(Color.RED);
                    mButtonF.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='g'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonG.setBackgroundColor(Color.GREEN);
                        mButtonG.setEnabled(false);
                    }
                }
                if(correct==false){
                    nblife--;
                    mButtonG.setBackgroundColor(Color.RED);
                    mButtonG.setEnabled(false);

                }
                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonF.setBackgroundColor(Color.RED);
                    mButtonF.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }

                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='h'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonH.setBackgroundColor(Color.GREEN);
                        mButtonH.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonH.setBackgroundColor(Color.RED);
                    mButtonH.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='i'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonI.setBackgroundColor(Color.GREEN);
                        mButtonI.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonI.setBackgroundColor(Color.RED);
                    mButtonI.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='j'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonJ.setBackgroundColor(Color.GREEN);
                        mButtonJ.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonJ.setBackgroundColor(Color.RED);
                    mButtonJ.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='k'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonK.setBackgroundColor(Color.GREEN);
                        mButtonK.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonK.setBackgroundColor(Color.RED);
                    mButtonK.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));

            }
        });
        mButtonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='l'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonL.setBackgroundColor(Color.GREEN);
                        mButtonL.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonL.setBackgroundColor(Color.RED);
                    mButtonL.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='m'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonM.setBackgroundColor(Color.GREEN);
                        mButtonM.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonM.setBackgroundColor(Color.RED);
                    mButtonM.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='n'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonN.setBackgroundColor(Color.GREEN);
                        mButtonN.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonN.setBackgroundColor(Color.RED);
                    mButtonN.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='o'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonO.setBackgroundColor(Color.GREEN);
                        mButtonO.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonO.setBackgroundColor(Color.RED);
                    mButtonO.setEnabled(false);

                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='p'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonP.setBackgroundColor(Color.GREEN);
                        mButtonP.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonP.setBackgroundColor(Color.RED);
                    mButtonP.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='q'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonQ.setBackgroundColor(Color.GREEN);
                        mButtonQ.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonQ.setBackgroundColor(Color.RED);
                    mButtonQ.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='r'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonR.setBackgroundColor(Color.GREEN);
                        mButtonR.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonR.setBackgroundColor(Color.RED);
                    mButtonR.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='s'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonS.setBackgroundColor(Color.GREEN);
                        mButtonS.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonS.setBackgroundColor(Color.RED);
                    mButtonS.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='t'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonT.setBackgroundColor(Color.GREEN);
                        mButtonT.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonT.setBackgroundColor(Color.RED);
                    mButtonT.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='u'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonU.setBackgroundColor(Color.GREEN);
                        mButtonU.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonU.setBackgroundColor(Color.RED);
                    mButtonU.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='v'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonV.setBackgroundColor(Color.GREEN);
                        mButtonV.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonV.setBackgroundColor(Color.RED);
                    mButtonV.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='w'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonW.setBackgroundColor(Color.GREEN);
                        mButtonW.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonW.setBackgroundColor(Color.RED);
                    mButtonW.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='x'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonX.setBackgroundColor(Color.GREEN);
                        mButtonX.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonX.setBackgroundColor(Color.RED);
                    mButtonX.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='y'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonY.setBackgroundColor(Color.GREEN);
                        mButtonY.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonY.setBackgroundColor(Color.RED);
                    mButtonY.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });
        mButtonZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correct = false;
                for(int i = 0; i < currentWord.length(); i++) {
                    if(currentWord.charAt(i)=='z'){
                        correct = true;
 nbcorrect++;                       ViewsTab[i].setTextColor(Color.BLACK);
mButtonZ.setBackgroundColor(Color.GREEN);
                        mButtonZ.setEnabled(false);
                    }
                }

                if(correct){
                    if (nbcorrect == numberCharac) {

                        // Display Alert Dialog
                        winBuild.setTitle("Good Job");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+currentWord);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.playGame();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Hangman.this.finish();
                                    }});

                        winBuild.show();
                        correct=false;
                        nbcorrect=0;
                        nblife=10;
                    }}
                else if (nblife>0){
                    nblife--;
                    mButtonZ.setBackgroundColor(Color.RED);
                    mButtonZ.setEnabled(false);
                }
                if(nblife<1) {

                    loseBuild.setTitle("Dommage");
                    loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+currentWord);
                    loseBuild.setPositiveButton("Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.playGame();
                                }});

                    loseBuild.setNegativeButton("Exit",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Hangman.this.finish();
                                }});

                    loseBuild.show();
                    nbcorrect=0;
                    nblife=10;
                }
                mtext.setText(Integer.toString(nblife));
            }
        });

    }

}
