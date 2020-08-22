package com.mtantawy.logparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    public void ExceptionThrownForNonExistingFile() {
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> new Application("Kodi", "non-existing-file")
        );

        Assertions.assertEquals("File does not exist or not readable!", exception.getMessage());
    }
}