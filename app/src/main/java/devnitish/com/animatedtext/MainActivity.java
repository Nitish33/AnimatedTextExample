package devnitish.com.animatedtext;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AnimatedTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.animatedText2);

        getSupportActionBar().setTitle("Animated Text");


        ArrayList<String> allString = new ArrayList<>();
//        allString.add("N");
        allString.add("Nitish");
        allString.add(" Prasad");
        allString.add("How are you.What are you doing.");
        allString.add("Do you know");
        allString.add("Mai Tenu Kina pyar karta");
        allString.add("Do you know");
        allString.add("Mai Tere una kina marta");


        ArrayList<Integer> allInteger = new ArrayList<>();
//        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);
        allInteger.add(50);

        ArrayList<Integer> allDelays = new ArrayList<>();
//        allDelays.add(1000);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(100);
        allDelays.add(500);
        allDelays.add(10);
        allDelays.add(500);
        allDelays.add(10);

        textView.animateText(allString,allInteger,allDelays,true);

    }
}
