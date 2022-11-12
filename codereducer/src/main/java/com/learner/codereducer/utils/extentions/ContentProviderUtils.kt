package com.learner.codereducer.utils.extentions

import android.database.Cursor
import android.provider.MediaStore
import com.learner.codereducer.utils.AndroidUtils

object ContentProviderUtils {
}

/**
 * @param column column id of media media store.
 * ex: [DATA][MediaStore.Video.Media.DATA], [BUCKET_ID][MediaStore.Images.Media.BUCKET_ID] etc
 * @return info/name of selected column as string
 */
fun Cursor.getStringInfo(column: String): String = getString(getColumnIndexOrThrow(column))
fun Cursor.getLongInfo(column: String): Long = getLong(getColumnIndexOrThrow(column))

/** Must add [SIZE][MediaStore.MediaColumns.SIZE] on projection.*/
val Cursor.fileSize: Long
    get() {
        return getLong(getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE))
    }

/** If android version less Q must add [DATA][MediaStore.Video.Media.DATA]
 *  else [RELATIVE_PATH][MediaStore.Video.Media.RELATIVE_PATH] on projection.*/
val Cursor.relativePath: String
    get() {
        return if (AndroidUtils.isAndroidVersionQ()) getStringInfo(MediaStore.MediaColumns.RELATIVE_PATH)
        else {
            getStringInfo(MediaStore.Video.Media.DATA).let { data ->
                try {
                    data.dropLast(data.length - data.lastIndexOf('/'))
                } catch (e: Exception) {
                    "Storage"
                }
            }
        }
    }