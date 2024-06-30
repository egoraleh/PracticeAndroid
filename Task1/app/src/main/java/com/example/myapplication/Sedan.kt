package com.example.myapplication

class Sedan(name: String, model: String, year: Int, maxspeed: Int, cost: Long, powerful: Int = 150,
            wheelDrive: String = "fwd", val doors: Int = 4, val roof: String = "yes"): Car(name, model, year, maxspeed, cost, powerful, wheelDrive) {
}