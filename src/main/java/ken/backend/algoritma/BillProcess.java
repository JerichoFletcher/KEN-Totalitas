package ken.backend.algoritma;

import ken.backend.kelas.bill.BillItem;

import java.util.Map;

public interface BillProcess{
    float process(Map<Integer, BillItem> listBarang);
}
