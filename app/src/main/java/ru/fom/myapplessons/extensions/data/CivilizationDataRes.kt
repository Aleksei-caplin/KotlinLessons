package ru.fom.myapplessons.extensions.data

import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.Cost
import ru.fom.myapplessons.data.local.entities.Warrior
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes

fun CivilizationDataRes.toCivilization(): Civilization = Civilization(
    "2",
    "Aztecs",
    "The Conquerors",
    "Infantry and Monk",
    "Relics generate +33% gold",
    Warrior(
        "79",
        "Jaguar Warrior",
        "Aztec unique unit. Attack bonus vs. other infantry",
        "The Conquerors",
        "Castle",
        Cost(60, 30, null, null)
    ),
)