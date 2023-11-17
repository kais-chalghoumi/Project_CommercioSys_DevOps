package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void addProduct() {
        // Créer des objets simulés pour le test
        Stock stock = new Stock();
        Product product = new Product();
        Long idStock = 1L;

        // Configurer le comportement simulé pour le stockRepository
        when(stockRepository.findById(idStock)).thenReturn(Optional.of(stock));

        // Appeler la méthode à tester
        Product result = productService.addProduct(product, idStock);

        // Vérifier les assertions
       // assertNotNull(result);
        assertEquals(stock, product.getStock());
        verify(productRepository, times(1)).save(product);

    }

    @Test
    void retrieveProduct() {
        // Créer un objet simulé pour le test
        Long productId = 1L;
        Product expectedProduct = new Product();

        // Configurer le comportement simulé pour le productRepository
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        // Appeler la méthode à tester
        Product result = productService.retrieveProduct(productId);

        // Vérifier les assertions
        assertNotNull(result);
        assertEquals(expectedProduct, result);

    }

    @Test
    void retreiveAllProduct() {
        // Créer une liste simulée pour le test
        List<Product> expectedProducts = Collections.singletonList(new Product());

        // Configurer le comportement simulé pour le productRepository
        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Appeler la méthode à tester
        List<Product> result = productService.retreiveAllProduct();

        // Vérifier les assertions
        assertNotNull(result);
        assertEquals(expectedProducts, result);

    }

    @Test
    void retrieveProductByCategory() {
        // Créer une liste simulée pour le test
        List<Product> expectedProducts = Collections.singletonList(new Product());
        ProductCategory category = ProductCategory.ELECTRONICS;

        // Configurer le comportement simulé pour le productRepository
        when(productRepository.findByCategory(category)).thenReturn(expectedProducts);

        // Appeler la méthode à tester
        List<Product> result = productService.retrieveProductByCategory(category);

        // Vérifier les assertions
        assertNotNull(result);
        assertEquals(expectedProducts, result);

    }

    @Test
    void deleteProduct() {
        // Créer un ID simulé pour le test
        Long productId = 1L;

        // Appeler la méthode à tester
        productService.deleteProduct(productId);

        // Vérifier que la méthode deleteById du productRepository a été appelée
        verify(productRepository, times(1)).deleteById(productId);

    }

    @Test
    void retreiveProductStock() {
        List<Product> expectedProducts = Collections.singletonList(new Product());
        Long stockId = 1L;

        // Configurer le comportement simulé pour le productRepository
        when(productRepository.findByStockIdStock(stockId)).thenReturn(expectedProducts);

        // Appeler la méthode à tester
        List<Product> result = productService.retreiveProductStock(stockId);

        // Vérifier les assertions
        assertNotNull(result);
        assertEquals(expectedProducts, result);

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }
}