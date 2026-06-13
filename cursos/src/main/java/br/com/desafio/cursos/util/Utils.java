package br.com.desafio.cursos.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.net.URI;
import java.util.UUID;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class, and not instantiable");
    }

    public static URI getURI(String path, UUID id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(path).buildAndExpand(id).toUri();
    }

    public static void copyNonFieldsNull(Object source, Object target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source e target não podem ser nulos.");
        }
        try {

            if (source.getClass().isRecord()) {

                for (RecordComponent component : source.getClass().getRecordComponents()) {
                    Object value = component.getAccessor().invoke(source);
                    if (value == null) {
                        continue;
                    }

                    try {
                        Field targetField = target.getClass().getDeclaredField(component.getName());
                        targetField.setAccessible(true);
                        targetField.set(target, value);
                    } catch (NoSuchFieldException ignored) {
                    }
                }

            } else {

                for (Field sourceField : source.getClass().getDeclaredFields()) {
                    sourceField.setAccessible(true);
                    Object value = sourceField.get(source);
                    if (value == null) {
                        continue;
                    }

                    try {
                        Field targetField = target.getClass().getDeclaredField(sourceField.getName());
                        targetField.setAccessible(true);
                        targetField.set(target, value);
                    } catch (NoSuchFieldException ignored) {
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao copiar propriedades", e);
        }
    }
}
