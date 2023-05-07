package ken.backend.kelas.anggota;
import ken.backend.kelas.holder.CustomerHolder;
import ken.backend.kelas.holder.MemberHolder;
import ken.backend.kelas.holder.VIPHolder;
import lombok.*;

import java.util.Random;

public class Customer {
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