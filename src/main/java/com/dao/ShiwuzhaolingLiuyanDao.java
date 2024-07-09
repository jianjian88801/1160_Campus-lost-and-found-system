package com.dao;

import com.entity.ShiwuzhaolingLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwuzhaolingLiuyanView;

/**
 * 失物招领留言 Dao 接口
 *
 * @author 
 */
public interface ShiwuzhaolingLiuyanDao extends BaseMapper<ShiwuzhaolingLiuyanEntity> {

   List<ShiwuzhaolingLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
