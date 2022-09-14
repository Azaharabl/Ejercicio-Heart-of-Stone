package pojo

import java.time.LocalDateTime
import java.util.*

class Item
     (
        id: String = UUID.randomUUID().toString(),
        fechaCreacion : LocalDateTime = LocalDateTime.now(),
        nivel: Int = Random().nextInt(3),
        tipo : Tipo = Tipo.values().get(Random().nextInt(4)),

        )