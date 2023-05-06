package kentest.backend;

import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void givenValidJSON_WhenReadWithAdapter_ShouldReadCorrectly() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
//        Human hum = adapter.testUU(getClass().getResource("/database/tes.json").toURI());
        Inventory.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        Assertions.assertEquals(5, Inventory.instance().getBanyakBarang());
//        System.out.println(inven.getBanyakBarang());
    }
}
