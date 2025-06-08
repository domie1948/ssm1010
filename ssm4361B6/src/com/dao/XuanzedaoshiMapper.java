package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xuanzedaoshi;

public interface XuanzedaoshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xuanzedaoshi record);

    int insertSelective(Xuanzedaoshi record);

    Xuanzedaoshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xuanzedaoshi record);
	
    int updateByPrimaryKey(Xuanzedaoshi record);
	public Xuanzedaoshi quchongXuanzedaoshi(Map<String, Object> xuesheng);
	public List<Xuanzedaoshi> getAll(Map<String, Object> map);
	public List<Xuanzedaoshi> getsyxuanzedaoshi1(Map<String, Object> map);
	public List<Xuanzedaoshi> getsyxuanzedaoshi3(Map<String, Object> map);
	public List<Xuanzedaoshi> getsyxuanzedaoshi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xuanzedaoshi> getByPage(Map<String, Object> map);
	public List<Xuanzedaoshi> select(Map<String, Object> map);
//	所有List
}

