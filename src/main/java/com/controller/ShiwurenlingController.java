
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 失物认领
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shiwurenling")
public class ShiwurenlingController {
    private static final Logger logger = LoggerFactory.getLogger(ShiwurenlingController.class);

    @Autowired
    private ShiwurenlingService shiwurenlingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShiwuzhaolingService shiwuzhaolingService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shiwurenlingService.queryPage(params);

        //字典表数据转换
        List<ShiwurenlingView> list =(List<ShiwurenlingView>)page.getList();
        for(ShiwurenlingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShiwurenlingEntity shiwurenling = shiwurenlingService.selectById(id);
        if(shiwurenling !=null){
            //entity转view
            ShiwurenlingView view = new ShiwurenlingView();
            BeanUtils.copyProperties( shiwurenling , view );//把实体数据重构到view中

                //级联表
                ShiwuzhaolingEntity shiwuzhaoling = shiwuzhaolingService.selectById(shiwurenling.getShiwuzhaolingId());
                if(shiwuzhaoling != null){
                    BeanUtils.copyProperties( shiwuzhaoling , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShiwuzhaolingId(shiwuzhaoling.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shiwurenling.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwurenlingEntity shiwurenling, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shiwurenling:{}",this.getClass().getName(),shiwurenling.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            shiwurenling.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShiwurenlingEntity> queryWrapper = new EntityWrapper<ShiwurenlingEntity>()
            .eq("shiwuzhaoling_id", shiwurenling.getShiwuzhaolingId())
            .eq("yonghu_id", shiwurenling.getYonghuId())
            .eq("yesno_types", shiwurenling.getYesnoTypes())
            .eq("shiwurenling_text", shiwurenling.getShiwurenlingText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiwurenlingEntity shiwurenlingEntity = shiwurenlingService.selectOne(queryWrapper);
        if(shiwurenlingEntity==null){
            shiwurenling.setInsertTime(new Date());
            shiwurenling.setCreateTime(new Date());
            shiwurenlingService.insert(shiwurenling);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiwurenlingEntity shiwurenling, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shiwurenling:{}",this.getClass().getName(),shiwurenling.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            shiwurenling.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShiwurenlingEntity> queryWrapper = new EntityWrapper<ShiwurenlingEntity>()
            .notIn("id",shiwurenling.getId())
            .andNew()
            .eq("shiwuzhaoling_id", shiwurenling.getShiwuzhaolingId())
            .eq("yonghu_id", shiwurenling.getYonghuId())
            .eq("yesno_types", shiwurenling.getYesnoTypes())
            .eq("shiwurenling_text", shiwurenling.getShiwurenlingText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiwurenlingEntity shiwurenlingEntity = shiwurenlingService.selectOne(queryWrapper);
        if(shiwurenlingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shiwurenling.set
            //  }
            shiwurenlingService.updateById(shiwurenling);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shiwurenlingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShiwurenlingEntity> shiwurenlingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShiwurenlingEntity shiwurenlingEntity = new ShiwurenlingEntity();
//                            shiwurenlingEntity.setShiwuzhaolingId(Integer.valueOf(data.get(0)));   //失物id 要改的
//                            shiwurenlingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //认领用户 要改的
//                            shiwurenlingEntity.setYesnoTypes(Integer.valueOf(data.get(0)));   //审核 要改的
//                            shiwurenlingEntity.setShiwurenlingText(data.get(0));                    //详情 要改的
//                            shiwurenlingEntity.setInsertTime(date);//时间
//                            shiwurenlingEntity.setCreateTime(date);//时间
                            shiwurenlingList.add(shiwurenlingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shiwurenlingService.insertBatch(shiwurenlingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
     * 审核
     */
    @RequestMapping("/quedingshenhe")
    public R quedingshenhe(@RequestBody ShiwurenlingEntity shiwurenling, HttpServletRequest request){
        if(shiwurenling.getYesnoTypes() == 2){
            ShiwuzhaolingEntity shiwuzhaolingEntity = new ShiwuzhaolingEntity();
            shiwuzhaolingEntity.setId(shiwurenling.getShiwuzhaolingId());
            shiwuzhaolingEntity.setStatusTypes(2);
            boolean b = shiwuzhaolingService.updateById(shiwuzhaolingEntity);
            if(!b){
                return R.error();
            }
        }
        boolean b = shiwurenlingService.updateById(shiwurenling);
        if(!b){
            return R.error();
        }
        return R.ok();
    }


    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shiwurenlingService.queryPage(params);

        //字典表数据转换
        List<ShiwurenlingView> list =(List<ShiwurenlingView>)page.getList();
        for(ShiwurenlingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShiwurenlingEntity shiwurenling = shiwurenlingService.selectById(id);
            if(shiwurenling !=null){


                //entity转view
                ShiwurenlingView view = new ShiwurenlingView();
                BeanUtils.copyProperties( shiwurenling , view );//把实体数据重构到view中

                //级联表
                    ShiwuzhaolingEntity shiwuzhaoling = shiwuzhaolingService.selectById(shiwurenling.getShiwuzhaolingId());
                if(shiwuzhaoling != null){
                    BeanUtils.copyProperties( shiwuzhaoling , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShiwuzhaolingId(shiwuzhaoling.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shiwurenling.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwurenlingEntity shiwurenling, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shiwurenling:{}",this.getClass().getName(),shiwurenling.toString());
        Wrapper<ShiwurenlingEntity> queryWrapper = new EntityWrapper<ShiwurenlingEntity>()
            .eq("shiwuzhaoling_id", shiwurenling.getShiwuzhaolingId())
            .eq("yonghu_id", shiwurenling.getYonghuId())
            .eq("yesno_types", shiwurenling.getYesnoTypes())
            .eq("shiwurenling_text", shiwurenling.getShiwurenlingText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiwurenlingEntity shiwurenlingEntity = shiwurenlingService.selectOne(queryWrapper);
        if(shiwurenlingEntity==null){
            shiwurenling.setInsertTime(new Date());
            shiwurenling.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shiwurenling.set
        //  }
        shiwurenlingService.insert(shiwurenling);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
