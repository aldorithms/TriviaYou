package com.bnyro.trivia.util

import android.text.Html
import android.text.Spanned
import java.util.*

fun Any?.formatStats(): String {
    return this!!.toString()
        .replace("=", ": ")
        .replace("_", " ")
        .replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault())
            else it.toString()
        }
}

fun Any?.toHTML(): Spanned {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this.toString())
    }
}
