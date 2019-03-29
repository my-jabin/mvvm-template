package com.jiujiu.mvvmTemplate.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
data class Product(

        @PrimaryKey(autoGenerate = true)
        var id: Long?,

        var name: String,

        var brand: String?,

        var price: Double? = 0.toDouble()

) {

    @ColumnInfo(name = "created_at")
    var createdAt: Calendar? = Calendar.getInstance(Locale.getDefault())

    @ColumnInfo(name = "updated_at")
    var updateAt: Calendar? = Calendar.getInstance(Locale.getDefault())

    @Ignore
    var createdAtDataString = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(createdAt?.time)
}


