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

import io.renren.modules.generator.entity.TUserEntity;
import io.renren.modules.generator.service.TUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 14:26:50
 */
@RestController
@RequestMapping("generator/tuser")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:tuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:tuser:info")
    public R info(@PathVariable("id") Integer id){
		TUserEntity tUser = tUserService.getById(id);

        return R.ok().put("tUser", tUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:tuser:save")
    public R save(@RequestBody TUserEntity tUser){
		tUserService.save(tUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:tuser:update")
    public R update(@RequestBody TUserEntity tUser){
		tUserService.updateById(tUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:tuser:delete")
    public R delete(@RequestBody Integer[] ids){
		tUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
