package com.entity;

public class Gonggaoxinxi {
    private Integer id;
	private String gonggaomingcheng;	private String neirong;	private String fabushijian;	private String faburen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonggaomingcheng() {
        return gonggaomingcheng;
    }
    public void setGonggaomingcheng(String gonggaomingcheng) {
        this.gonggaomingcheng = gonggaomingcheng == null ? null : gonggaomingcheng.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getFabushijian() {
        return fabushijian;
    }
    public void setFabushijian(String fabushijian) {
        this.fabushijian = fabushijian == null ? null : fabushijian.trim();
    }	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
