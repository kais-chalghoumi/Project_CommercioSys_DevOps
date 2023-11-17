package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

class ProductServiceImplMockitoTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct() {
        Stock stock = new Stock();
        Product product = new Product();
        Long idStock = 1L;
        Mockito.when(stockRepository.findById(idStock)).thenReturn(Optional.of(stock));
        Assertions.assertEquals(stock, product.getStock());
        Mockito.verify(productRepository, times(1)).save(product);
    }

    @Test
    void retrieveProduct() {
        Long productId = 1L;
        Product expectedProduct = new Product();
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));
        Product result = productService.retrieveProduct(productId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedProduct, result);
    }

    @Test
    void retreiveAllProduct() {
        List<Product> expectedProducts = Collections.singletonList(new Product());
        Mockito.when(productRepository.findAll()).thenReturn(expectedProducts);
        List<Product> result = productService.retreiveAllProduct();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedProducts, result);
    }

    @Test
    void retrieveProductByCategory() {
        List<Product> expectedProducts = Collections.singletonList(new Product());
        ProductCategory category = ProductCategory.ELECTRONICS;
        Mockito.when(productRepository.findByCategory(category)).thenReturn(expectedProducts);
        List<Product> result = productService.retrieveProductByCategory(category);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedProducts, result);
    }

    @Test
    void deleteProduct() {
        Long productId = 1L;
        productService.deleteProduct(productId);
        Mockito.verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void retreiveProductStock() {
        List<Product> expectedProducts = Collections.singletonList(new Product());
        Long stockId = 1L;
        Mockito.when(productRepository.findByStockIdStock(stockId)).thenReturn(expectedProducts);
        List<Product> result = productService.retreiveProductStock(stockId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedProducts, result);
    }

}