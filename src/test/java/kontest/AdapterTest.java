package kontest;

import ken.backend.Vars;
import ken.backend.controller.holder.*;
import ken.backend.controller.Controller;
import ken.backend.controller.holder.*;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.dataStore.AdapterObject;
import ken.backend.dataStore.AdapterXML;
import ken.backend.kelas.anggota.*;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.BillItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URISyntaxException;

public class AdapterTest {
    @Test
    public void testAdapterJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);

        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
    }

    @Test
    public void testWriteJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);

        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
        InventoryHolder.instance().write(getClass().getResource("/database/barang3.json").toURI(),adapter);
    }

    @Test
    public void testReadBillJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());
        System.out.println(BillHolder.instance().getBillById(0).getTotalHarga());
    }

    @Test
    public void testWriteBillJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());
        BillHolder.instance().write(getClass().getResource("/database/bill2.json").toURI(),adapter);
    }

    @Test
    public void testAddingBillItem() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        BillHolder.instance().load(getClass().getResource("/database/bill.json").toURI(),adapter);
        Assertions.assertEquals(2, BillHolder.instance().getBanyakBill());

//        BillItem bi = new BillItem("Shampo", 10,1000);
//        BillHolder.instance().getBillById(0).addBarang(bi);
        BillHolder.instance().write(getClass().getResource("/database/bill.json").toURI(),adapter);
    }

    @Test
    public void testAddingFixedBillItem() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        FixedBillHolder.instance().load(getClass().getResource("/database/billFixed.json").toURI(),adapter);
        Assertions.assertEquals(2, FixedBillHolder.instance().getBanyakBill());

