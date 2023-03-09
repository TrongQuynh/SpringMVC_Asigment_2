package com.onlineclass.sysadmin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.onlineclass.sysadmin.entity.CommonCode;
import com.onlineclass.sysadmin.util.MyBatisUtil;

@Repository
public class CommonCodeDAOImpl implements CommonCodeDAO {

	@Override
	public List<CommonCode> getAllCommonCodes() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<CommonCode> statusList = session.selectList("getAllCommonCode");
		session.commit();
		session.close();
		return statusList;
	}

}
