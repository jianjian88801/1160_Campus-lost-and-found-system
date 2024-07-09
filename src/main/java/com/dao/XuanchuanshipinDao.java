package com.dao;

import com.entity.XuanchuanshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanchuanshipinView;

/**
 * 宣传视频 Dao 接口
 *
 * @author 
 */
public interface XuanchuanshipinDao extends BaseMapper<XuanchuanshipinEntity> {

   List<XuanchuanshipinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
