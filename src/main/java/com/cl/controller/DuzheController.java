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

import com.cl.entity.DuzheEntity;
import com.cl.entity.view.DuzheView;

import com.cl.service.DuzheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 读者
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
@RestController
@RequestMapping("/duzhe")
public class DuzheController {
    @Autowired
    private DuzheService duzheService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		DuzheEntity u = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("zhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"duzhe",  "读者" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DuzheEntity duzhe){
    	//ValidatorUtils.validateEntity(duzhe);
    	DuzheEntity u = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("zhanghao", duzhe.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		duzhe.setId(uId);
        duzheService.insert(duzhe);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        DuzheEntity u = duzheService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	DuzheEntity u = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        duzheService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DuzheEntity duzhe,
		HttpServletRequest request){
        EntityWrapper<DuzheEntity> ew = new EntityWrapper<DuzheEntity>();

		PageUtils page = duzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duzhe), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DuzheEntity duzhe, 
		HttpServletRequest request){
        EntityWrapper<DuzheEntity> ew = new EntityWrapper<DuzheEntity>();

		PageUtils page = duzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duzhe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DuzheEntity duzhe){
       	EntityWrapper<DuzheEntity> ew = new EntityWrapper<DuzheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( duzhe, "duzhe")); 
        return R.ok().put("data", duzheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DuzheEntity duzhe){
        EntityWrapper< DuzheEntity> ew = new EntityWrapper< DuzheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( duzhe, "duzhe")); 
		DuzheView duzheView =  duzheService.selectView(ew);
		return R.ok("查询读者成功").put("data", duzheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DuzheEntity duzhe = duzheService.selectById(id);
		duzhe = duzheService.selectView(new EntityWrapper<DuzheEntity>().eq("id", id));
        return R.ok().put("data", duzhe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DuzheEntity duzhe = duzheService.selectById(id);
		duzhe = duzheService.selectView(new EntityWrapper<DuzheEntity>().eq("id", id));
        return R.ok().put("data", duzhe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
    	duzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duzhe);
    	DuzheEntity u = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("zhanghao", duzhe.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		duzhe.setId(new Date().getTime());
        duzheService.insert(duzhe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
    	duzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duzhe);
    	DuzheEntity u = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("zhanghao", duzhe.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		duzhe.setId(new Date().getTime());
        duzheService.insert(duzhe);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(duzhe);
        duzheService.updateById(duzhe);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        duzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
