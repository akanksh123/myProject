package com.example.lenovo.animations2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener {
Animation animFadeIn;
    Animation animFadeOut;
    Animation animFadeInOut;

    Animation animLeftRight;
    Animation animRightLeft;
    Animation animTopBottom;
    Animation animBounce;
    Animation animFlash;
    Animation animRotateLeft;
    Animation animRotateRight;
    ImageView imageView;
    TextView textStatus;
    Button btnFadeIn;
    Button btnFadeOut;
    Button btnFadeInOut;
    Button zoomIn;
    Button zoomOut;
    Button leftRight;
    Button rightLeft;
    Button topBottom;
    Button bounce;
    Button flash;
    Button rotateLeft;
    Button rotateRight;
    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;
    int seekSpeedProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAnimations();   loadUI();
    }
    private void loadAnimations(){
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        animFadeOut = AnimationUtils.loadAnimation(this,      R.anim.fade_out);
        animFadeInOut = AnimationUtils.loadAnimation(this,      R.anim.fade_in_out);

        animLeftRight = AnimationUtils.loadAnimation(this,      R.anim.left_right);
        animRightLeft = AnimationUtils.loadAnimation(this,      R.anim.right_left);
        animTopBottom = AnimationUtils.loadAnimation(this,      R.anim.top_bot);
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
        animRotateLeft = AnimationUtils.loadAnimation(this,      R.anim.rotate_left);
        animRotateRight = AnimationUtils.loadAnimation(this,
                R.anim.rotate_right);
    }
    @Override
    public void onAnimationEnd(Animation animation) {   textStatus.setText("STOPPED"); }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    @Override
    public void onAnimationStart(Animation animation) {   textStatus.setText("RUNNING");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){   case R.id.btnFadein:
            animFadeIn.setDuration(seekSpeedProgress);
            animFadeIn.setAnimationListener(this);
            imageView.startAnimation(animFadeIn);
            break;   case R.id.btnFadeout:
            animFadeOut.setDuration(seekSpeedProgress);
            animFadeOut.setAnimationListener(this);
            imageView.startAnimation(animFadeOut);
            break;   case R.id.btnFadeinout:
            animFadeInOut.setDuration(seekSpeedProgress);
            animFadeInOut.setAnimationListener(this);
            imageView.startAnimation(animFadeInOut);     break;

            case R.id.btnLeftright:
                animLeftRight.setDuration(seekSpeedProgress);
                animLeftRight.setAnimationListener(this);
                imageView.startAnimation(animLeftRight);     break;
            case R.id.btnRightleft:
                animRightLeft.setDuration(seekSpeedProgress);
                animRightLeft.setAnimationListener(this);
                imageView.startAnimation(animRightLeft);     break;
            case R.id.btnTopbottom:
                animTopBottom.setDuration(seekSpeedProgress);
                animTopBottom.setAnimationListener(this);
                imageView.startAnimation(animTopBottom);     break;
            case R.id.btnbounce:
                animBounce.setDuration(seekSpeedProgress / 10);
                animBounce.setAnimationListener(this);
                imageView.startAnimation(animBounce);     break;
            case R.id.btnFlash:     animFlash.setDuration(seekSpeedProgress / 10);
            animFlash.setAnimationListener(this);     imageView.startAnimation(animFlash);
                break;
            case R.id.btnRotateleft:
                animRotateLeft.setDuration(seekSpeedProgress);
                animRotateLeft.setAnimationListener(this);
                imageView.startAnimation(animRotateLeft);
                break;
            case R.id.btnRotateright:
                animRotateRight.setDuration(seekSpeedProgress);
                animRotateRight.setAnimationListener(this);
                imageView.startAnimation(animRotateRight);
                break;
        }
    }




    private void loadUI(){
        imageView = (ImageView) findViewById(R.id.imageView);
        textStatus = (TextView) findViewById(R.id.textStatus);
        btnFadeIn = (Button) findViewById(R.id.btnFadein);
        btnFadeOut = (Button) findViewById(R.id.btnFadeout);
        btnFadeInOut = (Button) findViewById(R.id.btnFadeinout);
        zoomIn = (Button) findViewById(R.id.btnZoomin);
        zoomOut = (Button) findViewById(R.id.btnZoomout);
        leftRight = (Button) findViewById(R.id.btnLeftright);
        rightLeft = (Button) findViewById(R.id.btnRightleft);
        topBottom = (Button) findViewById(R.id.btnTopbottom);
        bounce = (Button) findViewById(R.id.btnbounce);
        flash = (Button) findViewById(R.id.btnFlash);
        rotateLeft = (Button) findViewById(R.id.btnRotateleft);
        rotateRight = (Button) findViewById(R.id.btnRotateright);
        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnFadeInOut.setOnClickListener(this);
        zoomIn.setOnClickListener(this);
        zoomOut.setOnClickListener(this);
        leftRight.setOnClickListener(this);
        rightLeft.setOnClickListener(this);
        topBottom.setOnClickListener(this);
        bounce.setOnClickListener(this);
        flash.setOnClickListener(this);
        rotateLeft.setOnClickListener(this);
        rotateRight.setOnClickListener(this);
        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarspeed);
        textSeekerSpeed = (TextView) findViewById(R.id.textSeekerspeed);
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar. OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekSpeedProgress = progress;
                textSeekerSpeed.setText("" + seekSpeedProgress + " of " +      seekBarSpeed.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }});
    }



}
