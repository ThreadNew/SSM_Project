package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;

import org.hibernate.validator.constraints.NotBlank;

/**
   * @类 名： ReaderType
   * @功能描述： TODO 读者的类别，这个只有系统管理员才有的操作；该类别里包括了不同读者在图书馆里借书的限制
   * @作者信息： 陈强
   * @创建时间： 2018年4月18日上午10:25:36
   * @修改备注：
   */
@SuppressWarnings("serial")
public class ReaderType implements Serializable {
	private int rdType;//读者类别
	private String rdTypeName;//读者名称
	private int canLendQty;//可借书的数量
	private int canLendDay;//可借书的天数
	private int canContinueTimes;//可续借的次数
	private float punishRate;//罚款率
	private int dateValid;//证件的有效期
	
	@DecimalMax(value="20",message="{rdType_Int}")
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	@NotBlank(message="{rdTypeName_Message}")
	public String getRdTypeName() {
		return rdTypeName;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}

	@DecimalMax(value="20",message="{canLendQty_Message}")
	public int getCanLendQty() {
		return canLendQty;
	}
	public void setCanLendQty(int canLendQty) {
		this.canLendQty = canLendQty;
	}
	
	public int getCanLendDay() {
		return canLendDay;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	
	public int getCanContinueTimes() {
		return canContinueTimes;
	}
	public void setCanContinueTimes(int canContinueTimes) {
		this.canContinueTimes = canContinueTimes;
	}
	
	public float getPunishRate() {
		return punishRate;
	}
	public void setPunishRate(float punishRate) {
		this.punishRate = punishRate;
	}
	
	public int getDateValid() {
		return dateValid;
	}
	public void setDateValid(int dateValid) {
		this.dateValid = dateValid;
	}

}
