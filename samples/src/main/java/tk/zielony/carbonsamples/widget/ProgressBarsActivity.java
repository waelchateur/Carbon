package tk.zielony.carbonsamples.widget;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import carbon.widget.ProgressBar;
import tk.zielony.carbonsamples.ActivityAnnotation;
import tk.zielony.carbonsamples.R;
import tk.zielony.carbonsamples.Samples;
import tk.zielony.carbonsamples.ThemedActivity;

@ActivityAnnotation(layout = R.layout.activity_progress_bars, title = R.string.progressBarsActivity_title)
public class ProgressBarsActivity extends ThemedActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Samples.initToolbar(this);

        final ProgressBar progress1 = findViewById(R.id.progress5);
        findViewById(R.id.button1).setOnClickListener(view -> progress1.animateVisibility(progress1.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE));

        final ProgressBar progress2 = findViewById(R.id.progress6);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progress2.setProgress((float) (progress2.getProgress() + Math.random() / 100));
                if (progress2.getProgress() < 1) {
                    handler.postDelayed(this, 10);
                } else {
                    progress2.animateVisibility(View.INVISIBLE);
                }
            }
        };
        findViewById(R.id.button2).setOnClickListener(view -> progress2.animateVisibility(progress2.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE));

        final ProgressBar progress3 = findViewById(R.id.progress7);
        findViewById(R.id.button3).setOnClickListener(view -> progress3.animateVisibility(progress3.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE));

        handler.postDelayed(runnable, 10);
    }
}
