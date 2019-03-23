package com.leavemanagement.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBuilderTest {

    @Test
    public void build(){
        Employee john= EmployeeBuilder.builder().name("John Cena").email("johncena@youcantseeme.com").build();
        assertEquals("John Cena",john.getName());
        assertEquals("johncena@youcantseeme.com",john.getEmail());
    }

}