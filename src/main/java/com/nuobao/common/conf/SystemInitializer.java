package com.nuobao.common.conf;

import com.nuobao.common.http.HostServerIntegrationConfig;
import com.nuobao.common.http.HttpUtil;
import com.nuobao.common.util.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * 系统初始化
 *
 * @author Xu Chengzhi
 * @date 2017-09-17 Sep 13:03
 * @modify
 **/
@Service
public class SystemInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * spring容器加载完成后执行
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent()==null){
            /*
             * 初始化接口服务器配置
             */
            HostServerIntegrationConfig integrationConfig = ApplicationContextUtil.getBeanByClass(HostServerIntegrationConfig.class);
            if(integrationConfig!=null){
                integrationConfig.setHostServerUrlList(integrationConfig.getHostServerUrl());
                HttpUtil.setHostServerIntegrationConfig(integrationConfig);
            }

            logger.info("接口调用组件初始化完成！");
        }
    }
}