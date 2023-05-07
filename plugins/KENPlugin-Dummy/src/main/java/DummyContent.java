import ken.backend.plugin.CallOnLoad;

public class DummyContent{
    @CallOnLoad
    public static void dummyHello(){
        System.out.printf("Hello from dummy function! My namespace is %s%n", KENPluginDummy.NAMESPACE);
    }
}
