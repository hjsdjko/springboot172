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

import com.cl.entity.ZuoweiyuyueEntity;
import com.cl.entity.view.ZuoweiyuyueView;

import com.cl.service.ZuoweiyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 座位预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
@RestController
@RequestMapping("/zuoweiyuyue")
public class ZuoweiyuyueController {
    @Autowired
    private ZuoweiyuyueService zuoweiyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoweiyuyueEntity zuoweiyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("duzhe")) {
			zuoweiyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoweiyuyueEntity> ew = new EntityWrapper<ZuoweiyuyueEntity>();

		PageUtils page = zuoweiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoweiyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoweiyuyueEntity zuoweiyuyue, 
		HttpServletRequest request){
        EntityWrapper<ZuoweiyuyueEntity> ew = new EntityWrapper<ZuoweiyuyueEntity>();

		PageUtils page = zuoweiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoweiyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoweiyuyueEntity zuoweiyuyue){
       	EntityWrapper<ZuoweiyuyueEntity> ew = new EntityWrapper<ZuoweiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoweiyuyue, "zuoweiyuyue")); 
        return R.ok().put("data", zuoweiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoweiyuyueEntity zuoweiyuyue){
        EntityWrapper< ZuoweiyuyueEntity> ew = new EntityWrapper< ZuoweiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoweiyuyue, "zuoweiyuyue")); 
		ZuoweiyuyueView zuoweiyuyueView =  zuoweiyuyueService.selectView(ew);
		return R.ok("查询座位预约成功").put("data", zuoweiyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoweiyuyueEntity zuoweiyuyue = zuoweiyuyueService.selectById(id);
		zuoweiyuyue = zuoweiyuyueService.selectView(new EntityWrapper<ZuoweiyuyueEntity>().eq("id", id));
        return R.ok().put("data", zuoweiyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoweiyuyueEntity zuoweiyuyue = zuoweiyuyueService.selectById(id);
		zuoweiyuyue = zuoweiyuyueService.selectView(new EntityWrapper<ZuoweiyuyueEntity>().eq("id", id));
        return R.ok().put("data", zuoweiyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoweiyuyueEntity zuoweiyuyue, HttpServletRequest request){
    	zuoweiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoweiyuyue);
        zuoweiyuyueService.insert(zuoweiyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuoweiyuyueEntity zuoweiyuyue, HttpServletRequest request){
    	zuoweiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoweiyuyue);
        zuoweiyuyueService.insert(zuoweiyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuoweiyuyueEntity zuoweiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoweiyuyue);
        zuoweiyuyueService.updateById(zuoweiyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuoweiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
