package ru.fom.myapplessons.ui.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_splash.*
import ru.fom.myapplessons.R
import ru.fom.myapplessons.ui.base.BaseFragment
import ru.fom.myapplessons.utils.APP_ACTIVITY
import ru.fom.myapplessons.viewmodel.EmpireViewModel

class SplashFragment : Fragment() {

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private var shortAnimationDuration: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?)
    : View {
        //APP_ACTIVITY.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)


        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_civilizationsListFragment2)
        }, 3000)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topAnimation = AnimationUtils.loadAnimation(APP_ACTIVITY, R.anim.splash_top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(APP_ACTIVITY, R.anim.splash_bottom_animation)

        iv_spalsh_pic.startAnimation(topAnimation)
        tv_splash_text.startAnimation(bottomAnimation)

    }



}