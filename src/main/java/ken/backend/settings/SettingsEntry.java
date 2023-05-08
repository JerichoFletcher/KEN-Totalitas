package ken.backend.settings;

import ken.util.UID;
import lombok.Getter;

public class SettingsEntry{
    @Getter
    private final UID id;
    @Getter
    private Object storedValue;
    @Getter
    private final Class<?> valueClass;

    public SettingsEntry(UID id, Object initialValue, Class<?> valueClass){
        this.id = id;
        this.storedValue = initialValue;
        this.valueClass = valueClass;
    }

    public void setStoredValue(Object value){
        if(!valueClass.isAssignableFrom(value.getClass()))
            throw new IllegalArgumentException(String.format(
                "Invalid value for settings entry %s (expected %s, got %s)",
                id, valueClass.getName(), value.getClass().getName()
            ));

        storedValue = value;
    }
}