//        BillItem bi = new BillItem("Shampo", 10,1000);
//        FixedBillHolder.instance().getBillById(0).removeBarang(1);
        FixedBillHolder.instance().write(getClass().getResource("/database/billFixed2.json").toURI(),adapter);
    }

    @Test
    public void testWriteInventoryJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);
        System.out.println("jumlah " + InventoryHolder.instance().getBanyakBarang());
        Barang barang = new Barang("Spatule",200,20000,15000,"Alat Masak","spatule.png");
        InventoryHolder.instance().addBarang(barang);
        InventoryHolder.instance().write(getClass().getResource("/database/barang3.json").toURI(),adapter);
    }

    @Test
    public void testRWCustomerJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        CustomerHolder.instance().load(getClass().getResource("/database/customer.json").toURI(),adapter);
        System.out.println("jumlah " + CustomerHolder.instance().getBanyakCustomer());
        Customer newCust = new Customer();
        CustomerHolder.instance().addCustomer(newCust);
        CustomerHolder.instance().write(getClass().getResource("/database/customer2.json").toURI(),adapter);
    }

    @Test
    public void testRWMemberJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();;
        MemberHolder.instance().load(getClass().getResource("/database/member.json").toURI(),adapter);
        System.out.println("jumlah " + MemberHolder.instance().getBanyakMember());
        Member newMember = new Member("Asu Meme","09988776", 1);
        MemberHolder.instance().addMember(newMember);
        MemberHolder.instance().write(getClass().getResource("/database/member2.json").toURI(),adapter);
    }
    @Test
    public void testRWVIPJSON() throws Exception {
        AdapterJSON adapter = new AdapterJSON();
        CustomerHolder.instance().load(getClass().getResource("/database/customer.json").toURI(),adapter);
        MemberHolder.instance().load(getClass().getResource("/database/member.json").toURI(),adapter);
        VIPHolder.instance().load(getClass().getResource("/database/vip.json").toURI(),adapter);
        System.out.println("jumlah " + VIPHolder.instance().getBanyakVIP());
        VIP newVIP = new VIP("Asu Meme","09988776", 1);
        VIP newVIP2 = new VIP("VEVEVE","09988776", 2);
        VIP newVIP3 = new VIP("BUBU","09988776", 3);
        VIPHolder.instance().addVIP(newVIP);
        VIPHolder.instance().addVIP(newVIP2);
        VIPHolder.instance().addVIP(newVIP3);
        VIPHolder.instance().write(getClass().getResource("/database/vip2.json").toURI(),adapter);
    }
    @Test
    public void testControllerCustomer() throws Exception {
        Controller.instance().fetchData(MemberHolder.instance(),"member");
        Member nm = new Member("Nama", "098123",12425135);
        MemberHolder.instance().addMember(nm);
        Controller.instance().writeData(MemberHolder.instance(),"member");
    }

    public void testAdapterXML2() throws Exception {
        AdapterXML adapter = new AdapterXML();;
        AdapterJSON adapter2 = new AdapterJSON();
        InventoryHolder.instance().load(getClass().getResource("/database/barang.xml").toURI(),adapter);
        System.out.println(InventoryHolder.instance().getBanyakBarang());
        Assertions.assertEquals(5, InventoryHolder.instance().getBanyakBarang());
    }

    @Test
    public void testAdapterObject() throws Exception {
        AdapterObject adapter = new AdapterObject();;
        AdapterJSON adapter2 = new AdapterJSON();
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter2);
        InventoryHolder.instance().write(getClass().getResource("/database/barang.ser").toURI(),adapter);
    }

    @Test
    public void testAdapterObject2() throws Exception {
        AdapterObject adapter = new AdapterObject();;
        AdapterJSON adapter2 = new AdapterJSON();
        InventoryHolder.instance().load(getClass().getResource("/database/barang.ser").toURI(),adapter);
        System.out.println(InventoryHolder.instance().getBanyakBarang());
    }

    @Test
    public void testAdapterObject3() throws Exception {
        AdapterObject adapter = new AdapterObject();;
        AdapterJSON adapter2 = new AdapterJSON();
        InventoryHolder.instance().load(getClass().getResource("/database/barang.ser").toURI(),adapter);
        InventoryHolder.instance().write(getClass().getResource("/database/barangtes.json").toURI(),adapter2);
    }

    @Test
    public void changeAllSERtofollowJSON() throws Exception {
        Vars.extension = "json";
        Controller.instance().fetchData(InventoryHolder.instance(),"barang");
        Controller.instance().fetchData(BillHolder.instance(),"bill");
        Controller.instance().fetchData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().fetchData(MemberHolder.instance(),"member");
        Controller.instance().fetchData(CustomerHolder.instance(),"customer");
        Controller.instance().fetchData(VIPHolder.instance(),"vip");
        Vars.extension = "ser";
        Controller.instance().writeData(InventoryHolder.instance(),"barang");
        Controller.instance().writeData(BillHolder.instance(),"bill");
        Controller.instance().writeData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().writeData(MemberHolder.instance(),"member");
        Controller.instance().writeData(CustomerHolder.instance(),"customer");
        Controller.instance().writeData(VIPHolder.instance(),"vip");
    }
    @Test
    public void changeAllXMLtofollowJSON() throws Exception {
        Vars.extension = "json";
        Controller.instance().fetchData(InventoryHolder.instance(),"barang");
        Controller.instance().fetchData(BillHolder.instance(),"bill");
        Controller.instance().fetchData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().fetchData(MemberHolder.instance(),"member");
        Controller.instance().fetchData(CustomerHolder.instance(),"customer");
        Controller.instance().fetchData(VIPHolder.instance(),"vip");
        Vars.extension = "xml";
        Controller.instance().writeData(InventoryHolder.instance(),"barang");
        Controller.instance().writeData(BillHolder.instance(),"bill");
        Controller.instance().writeData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().writeData(MemberHolder.instance(),"member");
        Controller.instance().writeData(CustomerHolder.instance(),"customer");
        Controller.instance().writeData(VIPHolder.instance(),"vip");
    }

    @Test
    public void populateBarangJSON() throws Exception {
        Vars.extension = "json";
        Controller.instance().fetchData(InventoryHolder.instance(),"barang");
        Barang barang1 = new Barang("Kucing Emas",500,500000,20000,"Aksesoris","./assets/kucingEmas.png");
        Barang barang2 = new Barang("Action Figure",10,1000000,25000,"Aksesoris","./assets/actionPigur.png");
        Barang barang3 = new Barang("VibraThor",100,1000000,250000,"Aksesoris","./assets/vibraThor.png");
        Barang barang4 = new Barang("Deal Down",16,50000,25000,"Aksesoris","./assets/dealDown.png");
        InventoryHolder.instance().addBarang(barang1);
        InventoryHolder.instance().addBarang(barang2);
        InventoryHolder.instance().addBarang(barang3);
        InventoryHolder.instance().addBarang(barang4);
        Controller.instance().writeData(InventoryHolder.instance(),"barang");
    }

    @Test
    public void mencobaXML() throws Exception {
        Vars.extension = "xml";
        Controller.instance().fetchData(InventoryHolder.instance(),"barang2");
        Vars.extension = "json";
        Controller.instance().writeData(InventoryHolder.instance(),"barang3");

    }
    @Test
    public void matchAllToJSON() throws Exception {
        Vars.extension = "json";
        Controller.instance().fetchData(InventoryHolder.instance(),"barang");
        Controller.instance().fetchData(BillHolder.instance(),"bill");
        Controller.instance().fetchData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().fetchData(MemberHolder.instance(),"member");
        Controller.instance().fetchData(CustomerHolder.instance(),"customer");
        Controller.instance().fetchData(VIPHolder.instance(),"vip");

        Vars.extension = "ser";
        Controller.instance().writeData(InventoryHolder.instance(),"barang");
        Controller.instance().writeData(BillHolder.instance(),"bill");
        Controller.instance().writeData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().writeData(MemberHolder.instance(),"member");
        Controller.instance().writeData(CustomerHolder.instance(),"customer");
        Controller.instance().writeData(VIPHolder.instance(),"vip");

        Vars.extension = "xml";
        Controller.instance().writeData(InventoryHolder.instance(),"barang");
        Controller.instance().writeData(BillHolder.instance(),"bill");
        Controller.instance().writeData(FixedBillHolder.instance(),"billFixed");
        Controller.instance().writeData(MemberHolder.instance(),"member");
        Controller.instance().writeData(CustomerHolder.instance(),"customer");
        Controller.instance().writeData(VIPHolder.instance(),"vip");

    }

}
