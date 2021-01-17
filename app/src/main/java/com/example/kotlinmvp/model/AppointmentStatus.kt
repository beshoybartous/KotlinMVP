package com.example.kotlinmvp.model

import androidx.annotation.StringDef

object AppointmentStatus {

    @Retention(AnnotationRetention.SOURCE)
    @StringDef(
        AppointmentStatus.CANCELLED,
        AppointmentStatus.PENDING,
        AppointmentStatus.FINISHED,
        AppointmentStatus.NOT_COMPLETED
    )
    annotation class Status

    const val CANCELLED = "cancelled"
    const val PENDING = "pending"
    const val FINISHED = "finished"
    const val NOT_COMPLETED = "not completed"
}