package crafttweaker.api.data;

import crafttweaker.CraftTweakerAPI;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Contains a string value.
 *
 * @author Stan Hebben
 */
public class DataString implements IData {
    
    private final String value;
    
    public DataString(String value) {
        this.value = value;
    }
    
    @Override
    public boolean asBool() {
        return Boolean.parseBoolean(value);
    }
    
    @Override
    public byte asByte() {
        try {
            return Byte.parseByte(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Byte, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public short asShort() {
        try {
            return Short.parseShort(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Short, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public int asInt() {
        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Int, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public long asLong() {
        try {
            return Long.parseLong(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Long, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public float asFloat() {
        try {
            return Float.parseFloat(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Float, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public double asDouble() {
        try {
            return Double.parseDouble(value);
        } catch(NumberFormatException ignored) {
            CraftTweakerAPI.logError("DataString " + value + " cannot be parsed to Double, substituting 0!");
            return 0;
        }
    }
    
    @Override
    public String asString() {
        return value;
    }
    
    @Override
    public List<IData> asList() {
        return null;
    }
    
    @Override
    public Map<String, IData> asMap() {
        return Collections.singletonMap(value, this);
    }
    
    @Override
    public byte[] asByteArray() {
        return null;
    }
    
    @Override
    public int[] asIntArray() {
        return null;
    }
    
    @Override
    public IData getAt(int i) {
        return new DataString(value.substring(i, i + 1));
    }
    
    @Override
    public void setAt(int i, IData value) {
        throw new UnsupportedOperationException("Strings are immutable");
    }
    
    @Override
    public IData memberGet(String name) {
        if(name.equals("length")) {
            return new DataInt(value.length());
        } else {
            throw new UnsupportedOperationException("no such member: " + name);
        }
    }
    
    @Override
    public void memberSet(String name, IData data) {
        throw new UnsupportedOperationException("Strings are immutable");
    }
    
    @Override
    public int length() {
        return value.length();
    }
    
    @Override
    public boolean contains(IData data) {
        return data.asString().equals(value);
    }
    
    @Override
    public boolean equals(IData data) {
        return value.equals(data.asString());
    }
    
    @Override
    public int compareTo(IData data) {
        return value.compareTo(data.asString());
    }
    
    @Override
    public IData immutable() {
        return this;
    }
    
    @Override
    public IData update(IData data) {
        return data;
    }
    
    @Override
    public <T> T convert(IDataConverter<T> converter) {
        return converter.fromString(value);
    }
    
    @Override
    public IData add(IData other) {
        return new DataString(value + other.asString());
    }
    
    @Override
    public IData sub(IData other) {
        throw new UnsupportedOperationException("Cannot subtract from a string");
    }
    
    @Override
    public IData mul(IData other) {
        throw new UnsupportedOperationException("Cannot multiply a string");
    }
    
    @Override
    public IData div(IData other) {
        throw new UnsupportedOperationException("Cannot divide a string");
    }
    
    @Override
    public IData mod(IData other) {
        throw new UnsupportedOperationException("Cannot perform modulo on a string");
    }
    
    @Override
    public IData and(IData other) {
        throw new UnsupportedOperationException("Cannot perform bitwise arithmetic on a string");
    }
    
    @Override
    public IData or(IData other) {
        throw new UnsupportedOperationException("Cannot perform bitwise arithmetic on a string");
    }
    
    @Override
    public IData xor(IData other) {
        throw new UnsupportedOperationException("Cannot perform bitwise arithmetic on a string");
    }
    
    @Override
    public IData neg() {
        throw new UnsupportedOperationException("Cannot negate a string");
    }
    
    @Override
    public IData not() {
        throw new UnsupportedOperationException("Cannot perform bitwise arithmetic on a string");
    }
    
    @Override
    public String toString() {
        return quoteAndEscape(value);
//        return '\"' + value.replace("\"", "\\\"") + "\"";
    }
    
    public static String quoteAndEscape(String p_193588_0_)
    {
        StringBuilder stringbuilder = new StringBuilder("\"");
        
        for (int i = 0; i < p_193588_0_.length(); ++i)
        {
            char c0 = p_193588_0_.charAt(i);
            
            if (c0 == '\\' || c0 == '"')
            {
                stringbuilder.append('\\');
            }
            
            stringbuilder.append(c0);
        }
        
        return stringbuilder.append('"').toString();
    }
}