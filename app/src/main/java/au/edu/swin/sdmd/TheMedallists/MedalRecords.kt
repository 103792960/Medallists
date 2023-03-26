package au.edu.swin.sdmd.TheMedallists

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


@Parcelize
class MedalRecords (
    val country: String,
    val ioccode: String,
    val times_competed: Int,
    val gold: Int,
    val silver :Int,
    val bronze: Int): Parcelable
    , Serializable {}