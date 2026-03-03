package com.example.oceanviewresort.util;

import com.oceanview.util.DBConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class DBConnectionTest {

    @Test
    void testGetConnection() throws Exception {
        Connection con = DBConnection.getConnection();
        assertNotNull(con);
        assertFalse(con.isClosed());
        con.close();
    }
}