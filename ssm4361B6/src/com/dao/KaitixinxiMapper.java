package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kaitixinxi;

public interface KaitixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kaitixinxi record);

    int insertSelective(Kaitixinxi record);

    Kaitixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kaitixinxi record);
	int updateByPrimaryKeySelectivelb(Kaitixinxi record);
    int updateByPrimaryKey(Kaitixinxi record);
	public Kaitixinxi quchongKaitixinxi(Map<String, Object> xuesheng);
	public List<Kaitixinxi> getAll(Map<String, Object> map);
	public List<Kaitixinxi> getsykaitixinxi1(Map<String, Object> map);
	public List<Kaitixinxi> getsykaitixinxi3(Map<String, Object> map);
	public List<Kaitixinxi> getsykaitixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kaitixinxi> getByPage(Map<String, Object> map);
	public List<Kaitixinxi> select(Map<String, Object> map);
//	所有List
}

