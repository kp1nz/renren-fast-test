package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TOrderEntity;
import io.renren.modules.generator.service.TOrderService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 13:43:38
 */
@RestController
@RequestMapping("generator/torder")
public class TOrderController {
    @Autowired
    private TOrderService tOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:torder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:torder:info")
    public R info(@PathVariable("id") Integer id){
		TOrderEntity tOrder = tOrderService.getById(id);

        return R.ok().put("tOrder", tOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:torder:save")
    public R save(@RequestBody TOrderEntity tOrder){
		tOrderService.save(tOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:torder:update")
    public R update(@RequestBody TOrderEntity tOrder){
		tOrderService.updateById(tOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:torder:delete")
    public R delete(@RequestBody Integer[] ids){
		tOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
