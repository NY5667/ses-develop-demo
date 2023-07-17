package com.supcon.ses.developer.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     通用服务
 * </p>
 *
 * @create 2023-07-14 17:19
 */
@Service
public class CommonService {
    
//    @Autowired
//    LoadBalancerClient loadBalancerClient;
//    /**
//     * 获取微服务实体
//     * @param moduleCode 模块编码
//     * @return 服务实例
//     */
//    public ServiceInstance getServiceInstance(String moduleCode) {
//        //微服务名称
//        //String serverName = baseApplicationsGroup.get("MSModule."+moduleCode);
//        //通过服务名与负载均衡规则获取实例信息
//        ServiceInstance serviceInstance = loadBalancerClient.choose(moduleCode);
//        return serviceInstance;
//    }

    /**
     * 获取系统编码信息
     * @param model
     * @return 系统编码信息集合
     */
    public List<?> getSystemCodes(String model){
        return null;
    }
}
