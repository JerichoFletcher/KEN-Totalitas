package ken.backend.kelas.anggota;
import ken.backend.controller.holder.CustomerHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import lombok.*;

import java.io.Serializable;
import java.util.Random;

public class Customer implements Serializable {
    @Getter
    private int id;
    private static Random rand = new Random();

    public Customer(int id){
        this.id = id;
    }

    public Customer() {
        CustomerHolder ch = CustomerHolder.instance();
        MemberHolder mh = MemberHolder.instance();
        VIPHolder vh = VIPHolder.instance();
        int id = rand.nextInt(Integer.MAX_VALUE);
        for(; ch.getCustomerById(id) != null || mh.getMemberById(id) != null || vh.getVIPById(id) != null;id = rand.nextInt(Integer.MAX_VALUE));
        this.id = id;
    }
}