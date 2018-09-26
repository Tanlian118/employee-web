package com.employee.back.adapter;

import com.employee.back.service.EmployeeOrderProductService;
import com.employee.back.service.UserService;
import com.employee.back.transformers.EmployeeOrderTransformers;
import com.employee.dto.UserDTO;
import com.employee.dto.EmployeeOrderProductDTO;
import com.employee.param.EmployeeOrderProductParam;
import com.employee.param.UserQueryParam;
import com.employee.request.EmployeeOrderListParam;
import com.employee.vo.EmployeeOrderVO;
import com.google.common.collect.Sets;
import com.tan.dto.EmployeeOrderDTO;
import com.tan.kit.constant.FixedPageSizeEnum;
import com.tan.kit.dto.PageModel;
import com.tan.kit.guava2.Lists2;
import com.tan.param.EmployeeOrderQueryParam;
import com.tan.service.EmployeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tanlian
 * @create 2018-09-23 12:44
 **/
@Service("employeeOrderAdapter ")
public class EmployeeOrderAdapter {

    @Autowired
    EmployeeOrderService orderService;
    @Autowired
    UserService employeeService;
    @Autowired
    EmployeeOrderProductService employeeOrderProductService;


    public PageModel<EmployeeOrderVO> listOrder(EmployeeOrderListParam listParam) {
        if (listParam == null) {
            return PageModel.emptyModel();
        }
        EmployeeOrderQueryParam orderQueryParam = getEmployeeOrderListParam(listParam);
        PageModel<EmployeeOrderDTO> employeeOrderDTOs = orderService.queryByParam(orderQueryParam);
        List<EmployeeOrderDTO> orderDTOs = employeeOrderDTOs.getData();
        fillEmployeeInfo(orderDTOs);
        fillProductInfo(orderDTOs);
        List<EmployeeOrderVO> employeeOrderVOs = Lists2.transform(orderDTOs, EmployeeOrderTransformers.DTO_TO_VO);
        return PageModel.build(employeeOrderVOs, employeeOrderDTOs.getTotalCount());
    }

    private EmployeeOrderQueryParam getEmployeeOrderListParam(EmployeeOrderListParam listParam) {
        EmployeeOrderQueryParam orderQueryParam = new EmployeeOrderQueryParam();
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        orderQueryParam.setPageSize(pageSize);
        orderQueryParam.setUids(listParam.getUids());
        orderQueryParam.setOrderNos(listParam.getOrderNos());
        orderQueryParam.setPage(listParam.getPage() * pageSize);
        return orderQueryParam;
    }

    private void fillProductInfo(List<EmployeeOrderDTO> orderDTOs) {
        Set<String> orderNos = orderDTOs.stream()
                .map(EmployeeOrderDTO::getOrderNo)
                .collect(Collectors.toSet());
        EmployeeOrderProductParam orderProductParam = new EmployeeOrderProductParam();
        orderProductParam.setOrderNos(orderNos);
        List<EmployeeOrderProductDTO> orderProductDTOs = employeeOrderProductService.queryByParm(orderProductParam);
        Map<String, Integer> orderNoAndProductPriceMap = orderProductDTOs.stream()
                .collect(Collectors.toMap(EmployeeOrderProductDTO::getOrderNo, EmployeeOrderProductDTO::getProductPrice));
        orderDTOs.stream().forEach(v -> v.setProductPrice(orderNoAndProductPriceMap.get(v.getOrderNo())));
    }

    private void fillEmployeeInfo(List<EmployeeOrderDTO> employeeOrderDTOs) {
        Set<String> uids = employeeOrderDTOs.stream()
                .map(EmployeeOrderDTO::getUid)
                .collect(Collectors.toSet());
        UserQueryParam queryParam = new UserQueryParam();
        queryParam.setUids(Sets.newHashSet(uids));
        PageModel<UserDTO> pageModel = employeeService.queryByParam(queryParam);
        if (!pageModel.hasData()) {
            return;
        }
        List<UserDTO> employeeDTOs = pageModel.getData();
        Map<String, String> uidAndUsernameMap = employeeDTOs.stream()
                .collect(Collectors.toMap(UserDTO::getUid, UserDTO::getUsername));
        Map<String, String> uidAndPhoneMap = employeeDTOs.stream()
                .collect(Collectors.toMap(UserDTO::getUid, UserDTO::getPhone));
        employeeOrderDTOs.forEach(v -> v.setUsername(uidAndUsernameMap.get(v.getUsername())));
        employeeOrderDTOs.forEach(v -> v.setPhone(uidAndPhoneMap.get(v.getPhone())));
    }
}
