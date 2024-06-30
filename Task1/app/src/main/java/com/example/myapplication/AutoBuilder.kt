package com.example.myapplication

class AutoBuilder(var name: String = "", var model: String = "", var year: Int = 0, var maxspeed: Int = 0, var cost: Long = 0,
                  var doors: Int = 0, var powerful: Int = 0, var wheelDrive: String, var roof: String) {
    fun build(): Car {
        if (doors == 2 && roof == "no") {
            return this.buildRoadster()
        } else if (doors == 4 && roof == "no") {
            return this.buildCabriolet()
        } else if (doors == 2 && roof == "yes") {
            return this.buildCoope()
        } else {
            return this.buildSedan()
        }
    }
    fun buildCoope(): Coope {
        return Coope(name, model, year, maxspeed, cost, powerful, wheelDrive, doors, roof)
    }
    fun buildSedan(): Sedan {
        return Sedan(name, model, year, maxspeed, cost, powerful, wheelDrive, doors, roof)
    }
    fun buildRoadster(): Roadster {
        return Roadster(name, model, year, maxspeed, cost, powerful, wheelDrive, doors, roof)
    }
    fun buildCabriolet(): Cabriolet {
        return Cabriolet(name, model, year, maxspeed, cost, powerful, wheelDrive, doors, roof)
    }
}