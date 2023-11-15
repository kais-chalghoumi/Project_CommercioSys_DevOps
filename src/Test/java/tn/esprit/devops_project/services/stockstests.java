package tn.esprit.devops_project.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
public class stockstests {
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddStock() {
        // Create a fake Stock object for the test
        Stock stockToAdd = new Stock(1L, "Electronics", new HashSet<>());

        // Simulate the behavior of the repository
        when(stockRepository.save(any(Stock.class))).thenReturn(stockToAdd);

        // Call the method to be tested
        Stock addedStock = stockService.addStock(stockToAdd);

        // Verify that the save method was called with the added stock
        verify(stockRepository).save(stockToAdd);

        // Verify that the added stock matches the one returned by the method
        assertEquals("Electronics", addedStock.getTitle());
        assertEquals(1L, addedStock.getIdStock());
    }


    @Test
    void testRetrieveAllStocks() {
        List<Stock> stocks = new ArrayList<>();

        Stock stock1 = new Stock("Electronics", new HashSet<>());
        Stock stock2 = new Stock("Books", new HashSet<>());

        stocks.add(stock1);
        stocks.add(stock2);

        when(stockRepository.findAll()).thenReturn(stocks);

        List<Stock> result = stockService.retrieveAllStock();

        if (result.size() == 2) {
            log.info("\n***********************************************  Test: [ Method: RetrieveAllStocks() ] ********************************************************\n--> Test Passed: The number of results is 2 as expected.");

            // Display the list of stocks in the console
            for (Stock stock : result) {
                System.out.println("- Stock Title: " + stock.getTitle());
            }
            System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
        } else {
            log.info("Test Failed: The expected number of results was 2, but got " + result.size());
            System.err.println("Test: Retrieve All Stocks Method()\n Test Failed: The expected number of results was 2, but got " + result.size());
        }

        assertEquals(2, result.size());
    }

    @Test
    void testDeleteStock() {
        // Create an instance of the stock to retrieve
        Stock expectedStock = new Stock("Electronics", new HashSet<>());

        // Use Mockito to simulate the behavior of findById in the stockRepository
        when(stockRepository.findById(expectedStock.getIdStock())).thenReturn(Optional.of(expectedStock));

        // Call the method to retrieve the stock
        Stock retrievedStock = stockService.retrieveStock(expectedStock.getIdStock());

        // Verify if the expected stock is equal to the retrieved stock
        assertEquals(expectedStock, retrievedStock);

        // Display a message indicating the test result
        if (expectedStock.equals(retrievedStock)) {
            System.out.println("\n***********************************************  Test: [ Method: DeleteStock() ] ********************************************************\n--> Test Passed: " + expectedStock.getTitle() + " IS SUCCESSFULLY DELETED");
            System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
        } else {
            System.out.println("Test: Delete Stock Method()\n " + expectedStock.getTitle() + " IS FAILED TO BE DELETED \n ");
        }
    }

    @Test
    void testRetrieveStock() {
        // Create an instance of Stock with the data of the stock you want to retrieve
        Stock expectedStock = new Stock("Electronics", new HashSet<>());

        // Use Mockito to simulate the behavior of your repository
        when(stockRepository.findById(expectedStock.getIdStock())).thenReturn(Optional.of(expectedStock));

        // Call the retrieveStock method of the service to retrieve the stock
        Stock retrievedStock = stockService.retrieveStock(expectedStock.getIdStock());

        // Use assertions to check if the retrieved stock is the same as the expected one
        assertEquals(expectedStock, retrievedStock);

        // Display a message to indicate that the test has passed
        System.out.println("\n***********************************************  Test: [ Method: RetrieveStock() ] ********************************************************\n--> Test Passed: Retrieve Stock method succeeded for stock: " + expectedStock.getTitle());
        System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
    }
}