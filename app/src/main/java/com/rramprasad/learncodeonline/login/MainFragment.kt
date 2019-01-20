package com.rramprasad.learncodeonline.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rramprasad.learncodeonline.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        val LOG_TAG : String = "MainFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let{
            main_viewpager.adapter = MainViewPagerAdapter(childFragmentManager)
            main_tab_layout.setupWithViewPager(main_viewpager)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private inner class MainViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {

        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> {
                    LoginFragment()
                    //ResetPinFragment()
                }

                1 -> {
                    SignUpFragment()
                }

                else -> {
                    LoginFragment()
                }
            }
        }

        override fun getCount(): Int {
            return 2;
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 -> {
                    getString(R.string.login)
                }

                1 -> {
                    getString(R.string.sign_up)
                }

                else -> {
                    getString(R.string.login)
                }
            }
        }
    }
}


