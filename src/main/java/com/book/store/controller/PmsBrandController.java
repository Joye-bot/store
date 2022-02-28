package com.book.store.controller;

import com.book.store.api.CommonPage;
import com.book.store.api.CommonResult;
import com.book.store.mbg.model.PmsBrand;
import com.book.store.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品品牌管理控制器
 *
 * @author nndmw
 * @date 2022/02/18
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping(value = "/brand")
public class PmsBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService brandService;

    /**
     * 获取全部品牌列表
     *
     * @return {@link CommonResult}<{@link List}<{@link PmsBrand}>>
     */
    @ApiOperation("获取所有品牌列表")
    @GetMapping(value = "/listAll")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    /**
     * 添加品牌
     *
     * @param pmsBrand pms品牌
     * @return {@link CommonResult}
     */
    @ApiOperation("添加品牌")
    @PostMapping(value = "/create")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    /**
     * 更新品牌
     *
     * @param id          id
     * @param pmsBrandDto pms品牌dto
     * @param result      结果
     * @return {@link CommonResult}
     */
    @ApiOperation("更新指定id品牌信息")
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    /**
     * 删除品牌
     *
     * @param id id
     * @return {@link CommonResult}
     */
    @ApiOperation("删除指定id的品牌")
    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    /**
     * 根据品牌名称分页获取品牌列表
     *
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link CommonResult}<{@link CommonPage}<{@link PmsBrand}>>
     */
    @ApiOperation("分页查询品牌列表")
    @GetMapping(value = "/list")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        @ApiParam("页码") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3")
                                                        @ApiParam("每页数量") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    /**
     * 根据编号查询品牌信息
     *
     * @param id id
     * @return {@link CommonResult}<{@link PmsBrand}>
     */
    @ApiOperation("获取指定id的品牌详情")
    @GetMapping(value = "/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }
}
