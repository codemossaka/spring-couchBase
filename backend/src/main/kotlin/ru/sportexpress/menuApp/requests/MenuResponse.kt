package ru.sportexpress.menuApp.requests

class MenuResponse(var status : Status = Status.ERROR, var result: Any? = null, var message: String? ="") {
}