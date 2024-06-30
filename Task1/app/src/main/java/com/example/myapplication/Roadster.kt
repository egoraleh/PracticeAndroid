package com.example.myapplication

class Roadster(name: String, model: String, year: Int, maxspeed: Int, cost: Long, powerful: Int = 300,
               wheelDrive: String = "rwd", val doors: Int = 2, val roof: String = "no"): Car(name, model, year, maxspeed, cost, powerful, wheelDrive) {
}