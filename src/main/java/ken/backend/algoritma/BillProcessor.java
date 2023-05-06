package ken.backend.algoritma;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class BillProcessor{
    private BillProcessor(){

    }

    public Builder builder(){
        return new Builder();
    }

    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    public static class Builder{
        public BillProcessor build(){
            return new BillProcessor();
        }
    }
}
