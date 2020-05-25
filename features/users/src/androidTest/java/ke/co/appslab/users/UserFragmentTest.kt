package ke.co.appslab.users

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.screen.Screen.Companion.idle
import com.agoda.kakao.screen.Screen.Companion.onScreen
import ke.co.appslab.users.views.UsersFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UserFragmentTest {

    @Test
    fun isTestViewShow(){
        launchFragmentInContainer<UsersFragment>()
        onScreen<FormScreen> {
            phone{
                hasText("This is users")
            }
        }

    }
}