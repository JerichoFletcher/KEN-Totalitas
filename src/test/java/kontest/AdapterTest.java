package kontest;

import ken.backend.dataStore.AdapterJSON;
import ken.backend.dataStore.AdapterXML;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.inventory.InventoryHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void testAdapterJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
////        Human hum = adapter.testUU(getClass().getResource("/database/tes.json").toURI());
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
//        System.out.println(inven.getBanyakBarang());
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());


    }
    @Test
    public void testWriteJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
////        Human hum = adapter.testUU(getClass().getResource("/database/tes.json").toURI());
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
//        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
////        System.out.println(inven.getBanyakBarang());
//        System.out.println(InventoryHolder.instance().getBanyakBarang());
//        AdapterJSON adapter = new AdapterJSON();
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
        InventoryHolder.instance().write(getClass().getResource("/database/barang2.json").toURI(),adapter);
    }
}
