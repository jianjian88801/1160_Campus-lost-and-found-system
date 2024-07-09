package com.entity.model;

import com.entity.WupinguashiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品挂失
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinguashiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物品名称
     */
    private String wupinguashiName;


    /**
     * 物品类型
     */
    private Integer shiwuzhaolingTypes;


    /**
     * 物品状态
     */
    private Integer statusTypes;


    /**
     * 物品图片
     */
    private String wupinguashiPhoto;


    /**
     * 丢失时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wupinguashiTime;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 丢失地址
     */
    private String wupinguashiDizhi;


    /**
     * 详情
     */
    private String wupinguashiContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：物品名称
	 */
    public String getWupinguashiName() {
        return wupinguashiName;
    }


    /**
	 * 设置：物品名称
	 */
    public void setWupinguashiName(String wupinguashiName) {
        this.wupinguashiName = wupinguashiName;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getShiwuzhaolingTypes() {
        return shiwuzhaolingTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setShiwuzhaolingTypes(Integer shiwuzhaolingTypes) {
        this.shiwuzhaolingTypes = shiwuzhaolingTypes;
    }
    /**
	 * 获取：物品状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：物品状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：物品图片
	 */
    public String getWupinguashiPhoto() {
        return wupinguashiPhoto;
    }


    /**
	 * 设置：物品图片
	 */
    public void setWupinguashiPhoto(String wupinguashiPhoto) {
        this.wupinguashiPhoto = wupinguashiPhoto;
    }
    /**
	 * 获取：丢失时间
	 */
    public Date getWupinguashiTime() {
        return wupinguashiTime;
    }


    /**
	 * 设置：丢失时间
	 */
    public void setWupinguashiTime(Date wupinguashiTime) {
        this.wupinguashiTime = wupinguashiTime;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：丢失地址
	 */
    public String getWupinguashiDizhi() {
        return wupinguashiDizhi;
    }


    /**
	 * 设置：丢失地址
	 */
    public void setWupinguashiDizhi(String wupinguashiDizhi) {
        this.wupinguashiDizhi = wupinguashiDizhi;
    }
    /**
	 * 获取：详情
	 */
    public String getWupinguashiContent() {
        return wupinguashiContent;
    }


    /**
	 * 设置：详情
	 */
    public void setWupinguashiContent(String wupinguashiContent) {
        this.wupinguashiContent = wupinguashiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
