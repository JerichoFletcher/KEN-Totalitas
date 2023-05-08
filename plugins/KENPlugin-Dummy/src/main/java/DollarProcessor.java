import ken.backend.algoritma.BillProcess;
import ken.backend.algoritma.BillProcessDecorator;
import ken.backend.kelas.bill.BillItem;

import java.util.Map;

public class DollarProcessor extends BillProcessDecorator{
    public DollarProcessor(BillProcess wrappee){
        super(wrappee);
    }

    @Override
    public float process(Map<Integer, BillItem> listBarang){
        float sum = super.process(listBarang);
        return (float)(sum * 0.000068);
    }
}
