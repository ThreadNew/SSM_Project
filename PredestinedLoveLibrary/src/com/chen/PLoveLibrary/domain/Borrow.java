package com.chen.PLoveLibrary.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
   * @类 名： Borrow 
   * @功能描述： TODO 借阅图书的信息
   * @作者信息： 陈强
   * @创建时间： 2018年4月25日下午9:44:35
   * @修改备注：
   */
@SuppressWarnings("serial")
public class Borrow implements Serializable{
	private int borrowID;
	@NotBlank(message="不能为空")
	private String rdID;//读者序号
	@NotBlank(message="不能为空")
	private String bkID;//图书序号
	private int idContinueTimes;//续借的次数
	private Date idDateOut;//借书日期
	private Date idDateRetPlan;//应还日期
	private Date idDateRetAct;//实际还书日期
	private int idOverDay;//超期天数
	private float idOverMoney;//超期金额
	private float idPunishMoney;//罚款金额
	private String isHasReturn;//是否还书
	private String operatorLend;//借书操作员
	private String operatorRet;//还书操作员
	
	public int getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}
	public String getRdID() {
		return rdID;
	}
	public void setRdID(String rdID) {
		this.rdID = rdID;
	}
	public String getBkID() {
		return bkID;
	}
	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
	
	public int getIdContinueTimes() {
		return idContinueTimes;
	}
	public void setIdContinueTimes(int idContinueTimes) {
		this.idContinueTimes = idContinueTimes;
	}
	public Date getIdDateOut() {
		return idDateOut;
	}
	public void setIdDateOut(Date idDateOut) {
		this.idDateOut = idDateOut;
	}
	
	public Date getIdDateRetPlan() {
		return idDateRetPlan;
	}
	public void setIdDateRetPlan(Date idDateRetPlan) {
		this.idDateRetPlan = idDateRetPlan;
	}
	public Date getIdDateRetAct() {
		return idDateRetAct;
	}
	public void setIdDateRetAct(Date idDateRetAct) {
		this.idDateRetAct = idDateRetAct;
	}
	public int getIdOverDay() {
		return idOverDay;
	}
	public void setIdOverDay(int idOverDay) {
		this.idOverDay = idOverDay;
	}
	public float getIdOverMoney() {
		return idOverMoney;
	}
	public void setIdOverMoney(float idOverMoney) {
		this.idOverMoney = idOverMoney;
	}
	public float getIdPunishMoney() {
		return idPunishMoney;
	}
	public void setIdPunishMoney(float idPunishMoney) {
		this.idPunishMoney = idPunishMoney;
	}
	public String getIsHasReturn() {
		return isHasReturn;
	}
	public void setIsHasReturn(String isHasReturn) {
		this.isHasReturn = isHasReturn;
	}
	public String getOperatorLend() {
		return operatorLend;
	}
	public void setOperatorLend(String operatorLend) {
		this.operatorLend = operatorLend;
	}
	public String getOperatorRet() {
		return operatorRet;
	}
	public void setOperatorRet(String operatorRet) {
		this.operatorRet = operatorRet;
	}
	

}
