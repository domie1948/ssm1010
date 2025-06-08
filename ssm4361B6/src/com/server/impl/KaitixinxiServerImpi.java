package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KaitixinxiMapper;
import com.entity.Kaitixinxi;
import com.server.KaitixinxiServer;
@Service
public class KaitixinxiServerImpi implements KaitixinxiServer {
   @Resource
   private KaitixinxiMapper gdao;
	@Override
	public int add(Kaitixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kaitixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Kaitixinxi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kaitixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kaitixinxi> getsykaitixinxi1(Map<String, Object> map) {
		return gdao.getsykaitixinxi1(map);
	}
	public List<Kaitixinxi> getsykaitixinxi2(Map<String, Object> map) {
		return gdao.getsykaitixinxi2(map);
	}
	public List<Kaitixinxi> getsykaitixinxi3(Map<String, Object> map) {
		return gdao.getsykaitixinxi3(map);
	}
	
	@Override
	public Kaitixinxi quchongKaitixinxi(Map<String, Object> account) {
		return gdao.quchongKaitixinxi(account);
	}

	@Override
	public List<Kaitixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kaitixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kaitixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

