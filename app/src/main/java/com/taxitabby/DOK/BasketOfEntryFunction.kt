package com.taxitabby.DOK

import android.content.Context
import android.util.Log

class BasketOfEntryFunction() {

    companion object Unique {
        public var PermissionCheckFlagBit : Int = 0
        public fun CheckPermissionsWhenEntryCheck(context: Context, thatIsaidTheGroup:FlagOfPermissionsGroup){
            val permission : EntryCheckSelfPermissions = EntryCheckSelfPermissions()

            if (permission.check(context, android.Manifest.permission.BLUETOOTH)) {
                thatIsaidTheGroup.add(FlagOfPermissions.BLUETOOTH)
                Log.v(R.string.tag_permission.toString(), R.string.permission_err_bluetooth_granted.toString())
            } else {
                Log.v(R.string.tag_permission.toString(), R.string.permission_err_bluetooth_denied.toString())
            }

            if (permission.check(context, android.Manifest.permission.BLUETOOTH_ADMIN)) {
                thatIsaidTheGroup.add(FlagOfPermissions.BLUETOOTH_ADMIN)
                Log.v(R.string.tag_permission.toString(), R.string.permission_err_bluetooth_admin_granted.toString())
            } else {
                Log.v(R.string.tag_permission.toString(), R.string.permission_err_bluetooth_admin_denied.toString())
            }

        }
    }



}