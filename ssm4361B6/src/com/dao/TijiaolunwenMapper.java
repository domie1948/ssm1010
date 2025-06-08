package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tijiaolunwen;

public interface TijiaolunwenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tijiaolunwen record);

    int insertSelective(Tijiaolunwen record);

    Tijiaolunwen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tijiaolunwen record);
	int updateByPrimaryKeySelectivelb(Tijiaolunwen record);
    int updateByPrimaryKey(Tijiaolunwen record);
	public Tijiaolunwen quchongTijiaolunwen(Map<String, Object> gonghao);
	public List<Tijiaolunwen> getAll(Map<String, Object> map);
	public List<Tijiaolunwen> getsytijiaolunwen1(Map<String, Object> map);
	public List<Tijiaolunwen> getsytijiaolunwen3(Map<String, Object> map);
	public List<Tijiaolunwen> getsytijiaolunwen2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tijiaolunwen> getByPage(Map<String, Object> map);
	public List<Tijiaolunwen> select(Map<String, Object> map);
//	所有List
}

