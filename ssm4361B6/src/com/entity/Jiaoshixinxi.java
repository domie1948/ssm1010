package com.entity;

public class Jiaoshixinxi {
    private Integer id;
	private String gonghao;	private String mima;	private String xingming;	private String xingbie;	private String nianling;	private String lianxifangshi;	private String zhaopian;	private String beizhu;	private String kexuanrenshu;	private String yixuanrenshu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao == null ? null : gonghao.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }	public String getNianling() {
        return nianling;
    }
    public void setNianling(String nianling) {
        this.nianling = nianling == null ? null : nianling.trim();
    }	public String getLianxifangshi() {
        return lianxifangshi;
    }
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? null : lianxifangshi.trim();
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian == null ? null : zhaopian.trim();
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }	public String getKexuanrenshu() {
        return kexuanrenshu;
    }
    public void setKexuanrenshu(String kexuanrenshu) {
        this.kexuanrenshu = kexuanrenshu == null ? null : kexuanrenshu.trim();
    }	public String getYixuanrenshu() {
        return yixuanrenshu;
    }
    public void setYixuanrenshu(String yixuanrenshu) {
        this.yixuanrenshu = yixuanrenshu == null ? null : yixuanrenshu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
