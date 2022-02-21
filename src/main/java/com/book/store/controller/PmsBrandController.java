package com.book.store.controller;

import com.book.store.api.CommonPage;
import com.book.store.api.CommonResult;
import com.book.store.mbg.model.PmsBrand;
import com.book.store.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Controller
@RequestMapping(value = "/brand")
public class PmsBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService demoService;

    /**
     * 获取全部品牌列表
     *
     * @return {@link CommonResult}<{@link List}<{@link PmsBrand}>>
     */
    @GetMapping(value = "/listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    /**
     * 添加品牌
     *
     * @param pmsBrand pms品牌
     * @return {@link CommonResult}
     */
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
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
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = demoService.updateBrand(id, pmsBrandDto);
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
    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
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
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    /**
     * 根据编号查询品牌信息
     *
     * @param id id
     * @return {@link CommonResult}<{@link PmsBrand}>
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id")Long id) {
        return CommonResult.success(demoService.getBrand(id));
    }
}
