package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.anggota.Customer;
import ken.backend.kelas.anggota.Member;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MemberHolder implements Holder {
    private static MemberHolder _instance = null;
    public static MemberHolder instance(){
        if(_instance == null){
            _instance = new MemberHolder();
        }
        return _instance;
    }
    @Getter
    @Setter
    private Map<Integer, Member> listMember;

    private MemberHolder(){
        this.listMember = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, MemberHolder.class);
    }

    public void write(URI uri, AdapterData data) throws IOException {
        data.write(uri, MemberHolder.instance());
    }
    public int getBanyakMember(){
        return listMember.size();
    }
    public void addMember(Member c) {
        this.listMember.put(c.getId(),c);
    }
    public void removeMember(int id) {
        this.listMember.remove(id);
    }
    public Customer getMemberById(int id) {
        return listMember.get(id);
    }
}
