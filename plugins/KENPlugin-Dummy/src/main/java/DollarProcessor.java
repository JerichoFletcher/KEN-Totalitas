import ken.backend.algoritma.BillProcess;
import ken.backend.algoritma.BillProcessDecorator;
import ken.backend.kelas.bill.BillItem;

import java.util.Map;

public class DollarProcessor extends BillProcessDecorator{
    public DollarProcessor(BillProcess wrappee){
        super(wrappee);
    }

    @Override
    public int process(Map<Integer, BillItem> listBarang){
        int sum = super.process(listBarang);
        return (int)(sum * 0.000068);
    }
}
