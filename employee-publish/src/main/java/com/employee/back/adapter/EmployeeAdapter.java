package com.employee.back.adapter;

import com.employee.back.service.EmployeeService;
import com.employee.back.transformers.EmployeeTransformers;
import com.employee.common.util.AESUtil;
import com.employee.common.util.SessionUtil;
import com.employee.dto.EmployeeDTO;
import com.employee.param.EmployeeQueryParam;
import com.employee.request.EmployeeAddRequest;
import com.employee.request.EmployeeListParam;
import com.employee.vo.EmployeeVO;
import com.tan.kit.constant.FixedPageSizeEnum;
import com.tan.kit.constant.StateCode;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;
import com.tan.kit.guava2.Lists2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Tanlian
 * @create 2018-09-16 11:40
 **/
@Slf4j
@Service("employeeAdapter")
public class EmployeeAdapter {

    @Autowired
    private EmployeeService employeeService;

    public ResultDTO<Void> saveOrEditUser(EmployeeAddRequest addRequest) {
        ResultDTO<Void> resultDTO = getEmployeeRequest(addRequest);
        if (!resultDTO.isSuccess()) {
            return resultDTO;
        }
        EmployeeQueryParam queryParam = new EmployeeQueryParam();
        queryParam.setUsername(addRequest.getUsername());
        List<EmployeeDTO> employeeDTOs = employeeService.queryByParam(queryParam).getData();
        if (!CollectionUtils.isEmpty(employeeDTOs)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "用户已存在");
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setUsername(addRequest.getUsername());
        employeeDTO.setPhone(addRequest.getPhone());
        employeeDTO.setPublicKey(SessionUtil.PUBLIC_KEY);
        String password = addRequest.getPassword();
        String encryptPassword = AESUtil.encrypt(password, SessionUtil.PUBLIC_KEY);
        employeeDTO.setPassword(encryptPassword);
        String uuid = UUID.randomUUID().toString();
        employeeDTO.setUid(uuid.replace("-",""));
        employeeService.addOrUpdateUser(employeeDTO);
        return ResultDTO.successfy();
    }

    private ResultDTO<Void> getEmployeeRequest(EmployeeAddRequest addRequest) {
        if (addRequest == null) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入相关信息");
        }
        if (!StringUtils.hasText(addRequest.getUsername())) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入姓名");
        }
        if (addRequest.getUsername().length() > 5) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "姓名需控制在5个字以内");
        }
        String phone = addRequest.getPhone();
        if (!StringUtils.hasText(phone) || phone.length() > 11) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入11位手机号");
        }
        if (!StringUtils.hasText(addRequest.getPassword())) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入用户密码");
        }
        return ResultDTO.successfy();
    }

    public ResultDTO<Void> update(Set<Integer> employeeUserIds) {
        if (CollectionUtils.isEmpty(employeeUserIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择要禁用的用户");
        }
        employeeService.updateById(employeeUserIds);
        return ResultDTO.successfy();
    }

    public PageModel<EmployeeVO> list(EmployeeListParam listParam) {
        if (listParam == null) {
            return PageModel.emptyModel();
        }
        EmployeeQueryParam queryParam = new EmployeeQueryParam();
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        queryParam.setPage(listParam.getPage() * pageSize);
        queryParam.setPageSize(pageSize);
        queryParam.setNeedPagination(true);
        queryParam.setUsername(listParam.getUsername());
        queryParam.setPhone(listParam.getPhone());
        PageModel<EmployeeDTO> pageModel = employeeService.queryByParam(queryParam);
        List<EmployeeDTO> employeeDTOs = pageModel.getData();
        List<EmployeeVO> employeeVOs = Lists2.transform(employeeDTOs, EmployeeTransformers.DTO_TO_VO);
        log.info("列表参数", listParam);
        return PageModel.build(employeeVOs, pageModel.getTotalCount(), listParam.getPage(), pageSize);
    }
}
