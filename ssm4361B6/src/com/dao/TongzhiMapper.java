package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tongzhi;

public interface TongzhiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tongzhi record);

    int insertSelective(Tongzhi record);

    Tongzhi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tongzhi record);
	
    int updateByPrimaryKey(Tongzhi record);
	public Tongzhi quchongTongzhi(Map<String, Object> faburen);
	public List<Tongzhi> getAll(Map<String, Object> map);
	public List<Tongzhi> getsytongzhi1(Map<String, Object> map);
	public List<Tongzhi> getsytongzhi3(Map<String, Object> map);
	public List<Tongzhi> getsytongzhi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tongzhi> getByPage(Map<String, Object> map);
	public List<Tongzhi> select(Map<String, Object> map);
//	所有List
}

