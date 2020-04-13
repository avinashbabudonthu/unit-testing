package com.springboot.spock.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppService {

    public List<Integer> findNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
