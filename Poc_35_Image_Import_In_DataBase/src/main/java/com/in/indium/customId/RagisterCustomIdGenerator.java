package com.in.indium.customId;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RagisterCustomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		int i=0;
		String prefix="INDIUM-TRANEE";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhssSS");
		i=++i;
		String date=sdf.format(new Date());
	     return prefix+date;
	}

}
