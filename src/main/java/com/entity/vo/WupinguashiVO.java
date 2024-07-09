package com.entity.vo;

import com.entity.WupinguashiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品挂失
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wupinguashi")
public class WupinguashiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物品名称
     */

    @TableField(value = "wupinguashi_name")
    private String wupinguashiName;


    /**
     * 物品类型
     */

    @TableField(value = "shiwuzhaoling_types")
    private Integer shiwuzhaolingTypes;


    /**
     * 物品状态
     */

    @TableField(value = "status_types")
    private Integer statusTypes;


    /**
     * 物品图片
     */

    @TableField(value = "wupinguashi_photo")
    private String wupinguashiPhoto;


    /**
     * 丢失时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wupinguashi_time")
    private Date wupinguashiTime;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 丢失地址
     */

    @TableField(value = "wupinguashi_dizhi")
    private String wupinguashiDizhi;


    /**
     * 详情
     */

    @TableField(value = "wupinguashi_content")
    private String wupinguashiContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：物品名称
	 */
    public String getWupinguashiName() {
        return wupinguashiName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWupinguashiName(String wupinguashiName) {
        this.wupinguashiName = wupinguashiName;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getShiwuzhaolingTypes() {
        return shiwuzhaolingTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setShiwuzhaolingTypes(Integer shiwuzhaolingTypes) {
        this.shiwuzhaolingTypes = shiwuzhaolingTypes;
    }
    /**
	 * 设置：物品状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：物品状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 设置：物品图片
	 */
    public String getWupinguashiPhoto() {
        return wupinguashiPhoto;
    }


    /**
	 * 获取：物品图片
	 */

    public void setWupinguashiPhoto(String wupinguashiPhoto) {
        this.wupinguashiPhoto = wupinguashiPhoto;
    }
    /**
	 * 设置：丢失时间
	 */
    public Date getWupinguashiTime() {
        return wupinguashiTime;
    }


    /**
	 * 获取：丢失时间
	 */

    public void setWupinguashiTime(Date wupinguashiTime) {
        this.wupinguashiTime = wupinguashiTime;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：丢失地址
	 */
    public String getWupinguashiDizhi() {
        return wupinguashiDizhi;
    }


    /**
	 * 获取：丢失地址
	 */

    public void setWupinguashiDizhi(String wupinguashiDizhi) {
        this.wupinguashiDizhi = wupinguashiDizhi;
    }
    /**
	 * 设置：详情
	 */
    public String getWupinguashiContent() {
        return wupinguashiContent;
    }


    /**
	 * 获取：详情
	 */

    public void setWupinguashiContent(String wupinguashiContent) {
        this.wupinguashiContent = wupinguashiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
