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
 * 公告
 *
 * @author 
 * @email
 */
@TableName("news")
public class NewsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NewsEntity() {

	}

	public NewsEntity(T t) {
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
     * 公告名称
     */
    @TableField(value = "news_name")

    private String newsName;


    /**
     * 公告类型
     */
    @TableField(value = "news_types")

    private Integer newsTypes;


    /**
     * 公告图片
     */
    @TableField(value = "news_photo")

    private String newsPhoto;


    /**
     * 公告时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 公告详情
     */
    @TableField(value = "news_content")

    private String newsContent;


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
	 * 设置：公告名称
	 */
    public String getNewsName() {
        return newsName;
    }


    /**
	 * 获取：公告名称
	 */

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }
    /**
	 * 设置：公告类型
	 */
    public Integer getNewsTypes() {
        return newsTypes;
    }


    /**
	 * 获取：公告类型
	 */

    public void setNewsTypes(Integer newsTypes) {
        this.newsTypes = newsTypes;
    }
    /**
	 * 设置：公告图片
	 */
    public String getNewsPhoto() {
        return newsPhoto;
    }


    /**
	 * 获取：公告图片
	 */

    public void setNewsPhoto(String newsPhoto) {
        this.newsPhoto = newsPhoto;
    }
    /**
	 * 设置：公告时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：公告时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：公告详情
	 */
    public String getNewsContent() {
        return newsContent;
    }


    /**
	 * 获取：公告详情
	 */

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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
        return "News{" +
            "id=" + id +
            ", newsName=" + newsName +
            ", newsTypes=" + newsTypes +
            ", newsPhoto=" + newsPhoto +
            ", insertTime=" + insertTime +
            ", newsContent=" + newsContent +
            ", createTime=" + createTime +
        "}";
    }
}
