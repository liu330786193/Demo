/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package com.lyl.demo.plugin;

import com.lyl.skywalking.plugin.interceptor.enhance.EnhancedInstance;
import com.lyl.skywalking.plugin.interceptor.enhance.InstanceConstructorInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The <code>ControllerConstructorInterceptor</code> intercepts the Controller's constructor, in order to acquire the
 * mapping annotation, if exist.
 *
 * But, you can see we only use the first mapping value, <B>Why?</B>
 *
 * Right now, we intercept the controller by annotation as you known, so we CAN'T know which uri patten is actually
 * matched. Even we know, that costs a lot.
 *
 * If we want to resolve that, we must intercept the Spring MVC core codes, that is not a good choice for now.
 *
 * Comment by @wu-sheng
 */
public class ControllerConstructorInterceptor implements InstanceConstructorInterceptor {

    @Override
    public void onConstruct(EnhancedInstance objInst, Object[] allArguments) {
        System.out.println("进入了拦截器构造方法");
        String basePath = "";
        RequestMapping basePathRequestMapping = objInst.getClass().getAnnotation(RequestMapping.class);
        if (basePathRequestMapping != null) {
            if (basePathRequestMapping.value().length > 0) {
                basePath = basePathRequestMapping.value()[0];
            } else if (basePathRequestMapping.path().length > 0) {
                basePath = basePathRequestMapping.path()[0];
            }
        }
        EnhanceRequireObjectCache enhanceRequireObjectCache = new EnhanceRequireObjectCache();
        enhanceRequireObjectCache.setPathMappingCache(new PathMappingCache(basePath));
        objInst.setSkyWalkingDynamicField(enhanceRequireObjectCache);
    }
}
