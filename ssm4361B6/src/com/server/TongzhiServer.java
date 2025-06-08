package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tongzhi;

public interface TongzhiServer {

  public int add(Tongzhi po);

  public int update(Tongzhi po);
  
  
  
  public int delete(int id);

  public List<Tongzhi> getAll(Map<String,Object> map);
  public List<Tongzhi> getsytongzhi1(Map<String,Object> map);
  public List<Tongzhi> getsytongzhi2(Map<String,Object> map);
  public List<Tongzhi> getsytongzhi3(Map<String,Object> map);
  public Tongzhi quchongTongzhi(Map<String, Object> acount);

  public Tongzhi getById( int id);

  public List<Tongzhi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tongzhi> select(Map<String, Object> map);
}
//	所有List
