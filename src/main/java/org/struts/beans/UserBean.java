package org.struts.beans;

import java.sql.Date;

public class UserBean {
	
	
	private int id;
	private String username;
	private String carnumber;
	private String enginenumber;
	private String framenumber;
	private  Date registerdate;
	private String cartype;
	private String carlength;
    private String insurance;
    private String insurancefirm;
   
	private Date cutoffdate;
    private Date nextservicedate;
    private Date licensedate;
    private Date drivelicensedate;
    private String phone;
    private String cutoffstatus;
    private String nextservicestatus;
    private String licensestatus;
    private String drivelicensestatus;
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getEnginenumber() {
		return enginenumber;
	}
	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}
	public String getFramenumber() {
		return framenumber;
	}
	public void setFramenumber(String framenumber) {
		this.framenumber = framenumber;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarlength() {
		return carlength;
	}
	public void setCarlength(String carlength) {
		this.carlength = carlength;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	 public String getInsurancefirm() {
			return insurancefirm;
		}
		public void setInsurancefirm(String insurancefirm) {
			this.insurancefirm = insurancefirm;
		}
	public Date getCutoffdate() {
		return cutoffdate;
	}
	public void setCutoffdate(Date cutoffdate) {
		this.cutoffdate = cutoffdate;
	}
	public Date getNextservicedate() {
		return nextservicedate;
	}
	public void setNextservicedate(Date nextservicedate) {
		this.nextservicedate = nextservicedate;
	}
	public Date getLicensedate() {
		return licensedate;
	}
	public void setLicensedate(Date licensedate) {
		this.licensedate = licensedate;
	}
	public Date getDrivelicensedate() {
		return drivelicensedate;
	}
	public void setDrivelicensedate(Date drivelicensedate) {
		this.drivelicensedate = drivelicensedate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCutoffstatus() {
		return cutoffstatus;
	}
	public void setCutoffstatus(String cutoffstatus) {
		this.cutoffstatus = cutoffstatus;
	}
	public String getNextservicestatus() {
		return nextservicestatus;
	}
	public void setNextservicestatus(String nextservicestatus) {
		this.nextservicestatus = nextservicestatus;
	}
	public String getLicensestatus() {
		return licensestatus;
	}
	public void setLicensestatus(String licensestatus) {
		this.licensestatus = licensestatus;
	}
	public String getDrivelicensestatus() {
		return drivelicensestatus;
	}
	public void setDrivelicensestatus(String drivelicensestatus) {
		this.drivelicensestatus = drivelicensestatus;
	}

}
