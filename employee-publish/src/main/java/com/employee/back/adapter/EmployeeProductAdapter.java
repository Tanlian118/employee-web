package com.employee.back.adapter;

import com.employee.back.service.EmployeeProductService;
import com.employee.back.service.OrderProductService;
import com.employee.back.service.ProductQueryService;
import com.employee.back.transformers.EmployeeProductTransformers;
import com.employee.common.constant.FixedPageSizeEnum;
import com.employee.common.constant.StateCode;
import com.employee.common.dto.PageModel;
import com.employee.common.dto.ResultDTO;
import com.employee.common.guava2.Lists2;
import com.employee.dto.EmployeeProductDTO;
import com.employee.param.EmployeeProductQueryParam;
import com.employee.request.EmployeeProductListParam;
import com.employee.request.ProductAddRequest;
import com.employee.vo.EmployeeProductVO;
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
    @Autowired
    private OrderProductService orderProductService;

    public ResultDTO save(ProductAddRequest productRequest) {
        if (CollectionUtils.isEmpty(productRequest.getProductIds())) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择要添加的商品");
        }
        return ResultDTO.successfy();
    }

    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        if (CollectionUtils.isEmpty(employeeProductIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择要删除的商品");
        }
        employeeProductService.delete(employeeProductIds);
        return ResultDTO.successfy();
    }

    public PageModel<EmployeeProductVO> listProduct(EmployeeProductListParam listParam) {
        EmployeeProductQueryParam queryParam = new EmployeeProductQueryParam();
        queryParam.setNeedPagination(true);
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        queryParam.setPage(listParam.getPage() * pageSize);
        queryParam.setPageSize(pageSize);
        queryParam.setProductCode(listParam.getProductCode());
        queryParam.setProductName(listParam.getProductName());
        PageModel<EmployeeProductDTO> pageModel = employeeProductService.queryByParam(queryParam);
        List<EmployeeProductDTO> productDTOs = pageModel.getData();
        List<EmployeeProductVO> productVOs = Lists2.transform(productDTOs, EmployeeProductTransformers.DTO_TO_VO);
        return PageModel.build(productVOs, pageModel.getTotalCount(), listParam.getPage(), pageSize);
    }
}
