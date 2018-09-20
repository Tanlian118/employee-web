package com.employee.back.adapter;

import com.employee.back.service.EmployeeProductService;
import com.employee.back.transformers.EmployeeProductTransformers;
import com.employee.dto.EmployeeProductDTO;
import com.employee.param.EmployeeProductQueryParam;
import com.employee.request.EmployeeProductListParam;
import com.employee.request.ProductAddRequest;
import com.employee.request.ProductListParam;
import com.employee.vo.ProductVO;
import com.google.common.collect.Lists;
import com.product.dto.ProductDTO;
import com.product.param.ProductQueryParam;
import com.product.service.ProductQueryService;
import com.tan.kit.constant.FixedPageSizeEnum;
import com.tan.kit.constant.StateCode;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;
import com.tan.kit.guava2.Lists2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 13:50
 **/
@Service("employeeProductAdapter")
public class EmployeeProductAdapter {

    @Autowired
    private ProductQueryService productQueryService;
    @Autowired
    private EmployeeProductService employeeProductService;

    public ResultDTO saveOrUpate(ProductAddRequest productRequest) {
        List<EmployeeProductDTO> employeeProductDTOs;
        if (productRequest.getEmployeeProductId() == null) {
            if (productRequest.getProductIds() == null) {
                return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择对应商品");
            }
            List<ProductDTO> productDTOs = productQueryService.queryProductByIds(productRequest.getProductIds());
            if (CollectionUtils.isEmpty(productDTOs)) {
                return ResultDTO.fail(StateCode.EMPTY_RESULT, "没有对应的商品信息");
            }
            employeeProductDTOs = Lists2.transform(productDTOs, EmployeeProductTransformers.DTO_TO_PRODUCT_DTO);
        } else {
            EmployeeProductDTO employeeProductDTO = EmployeeProductTransformers.REQUEST_TO_DTO.apply(productRequest);
            employeeProductDTOs = Lists.newArrayList(employeeProductDTO);
        }
        employeeProductService.saveOrUpdate(employeeProductDTOs);
        return ResultDTO.successfy();
    }

    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        if (CollectionUtils.isEmpty(employeeProductIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择要删除的商品");
        }
        employeeProductService.delete(employeeProductIds);
        return ResultDTO.successfy();
    }

    public PageModel<ProductVO> listProduct(ProductListParam listParam) {
        EmployeeProductQueryParam queryParam = new EmployeeProductQueryParam();
        queryParam.setNeedPagination(true);
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        queryParam.setPage(listParam.getPage() * pageSize);
        queryParam.setPageSize(pageSize);
        queryParam.setProductCode(listParam.getProductCode());
        queryParam.setProductName(listParam.getProductName());
        PageModel<EmployeeProductDTO> pageModel = employeeProductService.queryByParam(queryParam);
        List<EmployeeProductDTO> productDTOs = pageModel.getData();
        List<ProductVO> productVOs = Lists2.transform(productDTOs, EmployeeProductTransformers.DTO_TO_PRODUCT_VO);
        return PageModel.build(productVOs, pageModel.getTotalCount(), listParam.getPage(), pageSize);
    }

    public PageModel<ProductVO> listEmployeeProduct(EmployeeProductListParam listParam) {
        //传入查询参数
        ProductQueryParam queryParam = new ProductQueryParam();
        queryParam.setNeedPagination(true);
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        queryParam.setPage(listParam.getPage() * pageSize);
        queryParam.setPageSize(pageSize);
        queryParam.setProductCode(listParam.getProductCode());
        queryParam.setProductName(listParam.getProductName());
        //调用商品service的查询方法查出商品列表
        PageModel<ProductDTO> pageModel = productQueryService.queryParam(queryParam);
        List<ProductDTO> productDTOs = pageModel.getData();
        if (CollectionUtils.isEmpty(productDTOs)) {
            return PageModel.emptyModel();
        }
        List<ProductVO> productVOs = Lists2.transform(productDTOs, EmployeeProductTransformers.PRODUCT_DTO_TO_VO);
        //将商品列表返回controller
        return PageModel.build(productVOs, pageModel.getTotalCount(), listParam.getPage(), pageSize);
    }
}
