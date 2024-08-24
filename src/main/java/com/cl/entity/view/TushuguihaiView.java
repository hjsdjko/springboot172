package com.cl.entity.view;

import com.cl.entity.TushuguihaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 图书归还
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
@TableName("tushuguihai")
public class TushuguihaiView  extends TushuguihaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushuguihaiView(){
	}
 
 	public TushuguihaiView(TushuguihaiEntity tushuguihaiEntity){
 	try {
			BeanUtils.copyProperties(this, tushuguihaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
