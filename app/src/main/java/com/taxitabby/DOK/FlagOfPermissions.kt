package com.taxitabby.DOK

import java.util.EnumSet

enum class FlagOfPermissions(private val bitNumber : Int) {
    BLUETOOTH(1),
    BLUETOOTH_ADMIN(2);


    public fun toValue() : Int = bitNumber
    infix fun and(other: FlagOfPermissions) : FlagOfPermissionsGroup
        = FlagOfPermissionsGroup.of(this, other)

}

typealias FlagOfPermissionsGroup = EnumSet<FlagOfPermissions>