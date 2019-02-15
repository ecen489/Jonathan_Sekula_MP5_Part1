package com.example.jonathan.mp5_part1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageView imageView;
    ImageButton imageButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.group);
        imageView = findViewById(R.id.image);
        imageButton = findViewById(R.id.play);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                boolean isChecked = radioButton.isChecked();

                if (isChecked) {
                    Log.d("tag", String.valueOf(checkedId));
                    switch(checkedId) {
                        case R.id.mockingbird:
                            if (mediaPlayer != null && mediaPlayer.isPlaying()){
                                mediaPlayer.stop();
                                mediaPlayer.release();
                            }
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mockingbird);
                            mediaPlayer.start();
                            imageView.setBackgroundResource(R.drawable.encore);
                            imageButton.setImageResource(R.drawable.baseline_pause_black_48dp);
                            break;
                        case R.id.ride:
                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                                mediaPlayer.release();
                            }
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ride);
                            mediaPlayer.start();
                            imageView.setBackgroundResource(R.drawable.blurryface);
                            imageButton.setImageResource(R.drawable.baseline_pause_black_48dp);
                            break;
                        case R.id.walkingthewire:
                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                                mediaPlayer.release();
                            }
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.walkingthewire);
                            mediaPlayer.start();
                            imageView.setBackgroundResource(R.drawable.evolve);
                            imageButton.setImageResource(R.drawable.baseline_pause_black_48dp);
                            break;
                        default:
                            break;
                    }
                }
                //else {
                  //  mediaPlayer.stop();
                    //imageButton.setImageResource(R.drawable.baseline_play_arrow_black_48dp);
                //}

            }
        });

    }

    public void PreviousNext(View view) {
        int button_id = view.getId();
        String id_string = "";
        if (button_id == R.id.previous)
            id_string = "previous";
        else
            id_string = "next";

        RadioButton radioButton_current;
        RadioButton radioButton_next;

        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.mockingbird:
                radioButton_current = findViewById(radioGroup.getCheckedRadioButtonId());
                radioButton_current.setChecked(false);
                if (id_string.matches("next")) {
                    radioButton_next = findViewById(R.id.ride);
                    radioButton_next.setChecked(true);
                }
                else {
                    radioButton_next = findViewById(R.id.walkingthewire);
                    radioButton_next.setChecked(true);
                }
                break;
            case R.id.ride:
                radioButton_current = findViewById(radioGroup.getCheckedRadioButtonId());
                radioButton_current.setChecked(false);
                if (id_string.matches("next")) {
                    radioButton_next = findViewById(R.id.walkingthewire);
                    radioButton_next.setChecked(true);
                }
                else {
                    radioButton_next = findViewById(R.id.mockingbird);
                    radioButton_next.setChecked(true);
                }
                break;
            case R.id.walkingthewire:
                radioButton_current = findViewById(radioGroup.getCheckedRadioButtonId());
                radioButton_current.setChecked(false);
                if (id_string.matches("next")) {
                    radioButton_next = findViewById(R.id.mockingbird);
                    radioButton_next.setChecked(true);
                }
                else {
                    radioButton_next = findViewById(R.id.ride);
                    radioButton_next.setChecked(true);
                }
                break;
        }

    }

    public void PlayPause(View view) {
        ImageButton imageButton = findViewById(view.getId());

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            imageButton.setImageResource(R.drawable.baseline_play_arrow_black_48dp);
        }
        else if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            imageButton.setImageResource(R.drawable.baseline_pause_black_48dp);
        }

    }
}
