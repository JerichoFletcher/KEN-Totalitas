package kontest;

import ken.backend.dataStore.AdapterJSON;
import ken.backend.dataStore.AdapterXML;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.Bill;
import ken.backend.kelas.bill.BillHolder;
import ken.backend.kelas.bill.BillItem;
import ken.backend.kelas.bill.FixedBillHolder;
import ken.backend.kelas.inventory.InventoryHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void testAdapterJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
    }
    @Test
    public void testWriteJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
        InventoryHolder.instance().write(getClass().getResource("/database/barang3.json").toURI(),adapter);
    }

    @Test
    public void testReadBillJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());
        System.out.println(BillHolder.instance().getBillById(0).getTotalHarga());
    }

    @Test
    public void testWriteBillJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());
        BillHolder.instance().write(getClass().getResource("/database/bill2.json").toURI(),adapter);
    }

    @Test
    public void testAddingBillItem() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());

        BillItem bi = new BillItem("Shampo", 10,1000);
        BillHolder.instance().getBillById(0).addBarang(bi);
        BillHolder.instance().write(getClass().getResource("/database/bill.json").toURI(),adapter);
    }

    @Test
    public void testAddingFixedBillItem() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        FixedBillHolder.instance().load(getClass().getResource("/database/billFixed.json").toURI(),adapter);
        Assertions.assertEquals(2, FixedBillHolder.instance().getBanyakBill());

        BillItem bi = new BillItem("Shampo", 10,1000);
        FixedBillHolder.instance().getBillById(0).removeBarang(1);
        FixedBillHolder.instance().write(getClass().getResource("/database/billFixed2.json").toURI(),adapter);
    }

    @Test
    public void testWriteInventoryJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
        Barang barang = new Barang("Spatule",200,20000,15000,"Alat Masak","spatule.png");
        InventoryHolder.instance().addBarang(barang);
        InventoryHolder.instance().write(getClass().getResource("/database/barang3.json").toURI(),adapter);
    }
}
