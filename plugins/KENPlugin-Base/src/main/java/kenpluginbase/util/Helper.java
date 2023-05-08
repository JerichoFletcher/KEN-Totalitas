package kenpluginbase.util;

import ken.backend.Vars;
import ken.backend.algoritma.BillProcess;
import ken.backend.algoritma.BillProcessDecorator;
import ken.backend.algoritma.BillProcessor;
import ken.backend.kelas.bill.BillItem;

import java.util.Map;
import java.util.function.Function;

public class Helper{
    public static void appendBillProcessor(Function<Float, Float> func) throws Exception{
        BillProcessAppender dec = new BillProcessAppender(Vars.billProcessor.getProcess());
        dec.setFunc(func);
        Vars.billProcessor = BillProcessor.builder(Vars.billProcessor.getProcess())
            .withProcess(dec.getClass()).build();
    }

    public static void prependBillProcessor(Function<Map<Integer, BillItem>, Map<Integer, BillItem>> func) throws Exception{
        BillProcessPrepender dec = new BillProcessPrepender(Vars.billProcessor.getProcess());
        dec.setFunc(func);
        Vars.billProcessor = BillProcessor.builder(Vars.billProcessor.getProcess())
            .withProcess(dec.getClass()).build();
    }

    public static class BillProcessAppender extends BillProcessDecorator{
        public Function<Float, Float> func;

        public BillProcessAppender(BillProcess wrappee){
            super(wrappee);
        }

        void setFunc(Function<Float, Float> func){
            this.func = func;
            System.out.println(this.func);
        }

        @Override
        public float process(Map<Integer, BillItem> listBarang){
            System.out.println(func);
            return func.apply(super.process(listBarang));
        }
    }

    public static class BillProcessPrepender extends BillProcessDecorator{
        public Function<Map<Integer, BillItem>, Map<Integer, BillItem>> func;

        public BillProcessPrepender(BillProcess wrappee){
            super(wrappee);
        }

        void setFunc(Function<Map<Integer, BillItem>, Map<Integer, BillItem>> func){
            this.func = func;
        }

        @Override
        public float process(Map<Integer, BillItem> listBarang){
            Map<Integer, BillItem> newListBarang = func.apply(listBarang);
            return super.process(newListBarang);
        }
    }
}
