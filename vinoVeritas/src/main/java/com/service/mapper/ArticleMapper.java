package com.service.mapper;

import com.domain.*;
import com.service.dto.ArticleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Article and its DTO ArticleDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

    @Mapping(source = "companyId.id", target = "companyIdId")
    ArticleDTO toDto(Article article);

    @Mapping(source = "companyIdId", target = "companyId")
    Article toEntity(ArticleDTO articleDTO);

    default Article fromId(Long id) {
        if (id == null) {
            return null;
        }
        Article article = new Article();
        article.setId(id);
        return article;
    }
}
