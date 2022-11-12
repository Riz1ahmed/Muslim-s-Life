package com.learner.codereducer.local_tool

import android.content.Context

object AndroidConst {
    object UriPrefixes {
        /**for use it add your file name at end of this.
         * eg: [resDir]/<Any resDir>/<file with R.>*/
        //fun resDir(context: Context) = "android.resource://${context.packageName}"

        /**for use it add your file name at end of this.
         * eg: [resPath]/R.raw.my_video*/
        //fun rawDir(context: Context) = "android.resource://${context.packageName}/raw"

        /**for use it add asset file path with ext
         * eg: [assetDir]/video/my_video.mp4*/
        //const val assetDir = "file:///android_asset"

        /**eg: [resPrefix]/R.raw.video*/
        fun resPrefix(context: Context) = "android.resource://${context.packageName}"
    }
}