package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 物品挂失留言
 *
 * @author 
 * @email
 */
@TableName("wupinguashi_liuyan")
public class WupinguashiLiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WupinguashiLiuyanEntity() {

	}

	public WupinguashiLiuyanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 物品
     */
    @TableField(value = "wupinguashi_id")

    private Integer wupinguashiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 留言内容
     */
    @TableField(value = "wupinguashi_liuyan_text")

    private String wupinguashiLiuyanText;


    /**
     * 回复内容
     */
    @TableField(value = "reply_text")

    private String replyText;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：物品
	 */
    public Integer getWupinguashiId() {
        return wupinguashiId;
    }


    /**
	 * 获取：物品
	 */

    public void setWupinguashiId(Integer wupinguashiId) {
        this.wupinguashiId = wupinguashiId;
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
	 * 设置：留言内容
	 */
    public String getWupinguashiLiuyanText() {
        return wupinguashiLiuyanText;
    }


    /**
	 * 获取：留言内容
	 */

    public void setWupinguashiLiuyanText(String wupinguashiLiuyanText) {
        this.wupinguashiLiuyanText = wupinguashiLiuyanText;
    }
    /**
	 * 设置：回复内容
	 */
    public String getReplyText() {
        return replyText;
    }


    /**
	 * 获取：回复内容
	 */

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WupinguashiLiuyan{" +
            "id=" + id +
            ", wupinguashiId=" + wupinguashiId +
            ", yonghuId=" + yonghuId +
            ", wupinguashiLiuyanText=" + wupinguashiLiuyanText +
            ", replyText=" + replyText +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
