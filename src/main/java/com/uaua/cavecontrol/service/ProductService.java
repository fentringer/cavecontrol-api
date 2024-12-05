package com.uaua.cavecontrol.service;

import com.uaua.cavecontrol.exception.EntityInUseException;
import com.uaua.cavecontrol.exception.EntityNotFoundException;
import com.uaua.cavecontrol.model.dto.ProductDTO;
import com.uaua.cavecontrol.model.entity.Product;
import com.uaua.cavecontrol.model.mapper.ProductMapper;
import com.uaua.cavecontrol.repository.ProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> listAll() {
        List<Product> products = repository.findAll();
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found with ID %d", id)));

        return productMapper.toDTO(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product = repository.save(product);
        return productMapper.toDTO(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found with ID %d", id)));

        productMapper.updateFromDTO(productDTO, product);
        product = repository.save(product);

        return productMapper.toDTO(product);
    }

    public void remove(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found with ID %d", id)));

        try {
            repository.delete(product);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("Product is in use and cannot be removed.");
        }
    }
}
