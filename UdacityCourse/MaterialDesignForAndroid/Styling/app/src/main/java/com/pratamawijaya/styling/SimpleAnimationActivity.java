package com.pratamawijaya.styling;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleAnimationActivity extends AppCompatActivity {

  @Bind(R.id.hitme) Button btnHitme;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_animation);
    ButterKnife.bind(this);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });
  }

  @OnClick(R.id.hitme) public void hitMe() {

    /**
     * min api 19
     */
    //TransitionManager.go(Scene.getSceneForLayout((ViewGroup) findViewById(R.id.root),
    //    R.layout.activity_simple_animation, SimpleAnimationActivity.this));
    //TransitionInflater.from(this).inflateTransition(R.transition.default_to_info);

    /**
     * api 21
     */
    //Slide slide = new Slide();
    //slide.setSlideEdge(Gravity.TOP);

    /**
     * cara 1
     */

    //AnimationSet animationSet = new AnimationSet(this, null);
    //animationSet.addAnimation(new AlphaAnimation(1f, 0f));
    //animationSet.addAnimation(new TranslateAnimation(0, 0, 0, -btnHitme.getHeight()));
    //animationSet.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
    //animationSet.setAnimationListener(new Animation.AnimationListener() {
    //  @Override public void onAnimationStart(Animation animation) {
    //
    //  }
    //
    //  @Override public void onAnimationEnd(Animation animation) {
    //    btnHitme.setVisibility(View.GONE);
    //    startActivity(new Intent(SimpleAnimationActivity.this,MainActivity.class));
    //    //overridePendingTransition(R.anim.ac);
    //  }
    //
    //  @Override public void onAnimationRepeat(Animation animation) {
    //
    //  }
    //});
    //btnHitme.startAnimation(animationSet);

    /**
     * cara 2
     */

    //AnimationSet animationSet = new AnimationSet(this, null);
    //animationSet.addAnimation(new AlphaAnimation(1f, 0f));
    //animationSet.addAnimation(new TranslateAnimation(0, 0, 0, -btnHitme.getHeight()));
    //animationSet.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));

    //Animation animationSet = AnimationUtils.loadAnimation(this,R.anim.slideoutbutton);
    //animationSet.setAnimationListener(new Animation.AnimationListener() {
    //  @Override public void onAnimationStart(Animation animation) {
    //
    //  }
    //
    //  @Override public void onAnimationEnd(Animation animation) {
    //    btnHitme.setVisibility(View.GONE);
    //    startActivity(new Intent(SimpleAnimationActivity.this,MainActivity.class));
    //    //overridePendingTransition(R.anim.ac);
    //  }
    //
    //  @Override public void onAnimationRepeat(Animation animation) {
    //
    //  }
    //});
    //btnHitme.startAnimation(animationSet);

    /**
     * cara 3
     */

    //btnHitme.animate()
    //    .alpha(0f)
    //    .translationY(-btnHitme.getHeight())
    //    .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
    //    .withEndAction(
    //        () -> startActivity(new Intent(SimpleAnimationActivity.this, MainActivity.class)));

    /**
     * cara 4
     */
    //ObjectAnimator.ofObject(btnHitme, "textColor", new ArgbEvaluator(), Color.BLACK, Color.RED)
    //    .setDuration(1000)
    //    .start();
  }
}
