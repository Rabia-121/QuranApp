package com.example.quranapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnVF);
        Button Gitbtn = findViewById(R.id.btnGitLink);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText surahNumber = findViewById(R.id.textSurahNo);
            EditText verseNumber = findViewById(R.id.textVerseNo);
            if (!surahNumber.getText().toString().equals("") && !verseNumber.getText().toString().equals("")) {
                String surahNoStirng = surahNumber.getText().toString();
                int surahNo = Integer.parseInt(surahNoStirng);
                if (surahNo > 0 && surahNo <= 114) {
                    String verseNoStirng = verseNumber.getText().toString();
                    int verseNo = Integer.parseInt(verseNoStirng);
                    QuranText quranText = new QuranText();
                    FindPSV quranIndexing = new FindPSV();
                    int surahAyatCount = quranIndexing.surahAyatCount[surahNo - 1];
                    if (verseNo > surahAyatCount || verseNo <= 0) {
                        Toast.makeText(MainActivity.this, "Enter Verse from 1 to " + surahAyatCount, Toast.LENGTH_SHORT).show();
                    } else {
                        int indexOfSSPInQuranArabicText = quranIndexing.SSP[surahNo - 1];
                        String surahVerseInQAT = quranText.QuranAllText[indexOfSSPInQuranArabicText + (verseNo - 1)];
                        TextView txtVerseFinder = findViewById(R.id.textVerseArabic);
                        txtVerseFinder.setText(surahVerseInQAT);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter Surah No from 1 to 114", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Fill all of the Fields", Toast.LENGTH_LONG).show();
            }
        }
        });
    }
   // Gitbtn.setOnClickListener(new View.OnClickListener(){
    //    @Override
  //      public void onClick(View view){
//          Uri uri = Uri.parse("https://github.com/Rabia-121/AndroidTasks"); // missing 'http://' will cause crashed
//Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//startActivity(intent);
      //  }
    //}
    protected void onSaveInstanceState(Bundle outState){
        int indexOfSSPInQuranArabicText = quranIndexing.SSP[surahNo - 1];
        String surahVerseInQAT = quranText.QuranAllText[indexOfSSPInQuranArabicText + (verseNo - 1)];
        TextView txtVerseFinder = findViewById(R.id.textVerseArabic);
        txtVerseFinder.setText(surahVerseInQAT);
        outState.putString("Text",);
        super.onSaveInstanceState(outState);
    }
}