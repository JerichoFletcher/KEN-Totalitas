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
            Settings.set(settingsId, "USD");
            KENCurrencyHolder.instance().loadConfig();
            Map<String, Float> conversions = KENCurrencyHolder.instance().getConversions();
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
