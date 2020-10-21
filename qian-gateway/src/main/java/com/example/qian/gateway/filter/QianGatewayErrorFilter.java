package com.example.qian.gateway.filter;

import com.example.qian.entity.QianResponse;
import com.example.qian.utils.QianUtil;
import com.netflix.zuul.context.RequestContext;
import io.lettuce.core.dynamic.support.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class QianGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            QianResponse qianResponse = new QianResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            qianResponse = resolveExceptionMessage(message, serviceId, qianResponse);

            HttpServletResponse response = ctx.getResponse();
            QianUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, qianResponse);
            log.error("Zull sendError：{}", qianResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private QianResponse resolveExceptionMessage(String message, String serviceId, QianResponse qianResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return qianResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return qianResponse.message(serviceId + "服务不可用");
        }
        return qianResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}