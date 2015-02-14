package me.pratama.examplematerial.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import me.pratama.examplematerial.BaseActivity;
import me.pratama.examplematerial.R;
import me.pratama.examplematerial.interpolator.CubicBezierInterpolator;

/**
 * <p>implement fab Expand
 * <p/>
 * <p/>
 * <p>Thanks +ChrisBasha</p>
 * <p>https://plus.google.com/+ChrisBasha</p>
 * <p/>
 * <p>
 * https://plus.google.com/+ChrisBasha/posts/awch8jDHawp
 * source : https://gist.github.com/chris95x8/882b5c5d0aa2096236ba
 * </p>
 */
public class FabActivity extends BaseActivity {

    @InjectView(R.id.btnFAB)
    ImageButton btnFAB;
    @InjectView(R.id.expanded_view)
    RelativeLayout expandedView;
    @InjectView(R.id.act_collapse)
    ImageButton btnCollapse;
    @InjectView(R.id.btn_action_1)
    ImageButton btnAct1;
    @InjectView(R.id.btn_action_2)
    ImageButton btnAct2;
    @InjectView(R.id.btn_action_3)
    ImageButton btnAct3;
    @InjectView(R.id.btn_action_4)
    ImageButton btnAct4;

    public static final int FAB_STATE_COLLAPSED = 0;
    public static final int FAB_STATE_EXPANDED = 1;

    public static int FAB_CURRENT_STATE = FAB_STATE_COLLAPSED;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        ButterKnife.inject(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btnFAB)
    public void onBtnFabClick() {
        revealView(expandedView);

        FAB_CURRENT_STATE = FAB_STATE_EXPANDED;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnFAB.setVisibility(View.GONE);
            }
        }, 50);

        btnCollapse.animate().rotationBy(135).setDuration(250).start();
    }

    @OnClick(R.id.act_collapse)
    public void onCollapseBtnClick() {
        hideView(expandedView);

        FAB_CURRENT_STATE = FAB_STATE_COLLAPSED;

        btnCollapse.animate().rotationBy(-135).setDuration(250).start();

    }

    private void hideView(final View expandedView) {
        int cx = (btnFAB.getLeft() + btnFAB.getRight()) / 2;
        int cy = (btnFAB.getTop() + btnFAB.getBottom()) / 2;

        int initialRadius = expandedView.getWidth();

        Animator anim = ViewAnimationUtils.createCircularReveal(expandedView, cx, cy, initialRadius, 0);
        anim.setDuration(300);
        anim.setInterpolator(getLinearOutSlowInInterpolator());

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                expandedView.setVisibility(View.INVISIBLE);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnFAB.setVisibility(View.VISIBLE);
            }
        }, 200);

        anim.start();

    }

    private void revealView(final View expandedView) {
        int cx = (btnFAB.getLeft() + btnFAB.getRight()) / 2;
        int cy = (btnFAB.getTop() + btnFAB.getBottom()) / 2;

        int finalRadius = Math.max(expandedView.getWidth(), expandedView.getHeight());

        Animator anim =
                ViewAnimationUtils.createCircularReveal(expandedView, cx, cy, 0, finalRadius);
        anim.setDuration(300);

        expandedView.setVisibility(View.VISIBLE);

        slideView(btnAct1);
        slideView(btnAct2);
        slideView(btnAct3);
        slideView(btnAct4);

        anim.start();
    }

    //Animation to slide the action buttons
    public void slideView(View view) {
        ObjectAnimator slide = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 112, 0);
        slide.setDuration(500);
        slide.setInterpolator(getLinearOutSlowInInterpolator());
        slide.start();
    }

    public static Interpolator getLinearOutSlowInInterpolator() {
        //Decelerate Interpolator - For elements that enter the screen
        return new CubicBezierInterpolator(0, 0, 0.2, 1);
    }


    public static Interpolator getFastInSlowOutInterpolator() {
        //Ease In Out Interpolator - For elements that change position while staying in the screen
        return new CubicBezierInterpolator(0.4, 0, 0.2, 1);
    }

}
