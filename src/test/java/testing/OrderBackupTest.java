package testing;

import org.junit.jupiter.api.*;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheNewLine() throws IOException {
        orderBackup.getWriter().append("nowe zamuwienie" );
    }

    @AfterEach
    void appendnakoncu() throws IOException {
        GregorianCalendar data = new GregorianCalendar();
        String dataak = data.getTime().toString();
        orderBackup.getWriter().append("koniec " + dataak);
    }
    @Tag("Fires")
     @Test
     void backupOrderWithOneMeal() throws IOException {
        //given
         Meal meal = new Meal(7,"Fries");
         Meal meal1 = new Meal(8,"Soup");
         Meal meal2 = new Meal(9,"Pizza");
         Order order = new Order();
         order.addMealToOrder(meal);
         order.addMealToOrder(meal1);
         order.addMealToOrder(meal2);

         //when
         orderBackup.backupOrder(order);

         //then
         System.out.println("Order: " + order.toString() + " kopia utworzona");
     }


    @AfterAll
    static void tearDown() throws IOException {

        orderBackup.closeFile();
    }











}
