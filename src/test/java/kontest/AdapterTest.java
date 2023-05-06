package kontest;

import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void testAdapterJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
//        Human hum = adapter.testUU(getClass().getResource("/database/tes.json").toURI());
        Inventory inven = adapter.getInventory(getClass().getResource("/database/barang.json").toURI());
        Assertions.assertEquals(5, inven.getBanyakBarang());
//        System.out.println(inven.getBanyakBarang());
    }
}
