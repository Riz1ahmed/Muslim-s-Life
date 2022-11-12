package com.learner.codereducer.utils

import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.learner.codereducer.R

object DialogAndBsUtils {
    /**
     * * Please call this method from onCreate
     * * Please make sure [setBottomSheetBgTransparent] called from onStart
     * */
    fun setBottomSheetMyStyle(df: DialogFragment) {
        df.setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    /**
     * This method specially for corner round
     * * Please call this method from onStart.
     * * make sure [setBottomSheetMyStyle] method called from onCreate
     * */
    fun setBottomSheetBgTransparent(df: DialogFragment, clearDim: Boolean = false) {
        //Outside dim color clear
        if (clearDim)
            df.dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        df.dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}