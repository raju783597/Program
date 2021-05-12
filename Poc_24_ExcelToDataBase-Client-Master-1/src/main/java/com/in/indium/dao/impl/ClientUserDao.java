package com.in.indium.dao.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.in.indium.dao.IClientUser;
import com.in.indium.model.ClientUser;
@Component
public class ClientUserDao implements IClientUser {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int[] saveClient(List<ClientUser> client) {
		String sql="INSERT INTO client_user Values(?,?,?,?,?,?,?,?,?,?)";
		List<Object[]>args=client.stream().map(c->new Object[] {
				
				c.getClient(),
				c.getName(),
				c.getCliType(),
				c.getINameType(),
				c.getAccType(),
				c.getDate(),
				c.getSchName(),
				c.getRegMgName(),
				c.getBillGroup(),
				c.getShare()
		}).collect(Collectors.toList());
		int [] arr=jt.batchUpdate(sql,args);
		
		return arr;
	}

}
