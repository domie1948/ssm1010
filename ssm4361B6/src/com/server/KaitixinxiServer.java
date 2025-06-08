package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kaitixinxi;

public interface KaitixinxiServer {

  public int add(Kaitixinxi po);

  public int update(Kaitixinxi po);
  
  public int updatelb(Kaitixinxi po);
  
  public int delete(int id);

  public List<Kaitixinxi> getAll(Map<String,Object> map);
  public List<Kaitixinxi> getsykaitixinxi1(Map<String,Object> map);
  public List<Kaitixinxi> getsykaitixinxi2(Map<String,Object> map);
  public List<Kaitixinxi> getsykaitixinxi3(Map<String,Object> map);
  public Kaitixinxi quchongKaitixinxi(Map<String, Object> acount);

  public Kaitixinxi getById( int id);

  public List<Kaitixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kaitixinxi> select(Map<String, Object> map);
}
//	所有List
