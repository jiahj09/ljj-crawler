package com.ljj.crawler.webspider.http;


import com.ljj.crawler.core.po.ExtractInfo;
import com.ljj.crawler.core.po.TaskInfo;
import com.ljj.crawler.core.Task;
import org.apache.http.client.CookieStore;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http 请求封装
 *
 * @author JIUN·LIU
 * @data 2020/2/12 13:58
 */
public class Request implements Task {
    // 任务id，用于全局同一条任务标识
    private String taskId;
    // http 请求方式(默认get请求)
    private Method method = Method.GET;
    // http 请求地址
    private String url;
    // http 请求头
    private Map<String, String> headers;

    private CookieStore cookieStore;

    // http 请求体（字符串格式[json、xml等]）
    private String requestBody;
    // http 请求体，键值对格式
    private Map<String, String> requestData;
    // 代理设置
    private Proxy proxy;
    // http 请求超时时间
    private Integer timeOut = 1000 * 20;
    // 是否忽略http状态码异常
    private boolean ignoreHttpErrors = true;
    // 是否302自动跳转
    private boolean followRedirects = true;
    // 是否忽略content type
    private boolean ignoreContentType = true;
    // 请求失败，重试次数，
    private Integer retryTime = 3;
    // 请求信息字符编码类型
    private String requestCharset;
    // 返回信息字符编码类型
    private String responseCharset;


    /**
     * 用于流程控制的参数
     *
     * @return
     */

    private String traceId;
    private String parentId;
    private List<String> parentTraceId = new ArrayList<>();


    public static Request create(Task task) {
        Request request = new Request();
        request.taskId = task.getTid();
        request.parentId = task.getPId();
        request.traceId = task.getTraceId();
        request.parentTraceId = task.getPTraceId();
        if (task instanceof TaskInfo)
            request.url = ((TaskInfo) task).getStartUrl();
        if (task instanceof ExtractInfo)
            request.url = ((ExtractInfo) task).getContent();
        return request;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setParentTraceId(List<String> parentTraceId) {
        this.parentTraceId = parentTraceId;
    }

    public String getRequestCharset() {
        return requestCharset;
    }

    public void setRequestCharset(String requestCharset) {
        this.requestCharset = requestCharset;
    }

    public String getResponseCharset() {
        return responseCharset;
    }

    public void setResponseCharset(String responseCharset) {
        this.responseCharset = responseCharset;
    }

    public Integer getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    public void setFollowRedirects(boolean followRedirects) {
        this.followRedirects = followRedirects;
    }

    public boolean isIgnoreContentType() {
        return ignoreContentType;
    }

    public void setIgnoreContentType(boolean ignoreContentType) {
        this.ignoreContentType = ignoreContentType;
    }

    public boolean isIgnoreHttpErrors() {
        return ignoreHttpErrors;
    }

    public void setIgnoreHttpErrors(boolean ignoreHttpErrors) {
        this.ignoreHttpErrors = ignoreHttpErrors;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }


    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, String> getRequestData() {
        return requestData;
    }

    public void setRequestData(Map<String, String> requestData) {
        this.requestData = requestData;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String getTid() {
        return this.taskId;
    }

    @Override
    public String getPId() {
        return this.parentId;
    }

    @Override
    public String getTraceId() {
        return this.traceId;
    }

    @Override
    public List<String> getPTraceId() {
        return this.parentTraceId;
    }


    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }


    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }
}
