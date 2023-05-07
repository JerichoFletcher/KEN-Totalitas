package kontest;

import ken.backend.controller.holder.*;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.anggota.*;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.BillHolder;
import ken.backend.kelas.bill.BillItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void testAdapterJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);

        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
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

    @Test
    public void testRWCustomerJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        CustomerHolder.instance().load(getClass().getResource("/database/customer.json").toURI(),adapter);
        System.out.println("jumlah " + CustomerHolder.instance().getBanyakCustomer());
        Customer newCust = new Customer();
        CustomerHolder.instance().addCustomer(newCust);
        CustomerHolder.instance().write(getClass().getResource("/database/customer2.json").toURI(),adapter);
    }

    @Test
    public void testRWMemberJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();;
        MemberHolder.instance().load(getClass().getResource("/database/member.json").toURI(),adapter);
        System.out.println("jumlah " + MemberHolder.instance().getBanyakMember());
        Member newMember = new Member("Asu Meme","09988776", 1);
        MemberHolder.instance().addMember(newMember);
        MemberHolder.instance().write(getClass().getResource("/database/member2.json").toURI(),adapter);
    }
    @Test
    public void testRWVIPJSON() throws IOException, URISyntaxException {
        AdapterJSON adapter = new AdapterJSON();
        CustomerHolder.instance().load(getClass().getResource("/database/customer.json").toURI(),adapter);
        MemberHolder.instance().load(getClass().getResource("/database/member.json").toURI(),adapter);
        VIPHolder.instance().load(getClass().getResource("/database/vip.json").toURI(),adapter);
        System.out.println("jumlah " + VIPHolder.instance().getBanyakVIP());
        VIP newVIP = new VIP("Asu Meme","09988776");
        VIP newVIP2 = new VIP("VEVEVE","09988776");
        VIP newVIP3 = new VIP("BUBU","09988776");
        VIPHolder.instance().addVIP(newVIP);
        VIPHolder.instance().addVIP(newVIP2);
        VIPHolder.instance().addVIP(newVIP3);
        VIPHolder.instance().write(getClass().getResource("/database/vip2.json").toURI(),adapter);
    }
}
