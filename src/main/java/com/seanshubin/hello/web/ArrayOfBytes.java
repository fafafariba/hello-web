package com.seanshubin.hello.web;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ArrayOfBytes {
    private final byte[] bytes;

    public ArrayOfBytes(byte[] bytes) {
        this.bytes = Arrays.copyOf(bytes, bytes.length);
    }

    public byte[] bytes() {
        return Arrays.copyOf(bytes, bytes.length);
    }

    @Override
    public String toString() {
        return "ArrayOfBytes{" +
                "bytes=" + Arrays.toString(bytes) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayOfBytes that = (ArrayOfBytes) o;
        return Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    public String toStringUtf8() {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static ArrayOfBytes fromStringUtf8(String body) {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        return new ArrayOfBytes(bytes);
    }
}
