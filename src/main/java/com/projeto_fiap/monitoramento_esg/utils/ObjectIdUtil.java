package com.projeto_fiap.monitoramento_esg.utils;

import org.bson.types.ObjectId;

public final class ObjectIdUtil {
    private ObjectIdUtil() {}

    public static ObjectId parseOrNull(String s) {
        if (s == null || s.isBlank()) return null;
        return ObjectId.isValid(s) ? new ObjectId(s) : null;
    }

    public static String toString(ObjectId id) {
        return id == null ? null : id.toHexString();
    }
}
