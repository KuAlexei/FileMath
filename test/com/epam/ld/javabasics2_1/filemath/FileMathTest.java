package com.epam.ld.javabasics2_1.filemath;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileMathTest {

    @Test
    void processFile() {
        assertThrows(FileNotFoundException.class, () ->  FileMath.processFile("inexistentFile.math", "inexistentFile.out"));
        assertDoesNotThrow(() -> FileMath.processFile("test1.math", "test1.out"));
    }

}
