package com.example.myapplication

class Cabriolet(name: String, model: String, year: Int, maxspeed: Int, cost: Long, powerful: Int = 250,
                wheelDrive: String = "awd", val doors: Int = 4, val roof: String = "no"): Car(name, model, year, maxspeed, cost, powerful, wheelDrive) {
}