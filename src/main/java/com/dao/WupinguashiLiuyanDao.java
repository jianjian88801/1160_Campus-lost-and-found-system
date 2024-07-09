package com.dao;

import com.entity.WupinguashiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinguashiLiuyanView;

/**
 * 物品挂失留言 Dao 接口
 *
 * @author 
 */
public interface WupinguashiLiuyanDao extends BaseMapper<WupinguashiLiuyanEntity> {

   List<WupinguashiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
