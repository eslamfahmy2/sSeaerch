package com.fahmy.domain.mapper

import com.fahmy.data.dto.news.ArticleDto
import com.fahmy.data.dto.news.ResponseDto
import com.fahmy.domain.model.City

class CityDtoMapper : DomainMapper<ResponseDto, City> {

    override fun mapToDomainModel(model: ResponseDto): City {
        return City("hello")
    }

    private fun mapToDomainNewsModel(model: ArticleDto): City {
        return City(
            name = model.title,
            image = model.urlToImage,
            description = model.description
        )
    }

    fun toDomainList(initial: List<ArticleDto>): List<City> {
        return initial.map { mapToDomainNewsModel(it) }
    }

    override fun mapFromDomainModel(domainModel: City): ResponseDto {
        TODO("Not yet implemented")
    }

}