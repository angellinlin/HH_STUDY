package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connector {

        public Connection con;

        public PreparedStatement ps;

        public ResultSet rs;

        public connector(){
            con = null;
            ps = null;
            rs = null;
        }
}
