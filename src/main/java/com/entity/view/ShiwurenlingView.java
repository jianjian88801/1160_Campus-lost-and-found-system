package com.entity.view;

import com.entity.ShiwurenlingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 失物认领
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shiwurenling")
public class ShiwurenlingView extends ShiwurenlingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核的值
		*/
		private String yesnoValue;



		//级联表 shiwuzhaoling
			/**
			* 失物编号
			*/
			private String shiwuzhaolingUuidNumber;
			/**
			* 物品名称
			*/
			private String shiwuzhaolingName;
			/**
			* 物品类型
			*/
			private Integer shiwuzhaolingTypes;
				/**
				* 物品类型的值
				*/
				private String shiwuzhaolingValue;
			/**
			* 物品状态
			*/
			private Integer statusTypes;
				/**
				* 物品状态的值
				*/
				private String statusValue;
			/**
			* 物品图片
			*/
			private String shiwuzhaolingPhoto;
			/**
			* 拾遗时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date shiwuzhaolingTime;
			/**
			* 拾遗地址
			*/
			private String shiwuzhaolingDizhi;
			/**
			* 详情
			*/
			private String shiwuzhaolingContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ShiwurenlingView() {

	}

	public ShiwurenlingView(ShiwurenlingEntity shiwurenlingEntity) {
		try {
			BeanUtils.copyProperties(this, shiwurenlingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核的值
			*/
			public String getYesnoValue() {
				return yesnoValue;
			}
			/**
			* 设置： 审核的值
			*/
			public void setYesnoValue(String yesnoValue) {
				this.yesnoValue = yesnoValue;
			}
















				//级联表的get和set shiwuzhaoling
					/**
					* 获取： 失物编号
					*/
					public String getShiwuzhaolingUuidNumber() {
						return shiwuzhaolingUuidNumber;
					}
					/**
					* 设置： 失物编号
					*/
					public void setShiwuzhaolingUuidNumber(String shiwuzhaolingUuidNumber) {
						this.shiwuzhaolingUuidNumber = shiwuzhaolingUuidNumber;
					}
					/**
					* 获取： 物品名称
					*/
					public String getShiwuzhaolingName() {
						return shiwuzhaolingName;
					}
					/**
					* 设置： 物品名称
					*/
					public void setShiwuzhaolingName(String shiwuzhaolingName) {
						this.shiwuzhaolingName = shiwuzhaolingName;
					}
					/**
					* 获取： 物品类型
					*/
					public Integer getShiwuzhaolingTypes() {
						return shiwuzhaolingTypes;
					}
					/**
					* 设置： 物品类型
					*/
					public void setShiwuzhaolingTypes(Integer shiwuzhaolingTypes) {
						this.shiwuzhaolingTypes = shiwuzhaolingTypes;
					}


						/**
						* 获取： 物品类型的值
						*/
						public String getShiwuzhaolingValue() {
							return shiwuzhaolingValue;
						}
						/**
						* 设置： 物品类型的值
						*/
						public void setShiwuzhaolingValue(String shiwuzhaolingValue) {
							this.shiwuzhaolingValue = shiwuzhaolingValue;
						}
					/**
					* 获取： 物品状态
					*/
					public Integer getStatusTypes() {
						return statusTypes;
					}
					/**
					* 设置： 物品状态
					*/
					public void setStatusTypes(Integer statusTypes) {
						this.statusTypes = statusTypes;
					}


						/**
						* 获取： 物品状态的值
						*/
						public String getStatusValue() {
							return statusValue;
						}
						/**
						* 设置： 物品状态的值
						*/
						public void setStatusValue(String statusValue) {
							this.statusValue = statusValue;
						}
					/**
					* 获取： 物品图片
					*/
					public String getShiwuzhaolingPhoto() {
						return shiwuzhaolingPhoto;
					}
					/**
					* 设置： 物品图片
					*/
					public void setShiwuzhaolingPhoto(String shiwuzhaolingPhoto) {
						this.shiwuzhaolingPhoto = shiwuzhaolingPhoto;
					}
					/**
					* 获取： 拾遗时间
					*/
					public Date getShiwuzhaolingTime() {
						return shiwuzhaolingTime;
					}
					/**
					* 设置： 拾遗时间
					*/
					public void setShiwuzhaolingTime(Date shiwuzhaolingTime) {
						this.shiwuzhaolingTime = shiwuzhaolingTime;
					}
					/**
					* 获取： 拾遗地址
					*/
					public String getShiwuzhaolingDizhi() {
						return shiwuzhaolingDizhi;
					}
					/**
					* 设置： 拾遗地址
					*/
					public void setShiwuzhaolingDizhi(String shiwuzhaolingDizhi) {
						this.shiwuzhaolingDizhi = shiwuzhaolingDizhi;
					}
					/**
					* 获取： 详情
					*/
					public String getShiwuzhaolingContent() {
						return shiwuzhaolingContent;
					}
					/**
					* 设置： 详情
					*/
					public void setShiwuzhaolingContent(String shiwuzhaolingContent) {
						this.shiwuzhaolingContent = shiwuzhaolingContent;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}
