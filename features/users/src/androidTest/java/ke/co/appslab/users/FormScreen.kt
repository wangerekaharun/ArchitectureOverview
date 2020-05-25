package ke.co.appslab.users

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView

class FormScreen : Screen<FormScreen>() {
    val phone = KTextView { withId(R.id.tvUsers) }
}