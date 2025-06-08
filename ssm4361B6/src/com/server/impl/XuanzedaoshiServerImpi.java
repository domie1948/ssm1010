package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XuanzedaoshiMapper;
import com.entity.Xuanzedaoshi;
import com.server.XuanzedaoshiServer;
@Service
public class XuanzedaoshiServerImpi implements XuanzedaoshiServer {
   @Resource
   private XuanzedaoshiMapper gdao;
	@Override
	public int add(Xuanzedaoshi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xuanzedaoshi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xuanzedaoshi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xuanzedaoshi> getsyxuanzedaoshi1(Map<String, Object> map) {
		return gdao.getsyxuanzedaoshi1(map);
	}
	public List<Xuanzedaoshi> getsyxuanzedaoshi2(Map<String, Object> map) {
		return gdao.getsyxuanzedaoshi2(map);
	}
	public List<Xuanzedaoshi> getsyxuanzedaoshi3(Map<String, Object> map) {
		return gdao.getsyxuanzedaoshi3(map);
	}
	
	@Override
	public Xuanzedaoshi quchongXuanzedaoshi(Map<String, Object> account) {
		return gdao.quchongXuanzedaoshi(account);
	}

	@Override
	public List<Xuanzedaoshi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xuanzedaoshi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xuanzedaoshi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

