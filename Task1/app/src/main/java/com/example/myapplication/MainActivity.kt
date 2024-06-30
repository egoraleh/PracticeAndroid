package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    fun race1x1(car1: Car, car2: Car): Car {
        if (car1.powerful > car2.powerful) {
            if (car1.wheelDrive == "awd") {
                return car1
            } else if (car1.wheelDrive == "fwd") {
                if (car1.powerful < 300) {
                    if (car1.powerful - car2.powerful <= 30) {
                        if (car2.wheelDrive == "awd") {
                            return car2
                        }
                        return car1
                    }
                    return car1
                } else {
                    if (car2.wheelDrive != "fwd") {
                        if (car1.powerful - car2.powerful <= 120) {
                            return car2
                        }
                        return car2
                    }
                    return car1
                }
            } else {
                if (car1.powerful < 300) {
                    if (car1.powerful - car2.powerful <= 30) {
                        if (car2.wheelDrive == "awd" || car2.wheelDrive == "fwd") {
                            return car2
                        }
                        return car1
                    }
                    return car1
                }
                return car1
            }
        } else {
            if (car2.wheelDrive == "awd") {
                return car2
            } else if (car2.wheelDrive == "fwd") {
                if (car2.powerful < 300) {
                    if (car2.powerful - car1.powerful <= 30) {
                        if (car1.wheelDrive == "awd") {
                            return car1
                        }
                        return car2
                    }
                    return car2
                } else {
                    if (car1.wheelDrive != "fwd") {
                        if (car2.powerful - car1.powerful <= 120) {
                            return car1
                        }
                        return car1
                    }
                    return car2
                }
            } else {
                if (car2.powerful < 300) {
                    if (car2.powerful - car1.powerful <= 30) {
                        if (car1.wheelDrive == "awd" || car1.wheelDrive == "fwd") {
                            return car1
                        }
                        return car2
                    }
                    return car2
                }
                return car2
            }
        }
    }

    fun oneRound(cars: ArrayList<Car>): ArrayList<Car> {
        val output = findViewById<TextView>(R.id.textView)
        val cars1 = arrayListOf<Car>()
        println("\nНовый круг начался:")
        output?.append("\nНовый круг начался:\n")
        while (cars.size > 1) {
            val n1: Int = (0..<cars.size).random()
            val n2: Int = (0..<cars.size).random()
            if (n1 != n2) {
                println("Заезд: машина ${cars[n1].name} ${cars[n1].model} и машина ${cars[n2].name} ${cars[n2].model}.\n")
                output?.append("Заезд: машина ${cars[n1].name} ${cars[n1].model} и машина ${cars[n2].name} ${cars[n2].model}.\n")
                if (race1x1(cars[n1], cars[n2]) == cars[n1]) {
                    println("Машина ${cars[n1].name} ${cars[n1].model} победила в заезде.\n")
                    output?.append("Машина ${cars[n1].name} ${cars[n1].model} победила в заезде.\n")
                    cars1.add(cars[n1])
                    cars.removeAt(n2)
                    if (n1 > n2) {
                        cars.removeAt(n1 - 1)
                    } else {
                        cars.removeAt(n1)
                    }
                } else {
                    println("Машина ${cars[n2].name} ${cars[n2].model} победила в звезде.\n")
                    output?.append("Машина ${cars[n2].name} ${cars[n2].model} победила в заезде.\n")
                    cars1.add(cars[n2])
                    cars.removeAt(n1)
                    if (n2 > n1) {
                        cars.removeAt(n2 - 1)
                    } else {
                        cars.removeAt(n2)
                    }
                }
            }
        }
        if (cars.size == 1) {
            println("Для ${cars[0].name} ${cars[0].model} не нашлось пары.\n")
            output?.append("Для ${cars[0].name} ${cars[0].model} не нашлось пары.\n")
            cars1.add(cars[0])
        }
        println("Круг окончен.\n")
        output?.append("Круг окончен.\n")
        return cars1
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val marks =
            arrayOf("Chevrolet", "Toyota", "Volkswagen", "BMW", "Audi", "Lada", "Nissan", "Ford")
        val models = arrayOf(
            "Vesta",
            "Corolla",
            "Jetta",
            "Passat",
            "Skyline",
            "Camry",
            "Focus",
            "La Votre Noir"
        )
        var wheelDrives = arrayOf("awd", "fwd", "rwd")
        var roof = arrayOf("yes", "no")
        val number = findViewById<EditText>(R.id.number_field)
        val button = findViewById<Button>(R.id.button)
        val output = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            val count: Int = number.text.toString().toInt()
            output.text = ""
            number.text = null
            if (count > 0) {
                var carsArray = arrayListOf<Car>()
                val f = (-1..1).random()
                val door = if (f >= 0) 2 else 4
                for (index in 0 until count) {
                    val car = AutoBuilder(
                        marks[(0..7).random()],
                        models[(0..7).random()],
                        (1900 + (20..124).random()),
                        (140..500).random(),
                        (1000000..10000000000).random(),
                        door, (80..700).random(),
                        wheelDrives[(0..2).random()],
                        roof[(0..1).random()]
                    ).build()
                    carsArray.add(car)
                }
                while (carsArray.size > 1) {
                    carsArray = oneRound(carsArray)
                }
                println("\n${carsArray[0].name} ${carsArray[0].model} выиграла в гонке!\n")
                output?.append("\n${carsArray[0].name} ${carsArray[0].model} выиграла в гонке!\n")
            } else {
                println("Машин нет, гонка не состоится!")
                output?.append("Машин нет, гонка не состоится!")
            }
        }
    }
}