import kencurrency.KENCurrencyConverter;
import kencurrency.KENCurrencyHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest{
    @Test
    public void givenValidResource_WhenLoadCurrencyData_ShouldReadCorrectly(){
        KENCurrencyConverter.initialize();
        Assertions.assertTrue(KENCurrencyHolder.instance().getConversions().size() > 0);
    }
}
