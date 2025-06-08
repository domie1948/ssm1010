package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TongzhiMapper;
import com.entity.Tongzhi;
import com.server.TongzhiServer;
@Service
public class TongzhiServerImpi implements TongzhiServer {
   @Resource
   private TongzhiMapper gdao;
	@Override
	public int add(Tongzhi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tongzhi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tongzhi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tongzhi> getsytongzhi1(Map<String, Object> map) {
		return gdao.getsytongzhi1(map);
	}
	public List<Tongzhi> getsytongzhi2(Map<String, Object> map) {
		return gdao.getsytongzhi2(map);
	}
	public List<Tongzhi> getsytongzhi3(Map<String, Object> map) {
		return gdao.getsytongzhi3(map);
	}
	
	@Override
	public Tongzhi quchongTongzhi(Map<String, Object> account) {
		return gdao.quchongTongzhi(account);
	}

	@Override
	public List<Tongzhi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tongzhi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tongzhi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

