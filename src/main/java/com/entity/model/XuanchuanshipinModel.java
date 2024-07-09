package com.entity.model;

import com.entity.XuanchuanshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宣传视频
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuanchuanshipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 视频标题
     */
    private String xuanchuanshipinName;


    /**
     * 视频封面
     */
    private String xuanchuanshipinPhoto;


    /**
     * 视频
     */
    private String xuanchuanshipinVideo;


    /**
     * 视频类型
     */
    private Integer xuanchuanshipinTypes;


    /**
     * 详情
     */
    private String xuanchuanshipinContent;


    /**
     * 创建时间
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
	 * 获取：视频标题
	 */
    public String getXuanchuanshipinName() {
        return xuanchuanshipinName;
    }


    /**
	 * 设置：视频标题
	 */
    public void setXuanchuanshipinName(String xuanchuanshipinName) {
        this.xuanchuanshipinName = xuanchuanshipinName;
    }
    /**
	 * 获取：视频封面
	 */
    public String getXuanchuanshipinPhoto() {
        return xuanchuanshipinPhoto;
    }


    /**
	 * 设置：视频封面
	 */
    public void setXuanchuanshipinPhoto(String xuanchuanshipinPhoto) {
        this.xuanchuanshipinPhoto = xuanchuanshipinPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getXuanchuanshipinVideo() {
        return xuanchuanshipinVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setXuanchuanshipinVideo(String xuanchuanshipinVideo) {
        this.xuanchuanshipinVideo = xuanchuanshipinVideo;
    }
    /**
	 * 获取：视频类型
	 */
    public Integer getXuanchuanshipinTypes() {
        return xuanchuanshipinTypes;
    }


    /**
	 * 设置：视频类型
	 */
    public void setXuanchuanshipinTypes(Integer xuanchuanshipinTypes) {
        this.xuanchuanshipinTypes = xuanchuanshipinTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getXuanchuanshipinContent() {
        return xuanchuanshipinContent;
    }


    /**
	 * 设置：详情
	 */
    public void setXuanchuanshipinContent(String xuanchuanshipinContent) {
        this.xuanchuanshipinContent = xuanchuanshipinContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
