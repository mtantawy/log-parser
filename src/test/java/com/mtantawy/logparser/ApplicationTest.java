package com.mtantawy.logparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

class ApplicationTest {
    @Test
    public void ExceptionThrownForNonExistingFile() {
        Assertions.assertThrows(
                NoSuchFileException.class,
                () -> (new Application("Kodi", "non-existing-file")).run()
        );
    }
}