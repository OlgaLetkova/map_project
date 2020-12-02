package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    @Nested
    public class Empty {
        @Test
        void shouldRegisterOfNewApplication() {
            manager.shouldRegisterOfNewApplication(".html", "Google Chrome");
            boolean actual = manager.isMapEmpty();
            assertFalse(actual);
        }
    }

    @Nested
    public class NotEmpty {
        @BeforeEach
        public void setUp() {
            manager.shouldRegisterOfNewApplication(".html", "Google Chrome");
            manager.shouldRegisterOfNewApplication(".jpg", "Microsoft Windows Photos");
            manager.shouldRegisterOfNewApplication(".txt", "LibreOffice");
            manager.shouldRegisterOfNewApplication(".msg", "Microsoft Outlook");
        }

        @Test
        void shouldGetNameForSpecificExtension() {
            String actual = manager.shouldGetNameForSpecificExtension(".jpg");
            String expected = "Microsoft Windows Photos";
            assertEquals(expected, actual);
        }

        @Test
        void shouldGetNameForSpecificExtensionIfNotExist() {
            String actual = manager.shouldGetNameForSpecificExtension(".dwg");
            assertNull(actual);
        }

        @Test
        void shouldDeleteApplicationBinding() {
            manager.shouldDeleteApplicationBinding(".html");
            String actual = manager.shouldGetNameForSpecificExtension(".html");
            assertNull(actual);
        }

        @Test
        void shouldGetListOfAllExtensions() {
            Set<String> actual = manager.shouldGetListOfAllExtensions();
            Set<String> expected = Set.of(".html",".jpg",".txt",".msg");
            assertEquals(expected, actual);
        }

        @Test
        void shouldGetListOfAllNames() {
            Set<String> actual = manager.shouldGetListOfAllNames();
            Set<String> expected = Set.of("Google Chrome","Microsoft Windows Photos","LibreOffice","Microsoft Outlook");
            assertEquals(expected, actual);
        }
    }
}