import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kader.kekodchallenge1.BaseFragment
import com.kader.kekodchallenge1.R
import com.kader.kekodchallenge1.databinding.FragmentSplashBinding
import com.kader.kekodchallenge1.ui.fragment.EgoFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun initView() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EgoFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater,container,false)
}