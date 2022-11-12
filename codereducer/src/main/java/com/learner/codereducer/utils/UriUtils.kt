package com.learner.codereducer.utils

import android.content.Context
import android.net.Uri
import androidx.annotation.RawRes

object UriUtils {
    fun uriFromRaw(context: Context, @RawRes resId: Int): Uri? =
        Uri.parse("android.resource://${context.packageName}/$resId")

    fun uriFromPath(path: String): Uri? = Uri.parse(path)
}