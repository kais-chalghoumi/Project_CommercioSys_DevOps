package tn.esprit.devops_project.Test;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestProduct {


    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddProduct() {
        // Créez un produit factice
        Product productToAdd = new Product();

        // Créez un stock factice
        Stock stock = new Stock();

        // Définissez le comportement simulé pour findById dans le mock du stockRepository
        when(stockRepository.findById(anyLong())).thenReturn(Optional.of(stock));

        // Appelez la méthode addProduct
        Product addedProduct = productService.addProduct(productToAdd, 1L); // Utilisez l'ID du stock factice

        // Vérifiez que le produit ajouté est le même que celui que vous avez créé
        //assertEquals(productToAdd, addedProduct);
    }


    @Test
    public void testRetrieveProduct() {
        // Créez un objet Product simulé pour votre test
        Product mockProduct = new Product();
        mockProduct.setIdProduct(1L); // Remplacez 1L par l'ID du produit que vous souhaitez récupérer

        // Configurer le mock de productRepository pour renvoyer le produit simulé lorsque findById est appelé
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(mockProduct));

        // Appelez la méthode à tester (retrieveProduct) avec l'ID du produit
        Long productId = 1L; // Remplacez par l'ID du produit que vous souhaitez récupérer
        Product retrievedProduct = productService.retrieveProduct(productId);

        // Effectuez des assertions pour vérifier que le produit récupéré correspond à votre attente
        assertNotNull(retrievedProduct);
        assertEquals(mockProduct.getIdProduct(), retrievedProduct.getIdProduct());
        // Vous pouvez ajouter d'autres assertions en fonction de vos besoins
    }

    @Test
    public void testRetrieveAllProduct() {
        // Créez une liste simulée de produits pour votre test
        List<Product> mockProducts = new ArrayList<>();
        Product product1 = new Product();
        product1.setIdProduct(1L);
        mockProducts.add(product1);
        // Ajoutez d'autres produits simulés au besoin

        // Configurer le mock de productRepository pour renvoyer la liste simulée lorsque findAll est appelé
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Appelez la méthode à tester (retreiveAllProduct)
        List<Product> retrievedProducts = productService.retreiveAllProduct();

        // Effectuez des assertions pour vérifier que la liste renvoyée correspond à votre attente
        assertNotNull(retrievedProducts);
        assertEquals(mockProducts.size(), retrievedProducts.size());
        // Vous pouvez ajouter d'autres assertions pour vérifier les détails des produits récupérés
    }

    @Test
    public void testRetrieveProductByCategory() {
        // Créez une catégorie simulée pour votre test
        ProductCategory mockCategory = ProductCategory.BOOKS; // Remplacez YOUR_CATEGORY par la catégorie souhaitée

        // Créez une liste de produits simulés avec la catégorie simulée
        List<Product> mockProducts = new ArrayList<>();
        Product product1 = new Product();
        product1.setIdProduct(1L);
        product1.setCategory(mockCategory);
        mockProducts.add(product1);
        // Ajoutez d'autres produits simulés avec la même catégorie au besoin

        // Configurer le mock de productRepository pour renvoyer la liste simulée lorsque findByCategory est appelé
        when(productRepository.findByCategory(eq(mockCategory))).thenReturn(mockProducts);

        // Appelez la méthode à tester (retrieveProductByCategory) avec la catégorie simulée
        List<Product> retrievedProducts = productService.retrieveProductByCategory(mockCategory);

        // Effectuez des assertions pour vérifier que la liste renvoyée correspond à votre attente
        assertNotNull(retrievedProducts);
        assertEquals(mockProducts.size(), retrievedProducts.size());

        // Vérifiez que tous les produits de la liste ont la catégorie attendue
        for (Product product : retrievedProducts) {
            assertEquals(mockCategory, product.getCategory());
        }
        // Vous pouvez ajouter d'autres assertions en fonction de vos besoins
    }


    @Test
    public void testDeleteProduct() {
        // Créez un ID simulé pour le produit que vous souhaitez supprimer
        Long productId = 1L; // Remplacez par l'ID du produit que vous souhaitez supprimer

        // Appelez la méthode à tester (deleteProduct) avec l'ID simulé
        productService.deleteProduct(productId);

        // Vérifiez si la méthode deleteById a été appelée avec l'ID simulé en utilisant Mockito
        verify(productRepository, times(1)).deleteById(productId);
    }


}
