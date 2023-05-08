package ken.backend.settings;

import ken.util.UID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SettingsEntry{
    @Getter
    private final UID id;
    @Getter
    private final String name;
    @Getter
    private Object storedValue;
    @Getter
    private final Class<?> valueClass;

    public void setStoredValue(Object value){
        if(!valueClass.isAssignableFrom(value.getClass()))
            throw new IllegalArgumentException(String.format(
                "Invalid value for settings entry %s (expected %s, got %s)",
                id, valueClass.getName(), value.getClass().getName()
            ));

        storedValue = value;
    }
}
