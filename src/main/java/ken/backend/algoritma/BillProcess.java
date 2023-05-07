package ken.backend.algoritma;

import ken.backend.kelas.bill.BillItem;

import java.util.Map;

public interface BillProcess{
    int process(Map<Integer, BillItem> listBarang);
}
