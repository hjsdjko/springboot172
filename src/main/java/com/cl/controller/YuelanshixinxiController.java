package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuelanshixinxiEntity;
import com.cl.entity.view.YuelanshixinxiView;

import com.cl.service.YuelanshixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 阅览室信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
@RestController
@RequestMapping("/yuelanshixinxi")
public class YuelanshixinxiController {
    @Autowired
    private YuelanshixinxiService yuelanshixinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuelanshixinxiEntity yuelanshixinxi,
		HttpServletRequest request){
        EntityWrapper<YuelanshixinxiEntity> ew = new EntityWrapper<YuelanshixinxiEntity>();

		PageUtils page = yuelanshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuelanshixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuelanshixinxiEntity yuelanshixinxi, 
		HttpServletRequest request){
        EntityWrapper<YuelanshixinxiEntity> ew = new EntityWrapper<YuelanshixinxiEntity>();

		PageUtils page = yuelanshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuelanshixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuelanshixinxiEntity yuelanshixinxi){
       	EntityWrapper<YuelanshixinxiEntity> ew = new EntityWrapper<YuelanshixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuelanshixinxi, "yuelanshixinxi")); 
        return R.ok().put("data", yuelanshixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuelanshixinxiEntity yuelanshixinxi){
        EntityWrapper< YuelanshixinxiEntity> ew = new EntityWrapper< YuelanshixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuelanshixinxi, "yuelanshixinxi")); 
		YuelanshixinxiView yuelanshixinxiView =  yuelanshixinxiService.selectView(ew);
		return R.ok("查询阅览室信息成功").put("data", yuelanshixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuelanshixinxiEntity yuelanshixinxi = yuelanshixinxiService.selectById(id);
		yuelanshixinxi = yuelanshixinxiService.selectView(new EntityWrapper<YuelanshixinxiEntity>().eq("id", id));
        return R.ok().put("data", yuelanshixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuelanshixinxiEntity yuelanshixinxi = yuelanshixinxiService.selectById(id);
		yuelanshixinxi = yuelanshixinxiService.selectView(new EntityWrapper<YuelanshixinxiEntity>().eq("id", id));
        return R.ok().put("data", yuelanshixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuelanshixinxiEntity yuelanshixinxi, HttpServletRequest request){
    	yuelanshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuelanshixinxi);
        yuelanshixinxiService.insert(yuelanshixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuelanshixinxiEntity yuelanshixinxi, HttpServletRequest request){
    	yuelanshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuelanshixinxi);
        yuelanshixinxiService.insert(yuelanshixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuelanshixinxiEntity yuelanshixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuelanshixinxi);
        yuelanshixinxiService.updateById(yuelanshixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuelanshixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
