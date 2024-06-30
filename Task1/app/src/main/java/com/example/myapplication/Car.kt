package com.example.myapplication

open class Car(
    var name: String, var model: String = "", var year: Int = 0, var maxspeed: Int = 0,
    var cost: Long = 0, var powerful: Int = 0, var wheelDrive: String = "") {
    fun info() = "Автомобиль $name $model $year года выпуска, стоимость составляет $cost рублей, максимальная скорость - $maxspeed km/h."
}