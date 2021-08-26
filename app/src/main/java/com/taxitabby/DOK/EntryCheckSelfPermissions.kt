package com.taxitabby.DOK

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat.checkSelfPermission

class EntryCheckSelfPermissions {
    fun check(cn : Context, pm : String) : Boolean {
        return when (checkSelfPermission(cn, pm)) {
            PackageManager.PERMISSION_GRANTED -> true
            else -> false
        }
    }
}