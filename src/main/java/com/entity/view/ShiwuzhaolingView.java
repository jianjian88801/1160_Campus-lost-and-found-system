package com.entity.view;

import com.entity.ShiwuzhaolingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 失物招领
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shiwuzhaoling")
public class ShiwuzhaolingView extends ShiwuzhaolingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 物品类型的值
		*/
		private String shiwuzhaolingValue;
		/**
		* 物品状态的值
		*/
		private String statusValue;



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

	public ShiwuzhaolingView() {

	}

	public ShiwuzhaolingView(ShiwuzhaolingEntity shiwuzhaolingEntity) {
		try {
			BeanUtils.copyProperties(this, shiwuzhaolingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
