package ken.backend;

import ken.backend.algoritma.BillProcessor;
import ken.backend.kelas.bill.BillItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vars{
    public static final String defaultNamespace = "ken";
    public static String path = "./db/";
    public static String extension = "json";

    public static String mataUang = "IDR";

    public static BillProcessor billProcessor = BillProcessor
        .builder(listBarang -> {
            int sum = 0;
            for(Map.Entry<Integer, BillItem> entry : listBarang.entrySet()){
                BillItem item = entry.getValue();
                sum += item.getHargaBarang() * item.getJumlahDibeli();
            }
            return sum;
        })
        .build();
}
