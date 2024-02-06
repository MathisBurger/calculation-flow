package de.mathisburger.factory;

import java.util.Optional;

/**
 * Enum that contains all values
 */
public enum ParamEnum {
    STRING,
    CHAR,
    INT,
    LONG,
    DOUBLE;

    public Optional<String> optionalString;

    public Optional<Character> optionalChar;

    public Optional<Integer> optionalInteger;

    public Optional<Long> optionalLong;

    public Optional<Double> optionalDouble;

    ParamEnum() {
        this.optionalString = Optional.empty();
        this.optionalChar = Optional.empty();
        this.optionalInteger = Optional.empty();
        this.optionalLong = Optional.empty();
        this.optionalDouble = Optional.empty();
    }

    public void setString(String s) {
        if (this == ParamEnum.STRING) {
            this.optionalString = Optional.of(s);
        }
    }

    public void setChar(char c) {
        if (this == ParamEnum.CHAR) {
            this.optionalChar = Optional.of(c);
        }
    }

    public void setInteger(int i) {
        if (this == ParamEnum.INT) {
            this.optionalInteger = Optional.of(i);
        }
    }

    public void setLong(long l) {
        if (this == ParamEnum.LONG) {
            this.optionalLong = Optional.of(l);
        }
    }

    public void setDouble(double d) {
        if (this == ParamEnum.DOUBLE) {
            this.optionalDouble = Optional.of(d);
        }
    }

    public String getString() {
        return this.optionalString.get();
    }

    public char getChar() {
        return this.optionalChar.get();
    }

    public int getInteger() {
        return this.optionalInteger.get();
    }

    public long getLong() {
        return this.optionalLong.get();
    }

    public double getDouble() {
        return this.optionalDouble.get();
    }

    public static ParamEnum getType(String type) {
        String lower = type.toLowerCase();
        return switch (lower) {
            case "char" -> ParamEnum.CHAR;
            case "int" -> ParamEnum.INT;
            case "long" -> ParamEnum.LONG;
            case "double" -> ParamEnum.DOUBLE;
            default -> ParamEnum.STRING;
        };
    }
}
