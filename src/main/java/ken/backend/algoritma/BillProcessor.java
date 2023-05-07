package ken.backend.algoritma;

import ken.backend.kelas.bill.BillItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

public class BillProcessor{
    @Getter
    private final BillProcess process;

    private BillProcessor(BillProcess process){
        this.process = process;
    }

    public int get(Map<Integer, BillItem> listBarang){
        return process.process(listBarang);
    }

    public static Builder builder(BillProcess initialProcess){
        return new Builder(initialProcess);
    }

    public static class Builder{
        private BillProcess process;

        Builder(BillProcess initialProcess){
            process = initialProcess;
        }

        public BillProcessor build(){
            return new BillProcessor(process);
        }

        public Builder withProcess(Class<? extends BillProcessDecorator> decorator) throws Exception{
            process = decorator.getConstructor(BillProcess.class).newInstance(process);
            return this;
        }
    }
}
