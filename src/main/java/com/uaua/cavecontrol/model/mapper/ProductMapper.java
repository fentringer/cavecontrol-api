package com.uaua.cavecontrol.model.mapper;

import com.uaua.cavecontrol.model.dto.ProductDTO;
import com.uaua.cavecontrol.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    void updateFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}
