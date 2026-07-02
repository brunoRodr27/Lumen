package com.example.lumen.core

import java.text.SimpleDateFormat
import java.util.*

fun Long.toReadableDate(): String = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale("pt", "BR")).format(Date(this))