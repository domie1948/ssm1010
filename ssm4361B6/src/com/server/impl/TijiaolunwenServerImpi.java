package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TijiaolunwenMapper;
import com.entity.Tijiaolunwen;
import com.server.TijiaolunwenServer;
@Service
public class TijiaolunwenServerImpi implements TijiaolunwenServer {
   @Resource
   private TijiaolunwenMapper gdao;
	@Override
	public int add(Tijiaolunwen po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tijiaolunwen po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Tijiaolunwen po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tijiaolunwen> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tijiaolunwen> getsytijiaolunwen1(Map<String, Object> map) {
		return gdao.getsytijiaolunwen1(map);
	}
	public List<Tijiaolunwen> getsytijiaolunwen2(Map<String, Object> map) {
		return gdao.getsytijiaolunwen2(map);
	}
	public List<Tijiaolunwen> getsytijiaolunwen3(Map<String, Object> map) {
		return gdao.getsytijiaolunwen3(map);
	}
	
	@Override
	public Tijiaolunwen quchongTijiaolunwen(Map<String, Object> account) {
		return gdao.quchongTijiaolunwen(account);
	}

	@Override
	public List<Tijiaolunwen> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tijiaolunwen> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tijiaolunwen getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

