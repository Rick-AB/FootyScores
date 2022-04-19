package com.example.footyscores.data.remote.dto.fixturebydatedto


import com.example.footyscores.domain.model.fixturebydate.ResponseBody
import com.google.gson.annotations.SerializedName

data class ResponseBodyDto(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: PagingDto,
    @SerializedName("parameters")
    val parameters: ParametersDto,
    @SerializedName("response")
    val response: List<ResponseDto>,
    @SerializedName("results")
    val results: Int
) {
    internal fun toDomainModelResponseData(): ResponseBody {
        return ResponseBody(
            errors = errors,
            get = get,
            paging = paging.toDomainModelPaging(),
            parameters = parameters.toDomainModelParameters(),
            response = response.map { it.toDomainModelResponse() },
            results = results
        )
    }
}