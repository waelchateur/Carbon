package tk.zielony.carbonsamples.widget;

import android.os.Bundle;
import android.view.View;

import com.annimon.stream.Stream;

import java.util.Random;

import carbon.widget.Chip;
import carbon.widget.FlowLayout;
import tk.zielony.carbonsamples.ActivityAnnotation;
import tk.zielony.carbonsamples.R;
import tk.zielony.carbonsamples.Samples;
import tk.zielony.carbonsamples.ThemedActivity;
import tk.zielony.randomdata.DataContext;
import tk.zielony.randomdata.person.DrawableAvatarGenerator;
import tk.zielony.randomdata.person.Gender;
import tk.zielony.randomdata.person.StringFirstNameGenerator;

@ActivityAnnotation(layout = R.layout.activity_flowlayout, title = R.string.flowLayoutActivity_title)
public class FlowLayoutActivity extends ThemedActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Samples.initToolbar(this);

        DrawableAvatarGenerator avatarGenerator = new DrawableAvatarGenerator(this);
        StringFirstNameGenerator nameGenerator = new StringFirstNameGenerator(Gender.Both, false, false);

        Random random = new Random();
        FlowLayout layout = findViewById(R.id.flowLayout);
        Stream.of(layout.getViews()).filter(v -> v instanceof Chip).forEach(v -> {
            final Chip chip = (Chip) v;
            DataContext dataContext = new DataContext();
            chip.setText(nameGenerator.next(dataContext));
            if (random.nextBoolean())
                chip.setIcon(avatarGenerator.next(dataContext));
            chip.setRemovable(random.nextBoolean());
            chip.setOnRemoveListener(() -> {
                chip.setVisibility(View.GONE);
            });
        });
    }
}
