package com.intech.lem.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IFSCDao {
    private Connection connection;

    public IFSCDao() throws Exception {
        connection = ICONDBConnection.getConnection();
    }

    public ArrayList<String> getFrameWork(String frameWork) {
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement ps = null;
        String data;
        try {
            ps = connection
                    .prepareStatement("SELECT IC_ID_CODE,IC_BANK_NAME,IC_BRANCH_NAME,IC_BRANCH_ADDRS,IC_CITY_NAME,IC_BRANCH_CODE,IC_BANK_CODE FROM INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y'  AND IC_ID_CODE LIKE ?");
            ps.setString(1, frameWork + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data = rs.getString("Company_Name");
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}