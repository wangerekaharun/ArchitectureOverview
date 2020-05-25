package ke.co.appslab.users;

import android.content.Context;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.agoda.kakao.Kakao;

import org.junit.Test;
import org.junit.runner.RunWith;

import ke.co.appslab.users.views.UsersFragment;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        FragmentScenario.launchInContainer(UsersFragment.class);

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("ke.co.appslab.users", appContext.getPackageName());
    }
}