package br.com.desafio.cursos.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
}
