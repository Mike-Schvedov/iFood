package com.mikeschvedov.ifood.utils

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat

fun Context.displayToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
