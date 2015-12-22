package me.zhuao.android.sample;

import android.content.Intent;
import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.util.List;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21, application = SampleApplication.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Test
    public void should_display_button_to_open_stepIndicator() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        Button stepIndicatorButton = (Button) mainActivity.findViewById(R.id.function_list_step_indicator);
        assertThat(stepIndicatorButton).containsText("Step Indicator");

        stepIndicatorButton.performClick();

        List<Intent> nextStartedActivity = ShadowApplication.getInstance().getBroadcastIntents();

        assert(nextStartedActivity.get(0).getData().toString()).equals("AndroidSketch:///indicator");
    }

}