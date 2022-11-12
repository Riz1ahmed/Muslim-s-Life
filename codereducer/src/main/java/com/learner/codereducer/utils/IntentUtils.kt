package com.learner.codereducer.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.learner.codereducer.utils.extentions.customToast


object IntentUtils {
    fun openEmail(
        context: Context, email: String, subject: String, messages: String
    ) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, messages)
            context.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            context.customToast(
                "There are no email client installed on your device."
            )
        }
    }

    fun getVideoPickerIntent(): Intent {
        return Intent(Intent.ACTION_OPEN_DOCUMENT).also {
            it.addCategory(Intent.CATEGORY_OPENABLE)
            it.type = "video/*"
            it.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            it.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            it.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        }
    }
    fun getImagePickerIntent(): Intent {
        return Intent(Intent.ACTION_OPEN_DOCUMENT).also {
            it.addCategory(Intent.CATEGORY_OPENABLE)
            it.type = "image/*"
            it.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            it.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            it.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        }
    }

}