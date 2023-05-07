import ken.backend.Vars;
import ken.backend.algoritma.BillProcessor;
import ken.backend.plugin.CallOnLoad;

public class DummyContent{
    @CallOnLoad
    public static void dummyHello(){
        System.out.printf("Hello from dummy function! My namespace is %s%n", KENPluginDummy.NAMESPACE);
    }

    @CallOnLoad
    public static void addDollarProcessor(){
        try{
            System.out.println("Adding dollar processor");
            Vars.billProcessor = BillProcessor.builder(Vars.billProcessor.getProcess())
                .withProcess(DollarProcessor.class)
                .build();
            Vars.mataUang = "$";
        }catch(Exception e){
            System.out.println("Failed to add dollar processor");
            e.printStackTrace();
        }
    }
}
