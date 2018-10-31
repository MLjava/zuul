package com.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.enums.CommonEnum;
import com.exception.HomeinnsException;
import com.utils.ResultUtils;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author：linma
 * @date: 2018/10/30 17:04
 * @email: linma@homeinns.com
 **/
@Component
public class ZuulFallBack implements FallbackProvider {


    @Override
    public String getRoute() {
        return "mybatis";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                String result = JSONObject.toJSON(ResultUtils
                        .failure(new HomeinnsException(CommonEnum.SERVER_IS_ERROR)))
                        .toString();
                return new ByteArrayInputStream(result.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                // headers设定
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
