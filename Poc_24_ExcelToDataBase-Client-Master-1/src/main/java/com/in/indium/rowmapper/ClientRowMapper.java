package com.in.indium.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.in.indium.model.ClientUser;

public class ClientRowMapper implements RowMapper<ClientUser> {

	@Override
	public ClientUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ClientUser client=new ClientUser();
		client.setClient(rs.getInt("CLIENTID"));
		client.setName(rs.getNString("CLIENTNAME"));
		client.setCliType("CLIENTTYPE");
		client.setAccType("ACCOUNTTYPE");
		client.setDate("ACCOUNT OPEN DATE");
		client.setINameType("INTERMEDIARYNAME");
		client.setSchName("SCHEMENAME");
		client.setRegMgName("RELMGRNAME");
		client.setBillGroup("BILLGROUP");
		client.setShare("% Share");
		
		return client;
	}

}
