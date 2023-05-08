package kencurrency;

import ken.backend.Vars;
import ken.backend.algoritma.BillProcess;
import ken.backend.algoritma.BillProcessDecorator;
import ken.backend.algoritma.BillProcessor;
import ken.backend.controller.Controller;
import ken.backend.kelas.bill.BillItem;
import ken.backend.plugin.CallOnLoad;
import ken.backend.settings.Settings;
import ken.util.UID;
import kenpluginbase.util.Helper;

import java.net.URI;
import java.util.Map;

public class KENCurrencyConverter{
    private final static UID settingsId = UID.of(Vars.defaultNamespace, "settings", "currency");

    @CallOnLoad
    public static void initialize(){
        try{
            Settings.add(settingsId, "Display Currency", String.class, "USD");
//            Controller.instance().getAdapterList().get(Vars.extension).get(
//                KENCurrencyConverter.class.getResource("/kencurrency/converter." + Vars.extension).toURI(),
//                KENCurrencyHolder.class
//            );
            Map<String, Float> conversions = KENCurrencyHolder.instance().getConversions();
            conversions.put("IDR", 1f);
            conversions.put("USD", 0.000068128938f);
            conversions.put("JPY", 0.0091988848f);
            conversions.put("RUB", 0.0052888489f);
            conversions.put("EUR", 0.000061808114f);
            conversions.put("GBP", 0.000053957394f);
            conversions.put("SGD", 0.000090333033f);
            conversions.put("AUD", 0.00010091814f);
            conversions.put("INR", 0.0055681445f);
            conversions.put("NZD", 0.00010817752f);
            System.out.println(KENCurrencyHolder.instance().getConversions());

//            Helper.appendBillProcessor(price -> KENCurrencyHolder.instance().convert(price, "IDR", (String)Settings.get(settingsId)));
            Vars.billProcessor = BillProcessor.builder(Vars.billProcessor.getProcess())
                .withProcess(BillPriceConverter.class).build();
        }catch(Exception ex){
            System.out.println("Failed to load currency data");
            ex.printStackTrace();
        }
    }

    public static class BillPriceConverter extends BillProcessDecorator{
        public BillPriceConverter(BillProcess wrappee){
            super(wrappee);
        }

        @Override
        public float process(Map<Integer, BillItem> listBarang){
            return KENCurrencyHolder.instance().convert(super.process(listBarang), "IDR", (String)Settings.get(settingsId));
        }
    }
}
