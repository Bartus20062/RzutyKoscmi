package com.example.grawkosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private int wynik1 =0;
private int wynik2 =0;
private int liczba =0;
private TextView kosc1;
private TextView kosc2;
private TextView kosc3;
private TextView kosc4;
private TextView kosc5;
private TextView [] rzuty= new TextView[5];
private int[] rzutyKosc = new int[5];
private TextView wynik1View;
private TextView wynik2View;
private TextView liczba1View;
private Button roll;
private Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);

        rzuty[0] = kosc1;
        rzuty[1] = kosc2;
        rzuty[2] = kosc3;
        rzuty[3] = kosc4;
        rzuty[4] = kosc5;


        wynik1View = findViewById(R.id.wynik1);
        wynik2View = findViewById(R.id.wynik2);
        liczba1View = findViewById(R.id.liczba);

        roll = findViewById(R.id.rollButton);
        reset = findViewById(R.id.reset);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
        void roll() {
            Random random =new Random();
            int sum =0;
            for(int i=0; i<rzutyKosc.length; i++){
                int rzut = random.nextInt(6)+1;

                rzutyKosc[i]= rzut;
                sum+=rzut;
            }
            aktualizujwynik(sum);
            zaktualizujRzuty();
            wynikGry(rzutyKosc);

        }
        void reset(){
        for(int i=0; i<rzuty.length;i++){
            rzuty[i].setText("?");
        }
        wynik1 =0;
        wynik2 =0;
        liczba =0;

        wynik1View.setText("Wynik tego losowania: 0");
        wynik2View.setText("Wynik gry: 0");
        liczba1View.setText("Liczba rzutów: 0");
        }

        void aktualizujwynik(int newWynik){
            System.out.println(newWynik);
            wynik2 += newWynik;
            wynik1View.setText("Wynik tego losowania: "+ String.valueOf(newWynik));
            wynik2View.setText("Wynik gry: "+ String.valueOf(wynik2));
        }
        void zaktualizujRzuty() {
        liczba++;
        liczba1View.setText("Liczba rzutów: " + String.valueOf(liczba));
        }
        void wynikGry(int[] wynikGry){
        for(int i=0; i< rzuty.length; i++) {
            rzuty[i].setText(String.valueOf(wynikGry[i]));
        }
        }
    }
