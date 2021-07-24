package ru.fom.myapplessons.ui.screens.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fom.myapplessons.R
import ru.fom.myapplessons.databinding.FragmentSplashBinding
import ru.fom.myapplessons.ui.RootActivity
import ru.fom.myapplessons.ui.screens.civilisations.CivilizationFragment


class SplashFragment : Fragment() {

    private val lottieView: LottieAnimationView
        get() = requireView().findViewById(R.id.lottieViw)

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lottieView.setAnimation(R.raw.winter_train)
        lottieView.playAnimation()
        lottieView.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            //Log.d("M_fff", progress.toString())
            if(progress == 98) {
                //nv.navigate(action)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CivilizationFragment.newInstance())
                    .commit()
            }
        }
    }

}