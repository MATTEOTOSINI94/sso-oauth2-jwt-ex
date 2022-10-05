package it.bitrock.ssooauth2jwtdemo.service;

import io.vavr.control.Option;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

public class ServiceUtils {

        public static final Predicate<Integer> IS_PAGE_VALID = page -> page != null && page > 0;

        public static <T> T getLast(List<T> list) {
                return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
        }
}
