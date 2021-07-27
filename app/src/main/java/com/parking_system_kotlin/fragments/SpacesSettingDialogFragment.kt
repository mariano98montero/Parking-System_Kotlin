package com.parking_system_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.parking_system_kotlin.listeners.ListenerSetParkingDialogFragment
import com.parking_system_kotlin.mvp.contracts.ParkingSpacesSettingContract
import com.parking_system_kotlin.mvp.presenter.ParkingSpacesSettingPresenter
import com.parking_system_kotlin.mvp.view.ParkingSpacesSettingView
import com.parking_system_kotlin.utils.Constants
import com.parkingsystemkotlin.databinding.DialogFragmentParkingSpacesSettingBinding

class SpacesSettingDialogFragment : DialogFragment() {
    private lateinit var presenter: ParkingSpacesSettingContract.ParkingSpacesSettingDialogFragmentPresenter
    private lateinit var binding: DialogFragmentParkingSpacesSettingBinding
    private lateinit var listenerSetParkingDialogFragment: ListenerSetParkingDialogFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogFragmentParkingSpacesSettingBinding.inflate(layoutInflater)
        this.presenter = ParkingSpacesSettingPresenter(ParkingSpacesSettingView(this))
        listenerSetParkingDialogFragment =
            arguments?.getSerializable(Constants.LISTENER_SPACES_SETTING_KEY) as ListenerSetParkingDialogFragment
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.buttonDialogFragmentSpacesSettingConfirmation.setOnClickListener {
            presenter.onButtonDialogFragmentSpacesSettingConfirmationPressed(
                binding.numberInputDialogFragmentParkingSpacesSetting.text.toString(),
                listenerSetParkingDialogFragment
            )
        }
    }

    companion object {
        fun newInstance(ListenerSetParkingDialogFragment: ListenerSetParkingDialogFragment): SpacesSettingDialogFragment {
            var spacesSettingDialogFragment: SpacesSettingDialogFragment = SpacesSettingDialogFragment()
            var bundle: Bundle = Bundle()
            bundle.putSerializable(Constants.LISTENER_SPACES_SETTING_KEY, ListenerSetParkingDialogFragment)
            spacesSettingDialogFragment.arguments = bundle
            return spacesSettingDialogFragment
        }
    }
}
