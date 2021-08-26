package com.taxitabby.DOK

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class ActivityEntry : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_entry) //먼저 실행시켜서 Inflate 되어야지 findViewById 로 구성된 리소스를 선택하나봄

        val context : Context = applicationContext

        var rectGroup : LinearLayout = findViewById<LinearLayout>(R.id.permission_check_rect_group)
        val logoRound : ProgressBar = findViewById<ProgressBar>(R.id.entry_progress)
        val logo : ImageView = findViewById<ImageView>(R.id.entry_logo)
        val bluetoothAdminRect : View = findViewById<View>(R.id.entry_permission_check_rect_bluetooth)
        val bluetoothAdminRectAdmin : View = findViewById<View>(R.id.entry_permission_check_rect_bluetooth_admin)

        val animationDacapo1 : Animation = AnimationUtils.loadAnimation(this, R.anim.logo_scale_dacapo)
        val animationDacapo2 : Animation = AnimationUtils.loadAnimation(this, R.anim.logo_scale_dacapo)

        val animationHideOutDacapo1 : Animation = AnimationUtils.loadAnimation(this, R.anim.permission_rect_hideout_dacapo)
        val animationHideOutDacapo2 : Animation = AnimationUtils.loadAnimation(this, R.anim.permission_rect_hideout_dacapo)
        animationHideOutDacapo1.setAnimationListener(object : Animation.AnimationListener {
            // All the other override functions
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                rectGroup.removeView(bluetoothAdminRect)
            }
        })
        animationHideOutDacapo2.setAnimationListener(object : Animation.AnimationListener {
            // All the other override functions
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                rectGroup.removeView(bluetoothAdminRectAdmin)
            }
        })

        logo.startAnimation(animationDacapo1)
        logoRound.startAnimation(animationDacapo2)

        val permissionFlag : FlagOfPermissionsGroup = EnumSet.noneOf(FlagOfPermissions::class.java)
        BasketOfEntryFunction.CheckPermissionsWhenEntryCheck(context, permissionFlag)

        if (permissionFlag.contains(FlagOfPermissions.BLUETOOTH)) {
            bluetoothAdminRect.clearAnimation()
            bluetoothAdminRect.setAnimation(animationHideOutDacapo1)
            bluetoothAdminRect.animation.start()
        } else {
            bluetoothAdminRect.setBackgroundColor(context.getColor(R.color.purple_700))
        }

        if (permissionFlag.contains(FlagOfPermissions.BLUETOOTH_ADMIN)) {
            bluetoothAdminRectAdmin.clearAnimation()
            bluetoothAdminRectAdmin.setAnimation(animationHideOutDacapo2)
            bluetoothAdminRectAdmin.animation.start()
        } else {
            bluetoothAdminRectAdmin.setBackgroundColor(context.getColor(R.color.purple_700))
        }


    }
}