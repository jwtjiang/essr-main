package zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2019/7/17.
 */
//@Component
public class CorsFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(CorsFilter.class);
    /**
     * 表示返回的类型，就是确定要进行什么样的操作
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 设置级别，数字越大级别越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示是否开启当前的拦截器 false 是不开启， true是开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 表示执行的代码，比如说请求的时候，进行身份的认证等..
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        log.info("已进入网关----------------------------------");
        RequestContext currentContext = RequestContext.getCurrentContext();
//        currentContext.set
        HttpServletRequest request = currentContext.getRequest();
        log.info(request.getMethod()+"------------------------");
        log.info(request.getRequestURL()+"---------aaaaa---------------");
        log.info(request.getAttribute("name")+"");
        String ip = getIpAddr(request);
        log.info("访问者ip------------:"+ip);
//        HttpSession session = currentContext.getRequest().getSession();
        Boolean a = false;
        if(a){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(200);
            try {
                currentContext.getResponse().setHeader("Content-Type", "text/html;charset=UTF-8");
                currentContext.getResponse().getWriter().write("登录信息为空！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return "成功";
    }

    //获取访问者ip用来做日志处理
    public String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}

