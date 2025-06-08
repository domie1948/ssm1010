package com.entity;

public class Tongzhi {
    private Integer id;
	private String faburen;	private String tongzhineirong;	private String jieshouren;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }	public String getTongzhineirong() {
        return tongzhineirong;
    }
    public void setTongzhineirong(String tongzhineirong) {
        this.tongzhineirong = tongzhineirong == null ? null : tongzhineirong.trim();
    }	public String getJieshouren() {
        return jieshouren;
    }
    public void setJieshouren(String jieshouren) {
        this.jieshouren = jieshouren == null ? null : jieshouren.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
