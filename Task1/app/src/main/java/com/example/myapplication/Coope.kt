package com.example.myapplication

class Coope(name: String, model: String, year: Int, maxspeed: Int, cost: Long, powerful: Int = 200,
            wheelDrive: String = "rwd", val doors: Int = 2, val roof: String = "yes"): Car(name, model, year, maxspeed, cost, powerful, wheelDrive) {
}