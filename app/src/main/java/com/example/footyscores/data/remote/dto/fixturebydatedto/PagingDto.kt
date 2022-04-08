package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.Paging
import com.google.gson.annotations.SerializedName

data class PagingDto(
    @SerializedName("current")
    val current: Int,
    @SerializedName("total")
    val total: Int
) {
    internal fun toDomainModelPaging(): Paging {
        return Paging(
            current, total
        )
    }
}