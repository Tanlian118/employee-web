package com.employee.back.adapter;

import com.employee.back.service.UserService;
import com.employee.back.transformers.UserTransformers;
import com.employee.common.util.AESUtil;
import com.employee.common.util.SessionUtil;
import com.employee.dto.UserDTO;
import com.employee.param.UserQueryParam;
import com.employee.request.UserAddRequest;
import com.employee.request.UserListParam;
import com.employee.vo.UserVO;
import com.google.common.collect.Sets;
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
public class UserAdapter {

    @Autowired
    private UserService employeeService;

    public ResultDTO<Void> saveOrEditUser(UserAddRequest addRequest) {
        ResultDTO<Void> resultDTO = getEmployeeRequest(addRequest);
        if (!resultDTO.isSuccess()) {
            return resultDTO;
        }
        UserQueryParam queryParam = new UserQueryParam();
        queryParam.setUsername(addRequest.getUsername());
        List<UserDTO> employeeDTOs = employeeService.queryByParam(queryParam).getData();
        if (!CollectionUtils.isEmpty(employeeDTOs)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "用户已存在");
        }
        UserDTO employeeDTO = new UserDTO();
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

    private ResultDTO<Void> getEmployeeRequest(UserAddRequest addRequest) {
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

    public PageModel<UserVO> list(UserListParam listParam) {
        if (listParam == null) {
            return PageModel.emptyModel();
        }
        UserQueryParam queryParam = new UserQueryParam();
        int pageSize = FixedPageSizeEnum.getByPageSize(listParam.getPageSize()).getPageSize();
        queryParam.setPage(listParam.getPage() * pageSize);
        queryParam.setPageSize(pageSize);
        queryParam.setNeedPagination(true);
        queryParam.setUsername(listParam.getUsername());
        queryParam.setPhone(listParam.getPhone());
        queryParam.setUids(Sets.newHashSet(listParam.getUid()));
        PageModel<UserDTO> pageModel = employeeService.queryByParam(queryParam);
        List<UserDTO> employeeDTOs = pageModel.getData();
        List<UserVO> employeeVOs = Lists2.transform(employeeDTOs, UserTransformers.DTO_TO_VO);
        log.info("列表参数", listParam);
        return PageModel.build(employeeVOs, pageModel.getTotalCount(), listParam.getPage(), pageSize);
    }
}
