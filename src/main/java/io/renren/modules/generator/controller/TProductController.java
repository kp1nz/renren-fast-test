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

import io.renren.modules.generator.entity.TProductEntity;
import io.renren.modules.generator.service.TProductService;
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
@RequestMapping("generator/tproduct")
public class TProductController {
    @Autowired
    private TProductService tProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:tproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:tproduct:info")
    public R info(@PathVariable("id") Integer id){
		TProductEntity tProduct = tProductService.getById(id);

        return R.ok().put("tProduct", tProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:tproduct:save")
    public R save(@RequestBody TProductEntity tProduct){
		tProductService.save(tProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:tproduct:update")
    public R update(@RequestBody TProductEntity tProduct){
		tProductService.updateById(tProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:tproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		tProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
