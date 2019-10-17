package net.manisha.SishuKalyan;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class VoiceTherapy extends AppCompatActivity implements TextToSpeech.OnInitListener {

    int count;
    Button startButton;
    TextToSpeech tts;
    ArrayList<String> speechTextList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_voice_therapy);

        startButton = findViewById(R.id.startButton);
        speechTextList = new ArrayList<>();

        speechTextList.add("My mom drop me to school");
        speechTextList.add("The mouse was so hungry ");
        speechTextList.add("I couldn't talk anymore");
        speechTextList.add("I found a gold coin");
        speechTextList.add("My dad is so funny");

        tts = new TextToSpeech(this, this);
        tts.setLanguage(Locale.forLanguageTag("hin"));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut("Repeat After Me");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                speakOut(speechTextList.get(count));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                getSpeechInput(startButton);
            }
        });
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent, 10);

    }

    public void speakOut(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                SimilarityStrategy strategy = new JaroWinklerStrategy();
                String target = Objects.requireNonNull(result).get(0);
                String source = speechTextList.get(count);

                StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
                double score = service.score(source, target);

                if (score > 0.90) {

                    speakOut("Very well done");
                    count++;
                    count = count%5;
                } else if (score > 0.50) {

                    speakOut("You need to practice more");
                    count++;
                    count = count%5;
                } else {
                    speakOut("Oops, you missed it. Please Try again");
                    count--;
                    count = count%5;
                }
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }


    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.forLanguageTag("hin"));
            tts.setPitch((float) 0.70);
        }
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
