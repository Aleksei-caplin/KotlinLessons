package ru.fom.myapplessons.extensions.data

import ru.fom.myapplessons.data.local.entities.Civilization
import ru.fom.myapplessons.data.local.entities.Cost
import ru.fom.myapplessons.data.local.entities.Warrior
import ru.fom.myapplessons.data.remote.res.CivilizationDataRes

fun CivilizationDataRes.toCivilization(): Civilization = Civilization(
    id = id,
    name = name,
    expansion = expansion,
    army_type = army_type,
    team_bonus = team_bonus,

)