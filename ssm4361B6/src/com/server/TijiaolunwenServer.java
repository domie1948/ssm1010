package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tijiaolunwen;

public interface TijiaolunwenServer {

  public int add(Tijiaolunwen po);

  public int update(Tijiaolunwen po);
  
  public int updatelb(Tijiaolunwen po);
  
  public int delete(int id);

  public List<Tijiaolunwen> getAll(Map<String,Object> map);
  public List<Tijiaolunwen> getsytijiaolunwen1(Map<String,Object> map);
  public List<Tijiaolunwen> getsytijiaolunwen2(Map<String,Object> map);
  public List<Tijiaolunwen> getsytijiaolunwen3(Map<String,Object> map);
  public Tijiaolunwen quchongTijiaolunwen(Map<String, Object> acount);

  public Tijiaolunwen getById( int id);

  public List<Tijiaolunwen> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tijiaolunwen> select(Map<String, Object> map);
}
//	所有List
