package ken.backend.algoritma;

import ken.backend.kelas.bill.BillItem;

import java.util.Map;

public abstract class BillProcessDecorator implements BillProcess{
    protected final BillProcess wrappee;

    public BillProcessDecorator(BillProcess wrappee){
        this.wrappee = wrappee;
    }

    @Override
    public int process(Map<Integer, BillItem> listBarang){
        return wrappee.process(listBarang);
    }
}
