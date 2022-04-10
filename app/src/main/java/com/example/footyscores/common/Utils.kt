package com.example.footyscores.common

import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateStringFormat(date: Long): String {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormatter.format(Date(date))
}

fun getMonthOfYear(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())!!
}

fun getDayOfMonth(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.get(Calendar.DAY_OF_MONTH).toString()
}

fun getDayOfWeek(timestamp: Long): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = timestamp
    return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())!!
}

fun getDateRanges(): List<Long> {
    val dateRanges = ArrayList<Long>()
    for (i in -2..2) {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, i)
        dateRanges.add(cal.timeInMillis)
    }

    return dateRanges
}

fun getTimeFromTimeStamp(timestamp: Long): String {
    val timeFormatter = SimpleDateFormat("hh:mm", Locale.getDefault())
    return timeFormatter.format(Date(timestamp))
}

fun getTimeFromDateString(dateString: String): String {
    val formattedDateString =
        dateString.replace('T', ' ').substring(0, dateString.indexOf('+') - 3) + "+0000"
    val date =
        SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault()).parse(formattedDateString)
    return SimpleDateFormat("HH:mm", Locale.getDefault()).format(date!!)
}

fun getFormattedDateFromDateString(dateString: String, excludeYear: Boolean = true): String {
    val datePortion = dateString.split("T")[0]
    val date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(datePortion)
    return if (excludeYear) SimpleDateFormat(
        "dd MMM",
        Locale.getDefault()
    ).format(date!!) else SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(date!!)
}