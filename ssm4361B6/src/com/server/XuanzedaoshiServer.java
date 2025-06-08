package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xuanzedaoshi;

public interface XuanzedaoshiServer {

  public int add(Xuanzedaoshi po);

  public int update(Xuanzedaoshi po);
  
  
  
  public int delete(int id);

  public List<Xuanzedaoshi> getAll(Map<String,Object> map);
  public List<Xuanzedaoshi> getsyxuanzedaoshi1(Map<String,Object> map);
  public List<Xuanzedaoshi> getsyxuanzedaoshi2(Map<String,Object> map);
  public List<Xuanzedaoshi> getsyxuanzedaoshi3(Map<String,Object> map);
  public Xuanzedaoshi quchongXuanzedaoshi(Map<String, Object> acount);

  public Xuanzedaoshi getById( int id);

  public List<Xuanzedaoshi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xuanzedaoshi> select(Map<String, Object> map);
}
//	所有List
